package com.alucard.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * GuavaCache - 实现类似基于ConcurrentHashMap
 *
 * @author fengdao.lp
 * @date 2018/5/30
 */
public class CacheTest {
    /**
     * 定义最简单的Cache
     */
    private static final Cache<Integer, String> CACHE = CacheBuilder.newBuilder()
        // 初始容量为10
        .initialCapacity(10)
        // 并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
        .concurrencyLevel(5)
        // 设置cache中的数据在写入之后的存活时间为10秒
        .expireAfterWrite(10, TimeUnit.SECONDS)
        // 设置容量
        .maximumSize(5)
        // 构建cache实例
        .build();

    /**
     * 定义LoadingCache
     */
    private static final LoadingCache<Integer, String> CACHE_1 = CacheBuilder.newBuilder()
        // 给定时间内没有被读写则回收
        .refreshAfterWrite(3, TimeUnit.MINUTES)
        // 设置缓存最大容量为1000，超过1000之后就会按照LRU最近虽少使用算法来移除缓存项
        .maximumSize(1000)
        .build(new CacheLoader<Integer, String>() {
            @Override
            public String load(Integer key) throws Exception {
                // 当本地缓存没有命中则调用load方法从DB获取结果并缓存
                return "result";
            }
        });

    /**
     * 定义CallableCache
     */
    private static final Cache<Integer, String> CACHE_2 = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .build();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //testCache();
        //testCacheLoader();
        testCallable();
    }

    /**
     * 1.测试最简单的缓存情况Cache
     */
    private static void testCache() throws InterruptedException {
        CACHE.put(1, "hi");
        CACHE.put(2, "hi2");
        CACHE.put(3, "hi3");
        // 获取缓存
        for (int i = 0; i < 100; i++) {
            System.out.println(
                DateFormatUtils.format(new Date(), "HH:mm:ss") + "  key:1 ,value:" + CACHE.getIfPresent(1));
            TimeUnit.SECONDS.sleep(2);
        }
        // 显示清除缓存
        CACHE.invalidate(3);
        CACHE.invalidateAll(Sets.newHashSet(1, 2, 3));
        CACHE.invalidateAll();
    }

    /**
     * 1.测试LoadingCache
     * 2.CacheLoader：从缓存中取key值，不存在则调用load方法获取值；否则直接返回缓存中的值
     */
    private static void testCacheLoader() throws ExecutionException {
        CACHE_1.put(1, "test");
        System.out.println(CACHE_1.get(1));
        String value1 = CACHE_1.get(2);
        System.out.println(value1);
        String value2 = CACHE_1.get(2);
        System.out.println(value2);
    }

    /**
     * 1.测试Callable
     * 2.Callable：从缓存中取key值，不存在则调用load方法获取值；否则直接返回缓存中的值
     */
    private static void testCallable() throws ExecutionException {
        String result = CACHE_2.get(1, new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "haha";
            }
        });
        System.out.println(result);

        String result1 = CACHE_2.get(2, () -> "gege");
        System.out.println(result1);
    }
}
