package com.alucard.demo.collection;

import com.alucard.vo.User;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class IterablesTest {

    public static List<User> list = Lists.newArrayList();

    static {
        User user1 = new User();
        user1.setId(1L);
        user1.setUserName("liupeng");
        User user2 = new User();
        user2.setId(2L);
        user2.setUserName("fengdao");
        list = Lists.newArrayList(user1, user2);
    }

    /**
     * 查找
     */
    public static void find() {
        // ﻿从集合中查找符合条件的某个对象.结果为：User{id=2, userName='fengdao', password='null'}
        User user = Iterables.find(list, new Predicate<User>() {
            @Override
            public boolean apply(@Nullable User input) {
                return input != null && input.getId() > 0;
            }
        });
        System.out.println(user);
    }

    /**
     * 任意匹配
     */
    public static void match() {
        boolean flag = Iterables.any(list, new Predicate<User>() {
            @Override
            public boolean apply(@Nullable User input) {
                return Objects.equals(input.getUserName(), "fengdao");
            }
        });
        System.out.println(flag);
    }

    /**
     * 过滤
     */
    public static void filter() {
        // 从集合中过滤出不为空的数据
        Iterable<User> user = Iterables.filter(list, Predicates.<User>notNull());
        user.forEach(System.out::println);

        // 可以用Collections2代替
        List<String> list2 = Lists.newArrayList("liupeng", "fanlai", "qingzhu");
        Collection<String> result2 = Collections2.filter(list2, Predicates.containsPattern("fanlai"));
        result2.forEach(System.out::println);

        // 可以用Collections2代替
        List<Integer> list3 = Lists.newArrayList(1, 2, 3);
        Collection collection = Collections2.filter(list3, new Predicate<Integer>() {
            @Override
            public boolean apply(@Nullable Integer input) {
                if (input > 1) {
                    return true;
                }
                return false;
            }
        });
        collection.forEach(System.out::println);
    }

    /**
     * 转换
     */
    public static void transform() {
        List<String> list = Lists.newArrayList("liupeng", "fanlai", "qingzhu");
        List<String> result = Lists.transform(list, new Function<String, String>() {
            @Override
            public String apply(@Nullable String input) {
                return input + "1";
            }
        });
        result.forEach(System.out::println);
    }

    public static void main(String[] args) {
        find();
        match();
        filter();
        transform();
    }
}
