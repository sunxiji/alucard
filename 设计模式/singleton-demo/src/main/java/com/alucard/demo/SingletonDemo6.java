package com.alucard.demo;

/**
 * @author alucard
 * @Description 双重检查[推荐用]
 * @Date Create in 19:17 2018/10/18
 */
public class SingletonDemo6 {
    private static volatile SingletonDemo6 singletonDemo6;

    private SingletonDemo6(){

    }

    public static SingletonDemo6 getInstance(){
        if (singletonDemo6==null){
            synchronized (SingletonDemo6.class){
                singletonDemo6 = new SingletonDemo6();
            }
        }
        return singletonDemo6;
    }
}
