package com.alucard.test;

import com.alucard.demo.SingletonDemo3;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:04 2018/10/27
 */
public class Test01 {
    public static void main(String[] args) {
        SingletonDemo3 s1 = SingletonDemo3.getInstance();
        SingletonDemo3 s2 = SingletonDemo3.getInstance();
        System.out.println(s1==s2);
    }
}
