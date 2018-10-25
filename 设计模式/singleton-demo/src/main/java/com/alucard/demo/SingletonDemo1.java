package com.alucard.demo;

/**
 * @author alucard
 * @Description 饿汉式（静态常量）
 * @Date Create in 18:57 2018/10/18
 */
public class SingletonDemo1 {

    private final static SingletonDemo1 INSTANCE = new SingletonDemo1();

    private SingletonDemo1() {

    }

    public static SingletonDemo1 getInstance() {
        return INSTANCE;
    }

}
