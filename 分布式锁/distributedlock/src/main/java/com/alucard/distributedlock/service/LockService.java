package com.alucard.distributedlock.service;

import com.alucard.distributedlock.annotation.DistributedLock;
import com.alucard.distributedlock.redis.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author alucard
 * @Description 某一个业务场景,中间使用分布式锁
 * @Date Create in 10:31 2018/9/17
 */
@Service
public class LockService {
    @Autowired
    RedisLock redisLock;

    public void seckill(){
        String identifier = redisLock.lock("alucard", 5000L, 5000L);
        if (StringUtils.isEmpty(identifier)) {
            // 获取锁失败
            System.out.println(Thread.currentThread().getName() + ",获取锁失败，原因时间超时!!!");
            return;
        }
        System.out.println(Thread.currentThread().getName() + "获取锁成功,锁id identifier:" + identifier + "，执行业务逻辑");

        // 此处模拟业务处理
        try {
            Thread.sleep(300);
        } catch (Exception e) {

        }
        // 释放锁
        boolean releaseLock = redisLock.releaseLock("alucard", identifier);
        if (releaseLock) {
            System.out.println(Thread.currentThread().getName() + "释放锁成功,锁id identifier:" + identifier);
        }
    }

    @DistributedLock(key="alucard",acqireTimeout = 5000L,timeout = 5000L)
    public void flashSale(){

        // 此处模拟业务处理
        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }

    }
}
