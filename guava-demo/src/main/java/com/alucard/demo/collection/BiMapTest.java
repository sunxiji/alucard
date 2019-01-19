package com.alucard.demo.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("name", "liupeng");
        biMap.put("age", "26");
        // liupeng
        System.out.println(biMap.get("name"));
        // name
        System.out.println(biMap.inverse().get("liupeng"));
    }
}
