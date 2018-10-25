package com.alucard.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alucard.annotation.ExtRedisCache;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author alucard
 * @Description
 * @Date Create in 19:42 2018/10/25
 */
@Component
@Aspect
public class ExtRedisAspect {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.alucard.annotation.ExtRedisCache)")
    public void rlAop() {

    }

    @Around("rlAop()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("开始------->");
        // 1.获取目标对象方法
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        // 使用Java反射技术获取方法上是否有@ExtRedisCache注解类
        ExtRedisCache extRedisCache = signature.getMethod().getDeclaredAnnotation(ExtRedisCache.class);

        if (extRedisCache != null) {
            // 1.获取cacheKey
            String cacheKey = extRedisCache.cacheKey();

            long timeout = extRedisCache.timeOut();
            // 2.自定义缓存key
            String methodCacheKey = name + ":"+cacheKey;

            // 3.如果缓存中存在数据,直接缓存数据给客户端
            String resultJson = (String) redisTemplate.opsForValue().get(methodCacheKey);
            if (!StringUtils.isEmpty(resultJson)) {
                return JSONObject.parseObject(resultJson, Object.class);
            }
            // 3.如果缓存中没有该数据,调用数据库查询并且缓存数据
            Object proceed = proceedingJoinPoint.proceed();
            if (proceed != null) {
                // 将数据缓存到redis中
                String jsonString = JSONObject.toJSONString(proceed);
                redisTemplate.opsForValue().set(methodCacheKey, jsonString, timeout, TimeUnit.SECONDS);
            }
            return proceed;
        }

        // 执行业务逻辑方法
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }
}
