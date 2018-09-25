package com.alucard.ratelimit.aspect;

import com.alucard.ratelimit.annotation.ExtRateLimiter;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:35 2018/9/25
 */
@Aspect
@Slf4j
@Component
public class RateLimiterAspect {
    /**
     * 使用url做为key,存放令牌桶 防止每次重新创建令牌桶
     */
    private Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Pointcut("@annotation(com.alucard.ratelimit.annotation.ExtRateLimiter)")
    public void rateLimiter() {

    }

    @Around("rateLimiter()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取request,response
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        // 或者url(存在map集合的key)
        String url = request.getRequestURI();
        // 获取自定义注解
        ExtRateLimiter rateLimiter = getAnRateLimiter(joinPoint);
        if (rateLimiter != null) {
            RateLimiter limiter = null;
            // 判断map集合中是否有创建有创建好的令牌桶
            if (!limitMap.containsKey(url)) {
                // 创建令牌桶
                limiter = RateLimiter.create(rateLimiter.permitsPerSecond());
                limitMap.put(url, limiter);
                log.info("<<=================  请求{},创建令牌桶,容量{} 成功!!!", url, rateLimiter.permitsPerSecond());
            }
            limiter = limitMap.get(url);
            // 获取令牌
            boolean acquire = limiter.tryAcquire(rateLimiter.timeout(), rateLimiter.timeunit());

            if (!acquire) {
                log.info("Error ---时间:{},获取令牌失败.", sdf.format(new Date()));
                return rateLimiter.msg();
            }
        }
        return joinPoint.proceed();
    }

    /**
     * 获取注解对象
     *
     * @param joinPoint 对象
     * @return ten LogAnnotation
     */
    private ExtRateLimiter getAnRateLimiter(final JoinPoint joinPoint) {
        Method[] methods = joinPoint.getTarget().getClass().getDeclaredMethods();
        String name = joinPoint.getSignature().getName();
        if (!StringUtils.isEmpty(name)) {
            for (Method method : methods) {
                ExtRateLimiter annotation = method.getAnnotation(ExtRateLimiter.class);
                if (!Objects.isNull(annotation) && name.equals(method.getName())) {
                    return annotation;
                }
            }
        }
        return null;
    }


}
