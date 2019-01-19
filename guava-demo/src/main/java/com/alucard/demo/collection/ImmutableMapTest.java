package com.alucard.demo.collection;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class ImmutableMapTest {
    public static void main(String[] args) {
        // 结果为：{k=v}
        Map<String, String> map = ImmutableMap.of("k", "v");
        System.out.println(map);

        // 结果为：{liu=1}
        Map<String, Object> map1 = ImmutableMap.<String, Object>builder().put("liu", 1).build();
        System.out.println(map1);
    }
}
