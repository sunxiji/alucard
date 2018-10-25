package com.alucard.demo;

/**
 * @author alucard
 * @Description 懒汉式(线程不安全)[不可用]
 * @Date Create in 19:11 2018/10/18
 */
public class SingletonDemo3 {
    private static SingletonDemo3 singletonDemo3;

    private SingletonDemo3(){

    }

    public static SingletonDemo3 getInstance(){
        if (singletonDemo3 == null){
            singletonDemo3 = new SingletonDemo3();
        }
        return singletonDemo3;
    }
}
