package com.alucard.demo.base;

import com.google.common.base.Preconditions;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        Object obj = null;
        // a
        System.out.println(Preconditions.checkNotNull("a"));
        // NullPointerException
        System.out.println(Preconditions.checkNotNull(obj));

        Preconditions.checkArgument("".equalsIgnoreCase("a"));
        Preconditions.checkArgument(2 > 3);
    }
}
