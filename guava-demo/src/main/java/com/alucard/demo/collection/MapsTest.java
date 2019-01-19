package com.alucard.demo.collection;

import com.alucard.vo.User;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Maps
 *
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class MapsTest {

    /**
     * List -> Map 主键当做map的key，转换后具有唯一key。
     */
    public static Map<Long, User> listToMap() {
        User user1 = new User();
        user1.setName("liupeng");
        user1.setId(1L);
        User user2 = new User();
        user2.setName("fengdao");
        user2.setId(2L);
        // 结果为：{1=User{name='liupeng', age=0}, 2=User{name='fengdao', age=0}}
        List<User> list = Lists.newArrayList(user1, user2);
        Map<Long, User> map3 = Maps.uniqueIndex(list, new Function<User, Long>() {
            @Override
            public Long apply(@Nullable User input) {
                return input.getId();
            }
        });
        System.out.println("###listToMap###：" + map3);
        return map3;
    }

    /**
     * Set -> Map Maps.uniqueIndex相反的作用
     */
    public static void setToMap() {
        User user1 = new User();
        user1.setName("liupeng");
        user1.setId(1L);
        User user2 = new User();
        user2.setName("fengdao");
        user2.setId(2L);
        // 结果为：{User{id=1, name='liupeng'}=1, User{id=2, name='fengdao'}=2}
        Set set = Sets.newHashSet(user1, user2);
        Map<User, String> map4 = Maps.asMap(set, new Function() {
            @Override
            public Object apply(Object input) {
                return ((User) input).getId();
            }
        });
        System.out.println(map4);
    }

    /**
     * 转换Map中的值
     */
    public static void transform() {
        Map<Long, User> map = listToMap();
        Map<Long, String> result = Maps.transformValues(map, new Function<User, String>() {
            @Override
            public String apply(@Nullable User input) {
                return input.getName();
            }
        });
        // {1=liupeng, 2=fengdao}
        System.out.println(result);
    }

    /**
     * ﻿筛选map中符合条件的映射
     */
    public static void filter() {
        Map<Long, User> map = listToMap();
        map = Maps.filterEntries(map, new Predicate<Entry<Long, User>>() {
            @Override
            public boolean apply(Entry<Long, User> input) {
                return input.getKey() != null && input.getValue() != null;
            }
        });
        map = Maps.filterKeys(map, new Predicate<Long>() {
            @Override
            public boolean apply(@Nullable Long input) {
                return input != null && input > 1;
            }
        });
        map = Maps.filterValues(map, new Predicate<User>() {
            @Override
            public boolean apply(@Nullable User input) {
                return input != null && input.getId() > 1;
            }
        });
        System.out.println(map);
    }

    public static void main(String[] args) {
        Map<String, Map<String, String>> map1 = Maps.newHashMap();
        Map<String, Object> map2 = Maps.newHashMap(new HashMap<String, Object>() {{
            put("id", 1);
            put("name", "fengdao");
        }});
        listToMap();
        setToMap();
        transform();
        filter();
    }
}
