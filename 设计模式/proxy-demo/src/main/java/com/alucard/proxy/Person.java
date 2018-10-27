package com.alucard.proxy;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:30 2018/10/27
 */
public class Person implements House {
    @Override
    public void buyHouse() {
        System.out.println("我是alucard,我可以买房了");
    }
}
