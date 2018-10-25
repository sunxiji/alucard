package com.alucard.demo;

/**
 * @author alucard
 * @Description 饿汉式（静态代码块）[可用]
 * @Date Create in 19:09 2018/10/18
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    static{
        instance = new SingletonDemo2();
    }

    private SingletonDemo2(){

    }

    public static SingletonDemo2 getInstance(){
        return instance;
    }
}
