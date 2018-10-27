package com.alucard.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author alucard
 * @Description jdk动态代理
 * @Date Create in 14:36 2018/10/27
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是中介,你买房开始交给我了");
        Object invoke = method.invoke(target, args);
        System.out.println("我是中介,你买房结束了");
        return invoke;
    }
}
