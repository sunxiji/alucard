package com.alucard.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:45 2018/10/27
 */
public class Cglib implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是中介,你买房开始交给我了");
        Object invoke = methodProxy.invokeSuper(o,objects);
        System.out.println("我是中介,你买房结束了");
        return invoke;
    }
}
