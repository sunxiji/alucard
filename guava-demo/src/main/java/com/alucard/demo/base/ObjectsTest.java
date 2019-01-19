package com.alucard.demo.base;

import java.util.Objects;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class ObjectsTest {
    public static void main(String[] args) {
        // false
        Object x = null;
        Object y = new Object();
        System.out.println(Objects.equals(x, y));
    }
}
