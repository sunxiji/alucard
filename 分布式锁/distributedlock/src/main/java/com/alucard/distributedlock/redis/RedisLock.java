package com.alucard.distributedlock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author alucard
 * @Description
 * @Date Create in 9:46 2018/9/17
 */
@Component
public class RedisLock {

    @Autowired
    RedisTemplate redisTemplate;
    /**
     *
     * @param lockKey 锁的key
     * @param acqireTimeout 获取锁的超时时间
     * @param timeout 拥有锁的超时时间
     * @return
     */
    public String lock(String lockKey,long acqireTimeout,long timeout){
        // 锁的key
        String key = "redislock:"+lockKey;
        // 锁的value
        String value = UUID.randomUUID().toString();
        // 拥有锁的超时时间
        int expirelockTime = (int)(timeout/1000);
        // 没有获取到锁的超时时间
        long endTime = System.currentTimeMillis()+acqireTimeout;
        while(System.currentTimeMillis()<endTime){
            //使用setnx设置锁
            if (redisTemplate.opsForValue().setIfAbsent(key,value)){
                // 设置过期时间
                redisTemplate.expire(key,expirelockTime,TimeUnit.SECONDS);

                return value;
            }
        }

        return null;
    }

    public boolean releaseLock(String lockKey,String value){
        String lockName = "redislock:"+lockKey;
        // value是否和redis中的一致
        if (value.equals(redisTemplate.opsForValue().get(lockName))){
            // 删除该redis
            redisTemplate.delete(lockName);
            System.out.println(value + "解锁成功......");
            return true;
        }
        return false;
    }
}
