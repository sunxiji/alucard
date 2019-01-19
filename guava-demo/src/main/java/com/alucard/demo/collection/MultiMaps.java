package com.alucard.demo.collection;

import com.alucard.vo.User;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MultiMaps {
    /**
     * 结果：
     * 按性别分组 = fengdao--[User{name='fengdao', age=0}, User{name='fengdao', age=0}]
     * 按性别分组 = liupeng--[User{name='liupeng', age=0}]
     */
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("liupeng");
        user1.setId(1L);
        User user2 = new User();
        user2.setName("fengdao");
        user2.setId(2L);
        User user3 = new User();
        user3.setName("fengdao");
        user3.setId(2L);
        List<User> list = Lists.newArrayList(user1, user2, user3);
        Multimap<String, User> multimap1 = ArrayListMultimap.create();
        list.forEach(user -> {
            multimap1.put(user.getName(), user);
        });
        Map<String, Collection<User>> sex = multimap1.asMap();
        for (Map.Entry<String, Collection<User>> p : sex.entrySet()) {
            System.out.println("按性别分组 = " + p.getKey() + "--" + p.getValue());
        }
    }
}
