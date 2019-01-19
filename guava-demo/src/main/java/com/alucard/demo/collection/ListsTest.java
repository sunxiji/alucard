package com.alucard.demo.collection;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class ListsTest {

    /**
     * 创建
     */
    public static void create() {
        // 获取list
        List<List<Map<String, String>>> list = Lists.newArrayList();

        // 默认初始大小
        Lists.newArrayListWithCapacity(100);

        List<String> list1 = Lists.newArrayList("a", "b");
        System.out.println(list1);
    }

    /**
     * 过滤
     */
    public static void filter() {
        // 过滤含有"liupeng"字符串的元素。只能是CharSequence类型或其子类。输出为liupeng
        List<String> list1 = Lists.newArrayList("liupeng", "fanlai", "qingzhu");

        Iterable<String> result = Iterables.filter(list1, Predicates.containsPattern("liupeng"));
        result.forEach(System.out::println);

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

        // 过滤不为null的元素
        List<String> list4 = Lists.newArrayList("liupeng", null, "qingzhu");
        Iterable<String> iterable = Iterables.filter(list4, Predicates.notNull());
        System.out.println(iterable);
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
        filter();
        transform();
    }
}
