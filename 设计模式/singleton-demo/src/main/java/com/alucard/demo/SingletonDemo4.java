package com.alucard.demo;

/**
 * @author alucard
 * @Description 懒汉式(线程安全，同步方法)[不推荐用]
 * @Date Create in 19:13 2018/10/18
 */
public class SingletonDemo4 {
    private static SingletonDemo4 singletonDemo4;

    private SingletonDemo4(){

    }

    public static synchronized SingletonDemo4 getInstance(){
        if (singletonDemo4 == null){
            singletonDemo4 = new SingletonDemo4();
        }
        return singletonDemo4;
    }
}
