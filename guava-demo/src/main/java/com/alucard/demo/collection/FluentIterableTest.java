package com.alucard.demo.collection;

import com.alucard.vo.User;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class FluentIterableTest {

    /**
     * 过滤、转换等功能，结果为：[7]
     */
    public static void feature() {
        // 操作String1
        List<String> list1 = Lists.newArrayList("liupeng", null, "qingzhu");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String input) {
                return null == input ? false : input.startsWith("liu") || input.startsWith("feng");
            }
        };
        Function<String, Integer> function = new Function<String, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable String input) {
                return input.length();
            }
        };
        Collection<Integer> names = FluentIterable
            .from(list1)
            .filter(predicate)
            .transform(function)
            .toList();
        System.out.println(names);
    }

    /**
     * 任意匹配
     */
    public static void match() {
        boolean flag = FluentIterable.from(IterablesTest.list).anyMatch(new Predicate<User>() {
            @Override
            public boolean apply(@Nullable User input) {
                return input.getId() > 0;
            }
        });
        System.out.println(flag);
    }

    /**
     * 转换
     * 结果为[liupeng#1, fengdao#2]
     */
    public static void transform() {
        List<String> result = FluentIterable.from(IterablesTest.list)
            .transform(new Function<User, String>() {
                @Nullable
                @Override
                public String apply(@Nullable User input) {
                    return Joiner.on("#").join(input.getUserName(), input.getId());
                }
            }).toList();
        System.out.println(result);

        // 过滤相同的对象
        // ﻿Set<Person> persons =  FluentIterable.from(personList).toSet();
    }

    public static void main(String[] args) {
        feature();
        match();
        transform();
    }
}
