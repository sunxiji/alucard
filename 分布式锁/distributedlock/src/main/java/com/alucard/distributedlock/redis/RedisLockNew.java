package com.alucard.distributedlock.redis;

import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:36 2018/10/8
 */
public abstract class RedisLockNew implements Lock {
    // 连接redis的客户端
    protected Jedis jedis;
    // 分布式锁的key
    protected String lockKey;
    // 分布式锁的value
    protected String lockValue;
    // 是否过期
    protected volatile boolean isOpenExpirationRenewal = true;

    /**
     * 构造方法
     * @param jedis
     * @param lockKey
     */
    public RedisLockNew(Jedis jedis, String lockKey) {
        this(jedis, lockKey, UUID.randomUUID().toString()+Thread.currentThread().getId());
    }

    /**
     * 构造方法
     * @param jedis
     * @param lockKey
     * @param lockValue
     */
    public RedisLockNew(Jedis jedis, String lockKey, String lockValue) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.lockValue = lockValue;
    }

    /**
     * 休眠的方法
     * @param sencond
     */
    public void sleepBySencond(int sencond){
        try {
            Thread.sleep(sencond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启定时刷新
     */
    protected void scheduleExpirationRenewal(){
        Thread renewalThread = new Thread(new ExpirationRenewal());
        renewalThread.start();
    }

    @Override
    public void lockInterruptibly(){}

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit){
        return false;
    }


    /**
     * 刷新key的过期时间
     */
    private class ExpirationRenewal implements Runnable{
        @Override
        public void run() {
            while (isOpenExpirationRenewal){
                System.out.println("执行延迟失效时间中...");

                String checkAndExpireScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                        "return redis.call('expire',KEYS[1],ARGV[2]) " +
                        "else " +
                        "return 0 end";
                jedis.eval(checkAndExpireScript, 1, lockKey, lockValue, "30");

                //休眠10秒
                sleepBySencond(10);
            }
        }
    }
}
