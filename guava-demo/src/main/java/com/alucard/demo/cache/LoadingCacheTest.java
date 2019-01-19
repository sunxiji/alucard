package com.alucard.demo.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.alucard.vo.ApiVO;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.rits.cloning.Cloner;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fengdao.lp
 * @date 2018/8/21
 */
public class LoadingCacheTest {

    private static Cloner cloner = new Cloner();

    /**
     * 定义LoadingCache
     */
    private static final LoadingCache<String, ApiVO> CACHE = CacheBuilder.newBuilder()
        // 给定时间内没有被读写则回收
        .refreshAfterWrite(30, TimeUnit.MINUTES)
        // 设置并发级别为10，并发级别是指可以同时写缓存的线程数
        .concurrencyLevel(10)
        // 设置缓存最大容量为1000，超过1000之后就会按照LRU最近虽少使用算法来移除缓存项
        .maximumSize(1000)
        .build(new CacheLoader<String, ApiVO>() {
            @Override
            public ApiVO load(String key) throws Exception {
                // 当本地缓存没有命中则调用load方法从DB获取结果并缓存
                return new ApiVO();
            }
        });

    public static ApiVO get(String cacheId) throws ExecutionException {
        ApiVO apiVO = CACHE.get(cacheId);
        if (null != apiVO) {
            Object cloneData = cloner.deepClone(apiVO);
            return (ApiVO)cloneData;
        }
        return null;
    }

    public static void set(String cacheId, ApiVO apiVO) {
        ApiVO apiVO1 = cloner.deepClone(apiVO);
        CACHE.put(cacheId, apiVO1);
    }

    public static void main(String[] args) throws ExecutionException {

        ApiVO a = get("key");
        if (null != a && StringUtils.isNoneBlank(a.getName())) {
            System.out.println(a);
        } else {
            ApiVO apiVO = new ApiVO();
            apiVO.setName("测试");
            set("key", apiVO);
        }

        System.out.println(get("key"));
    }
}
