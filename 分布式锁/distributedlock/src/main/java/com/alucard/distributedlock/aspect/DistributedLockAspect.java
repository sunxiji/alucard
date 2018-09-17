package com.alucard.distributedlock.aspect;

import com.alucard.distributedlock.annotation.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author alucard
 * @Description
 * @Date Create in 19:12 2018/9/17
 */
@Aspect
@Component
@Slf4j
public class DistributedLockAspect {

    @Autowired
    RedisTemplate redisTemplate;

    private ExpressionEvaluator<String> evaluator = new ExpressionEvaluator<>();

    @Pointcut("@annotation(lock)")
    public void distributedLockAspect(DistributedLock lock) {
    }

    @Around("distributedLockAspect(lock)")
    public Object around(ProceedingJoinPoint point, DistributedLock lock) throws Throwable {
        String key = "redislock:"+ lock.key();
        log.info("获取分布式锁：{}", key);
        // 拥有锁的超时时间
        int timeout =  (int)(lock.timeout()/1000);
        // 获取锁的超时时间
        long acqireTimeout = lock.acqireTimeout();

        long endTime = System.currentTimeMillis() + acqireTimeout;
        // 锁的value
        String value = UUID.randomUUID().toString();
        try{
        while(System.currentTimeMillis()<endTime){
            //使用setnx设置锁
            if (redisTemplate.opsForValue().setIfAbsent(key,value)){
                log.info("{},上锁成功,value:{}",key,value);
                // 设置过期时间
                redisTemplate.expire(key,timeout, TimeUnit.SECONDS);
                break;
            }
        }
        Object result = point.proceed();

        return result;
        }catch (Throwable var12) {
            throw var12;
        }finally {
            // 释放锁
            releaseLock(key, value);
        }
    }

    //释放锁
    public boolean releaseLock(String lockKey,String value){
        String lockName = lockKey;
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
