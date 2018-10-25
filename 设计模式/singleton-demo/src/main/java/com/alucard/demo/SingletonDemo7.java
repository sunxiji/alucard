package com.alucard.demo;

/**
 * @author alucard
 * @Description 静态内部类[推荐用]
 * @Date Create in 19:19 2018/10/18
 */
public class SingletonDemo7 {
    private SingletonDemo7(){}

    private static class SingletonInstance{
        private static final SingletonDemo7 INSTANCE = new SingletonDemo7();
    }

    public static SingletonDemo7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
