package com.alucard.demo.collection;

import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Set;

/**
 * 不可变集合 - ﻿ImmutableSet
 *
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class ImmutableSetTest {
    public static void main(String[] args) {
        // 通过Builder创建
        Set<String> set1 = ImmutableSet.<String>builder().add("red", "red", "black").build();
        set1.forEach(System.out::println);
        set1 = ImmutableSet.<String>builder().add("red").add("b").build();
        set1.forEach(System.out::println);

        // 通过of创建
        Set<String> set2 = ImmutableSet.of("red", "black");
        set2.forEach(System.out::println);

        // 通过copyOf创建
        Set<String> set3 = ImmutableSet.copyOf(new String[]{"red", "black"});
        set3.forEach(System.out::println);

        // 转不可变List
        List<String> list = ImmutableSet.of("red", "black").asList();
        list.forEach(System.out::println);
    }
}
