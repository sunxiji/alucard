package com.alucard.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:33 2018/10/13
 */
public class UserEntity {
    public String username ;

    public UserEntity(){
        System.out.println("对象初始化");
    }

    private UserEntity(String userName){
        System.out.println("userName:"+userName);
        this.username = userName;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.new的方式
//        UserEntity userEntity = new UserEntity();
//        userEntity.username = "alucard";
//        System.out.println(userEntity.username);

        //2.反射的方式
        Class<?> aClass = Class.forName("com.alucard.entity.UserEntity");
        Object o = aClass.newInstance();
        UserEntity ue = (UserEntity) o;
        ue.username = "alucard";
        System.out.println(ue.username);
        System.out.println("---------------");
        //反射的应用场景 1.jdbc连接 springIOC底层使用反射机制+DOM4J 2.框架hibernate,mybatis 使用反射机制
        //使用反射机制获取类的信息
        Method[] methods = aClass.getMethods();
        for (Method m:methods) {
            System.out.println(m.getName());
        }
        System.out.println("---------------");
        //获取类的属性
        Field[] fields = aClass.getDeclaredFields();
        for (Field f:fields){
            System.out.println(f.getName());
        }
        System.out.println("---------------");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        UserEntity userEntity = (UserEntity) constructor.newInstance("alucard");
        System.out.println(userEntity.username);
    }
}
