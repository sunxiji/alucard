package com.alucard.distributedlock;

import com.alucard.distributedlock.redis.LockCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private String lockName = "lock";

    /**
     * 显示锁的过期时间
     */
    @Before
    public void showLockExpireTime() {
        new Thread(() -> {
            while (true) {
                try {
                    Jedis jedis = new Jedis("localhost");
                    Thread.sleep(5000);
                    System.out.println("锁的过期时间:" + jedis.ttl(lockName) + "秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void set() {
        String key = "alucard";
        String value = UUID.randomUUID().toString();
        //setIfAbsent 就是setnx
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, value);
        System.out.println("flag:" + flag);
    }

    @Test
    public void testLockCase(){
        //定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 10,
                1, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        //添加10个线程获取锁
        for (int i = 0; i < 10; i++) {
            pool.submit(() -> {
                try {
                    Jedis jedis = new Jedis("localhost");
                    LockCase lock = new LockCase(jedis, lockName);
                    lock.lock();

                    //模拟业务执行15秒
                    lock.sleepBySencond(15);

                    lock.unlock();
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

        //当线程池中的线程数为0时，退出
        while (pool.getPoolSize() != 0) {}
    }

}
