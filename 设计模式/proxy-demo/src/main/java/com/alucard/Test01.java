package com.alucard;

import com.alucard.proxy.*;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:33 2018/10/27
 */
public class Test01 {
    public static void main(String[] args) {
        House house =new Agency(new Person());
        house.buyHouse();

        System.out.println("--------------------------");
        System.out.println("--------JDK动态代理----------");
        Person person = new Person();
        JdkProxy jdkProxy = new JdkProxy(person);
        House house1 = (House) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), jdkProxy);
        house1.buyHouse();

        System.out.println("--------------------------");
        System.out.println("--------cglib动态代理----------");
        Cglib cglib = new Cglib();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(cglib);
        House house2 = (House) enhancer.create();
        house2.buyHouse();
    }
}
