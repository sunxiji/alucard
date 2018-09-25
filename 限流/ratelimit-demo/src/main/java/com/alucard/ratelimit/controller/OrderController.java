package com.alucard.ratelimit.controller;

import com.alucard.ratelimit.annotation.ExtRateLimiter;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:04 2018/9/25
 */
@RestController
@Slf4j
public class OrderController {

    private RateLimiter limiter = RateLimiter.create(1.0);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/getOrderInfo")
    public String getOrderInfo() {
        log.info("getOrderInfo");
        return "success";
    }

    @GetMapping("/getOrderInfoRateLimiter")
    public String getOrderInfoRateLimiter() {
        // 如果用户在500毫秒内没有获取到令牌,就直接放弃获取进行服务降级处理
        boolean tryAcquire = limiter.tryAcquire(500, TimeUnit.MILLISECONDS);
        if (!tryAcquire) {
            log.info("Error ---时间:{},获取令牌失败.", sdf.format(new Date()));
            return "系统繁忙,请稍后再试.";
        }
        log.info("Success ---时间:{},获取令牌成功.", sdf.format(new Date()));
        return "success";
    }

    @GetMapping("/getOrderInfoByAnnotation")
    @ExtRateLimiter(permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "亲,现在流量过大,请稍后再试.")
    public String getOrderInfoByAnnotation() {
        log.info("getOrderInfoByAnnotation");
        return "success";
    }
}
