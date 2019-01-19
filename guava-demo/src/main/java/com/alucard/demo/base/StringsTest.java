package com.alucard.demo.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author fengdao.lp
 * @date 2018/7/16
 */
public class StringsTest {

    /**
     * 基本操作
     */
    public static void base() {
        // 初始化 + 判空
        // null
        System.out.println(Strings.emptyToNull(""));
        // ""
        System.out.println(Strings.nullToEmpty(null));
        // aa
        System.out.println(Strings.emptyToNull("aa"));
        System.out.println(Strings.nullToEmpty("aa"));
        // true
        System.out.println(Strings.isNullOrEmpty(""));
        // false
        System.out.println(Strings.isNullOrEmpty("aaa"));

        // 求两个字符串公共前缀部分  com.alibaba.core.
        String a = "com.alibaba.core.hello";
        String b = "com.alibaba.core.world";
        String prefix = Strings.commonPrefix(a, b);
        System.out.println(prefix);
        // 求两个字符串公共后缀部分  a.Hello
        String c = "com.alibaba.Hello";
        String d = "com.alimama.Hello";
        String suffix = Strings.commonSuffix(c, d);
        System.out.println(suffix);

        // 填充
        // 1123
        System.out.println(Strings.padStart("23", 4, '1'));
        // 2311
        System.out.println(Strings.padEnd("23", 4, '1'));

        // 重复
        // 123123
        System.out.println(Strings.repeat("123", 2));
    }

    /**
     * 字符串拆分
     */
    public static void splitter() {
        // 基础分割：结果为[1, 2, 3]
        String input1 = "1  ,2,3";
        List<String> a = Splitter.on(",").trimResults().splitToList(input1);
        System.out.println(a);

        // 多个字符进行分割：结果为[1, 2, 3, 4, 5, 6]
        String input2 = "1,2,,3,,.4.5,6";
        List<String> b = Splitter.onPattern("[.|,]").trimResults().omitEmptyStrings().splitToList(input2);
        System.out.println(b);

        // 每隔多少个字符进行分割：结果为[hel, lo , wor, ld]
        String input3 = "hello world";
        List<String> c = Splitter.fixedLength(3).splitToList(input3);
        System.out.println(c);

        // 限分割多少个字符后停止：结果为[a, b, c, d;e]
        String input4 = "a;b;c;d;e";
        List<String> d = Splitter.on(";").limit(4).splitToList(input4);
        System.out.println(d);

        // 分割字符串到MAP中：结果为{id=1, name=fengdao}
        String input5 = "id:1,name:fengdao";
        Map<String, String> map1 = Splitter.on(",").withKeyValueSeparator(":").split(input5);
        System.out.println(map1);
    }

    /**
     * 字符串连接
     */
    public static void join() {
        // 连接字符串：结果为：a; b
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("a", null, "b"));

        // 连接字符串：结果为a,,b  和  a,,!,b
        List<String> list = Lists.newArrayList("a", "", null, "b");
        System.out.println(Joiner.on(",").skipNulls().join(list));
        System.out.println(Joiner.on(",").useForNull("!").join(list));

        // 连接字符串,提供对StringBuilder的追加：结果为：prefixa; b
        StringBuilder sb = new StringBuilder("prefix");
        joiner.appendTo(sb, new String[] {"a", "b"});
        System.out.println(sb);

        // MapJoiner：结果为：name->liupeng,id->1
        Joiner.MapJoiner mapJoiner = Joiner.on(",").withKeyValueSeparator("->");
        System.out.println(mapJoiner.join(Maps.newHashMap(new HashMap<String, Object>() {{
            put("id", 1);
            put("name", "liupeng");
        }})));
    }

    public static void main(String[] args) {
        base();
        splitter();
        join();
    }

}
