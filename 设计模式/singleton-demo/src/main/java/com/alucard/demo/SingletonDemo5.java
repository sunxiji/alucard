package com.alucard.demo;

/**
 * @author alucard
 * @Description 懒汉式(线程安全，同步代码块)[不可用]
 * @Date Create in 19:15 2018/10/18
 */
public class SingletonDemo5 {
    private static SingletonDemo5 singletonDemo5;

    private SingletonDemo5(){

    }

    public static SingletonDemo5 getInstance(){
        if (singletonDemo5 == null){
            synchronized (SingletonDemo5.class){
                singletonDemo5 = new SingletonDemo5();
            }
        }
        return singletonDemo5;
    }
}
