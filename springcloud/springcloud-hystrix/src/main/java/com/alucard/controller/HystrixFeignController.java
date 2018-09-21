package com.alucard.controller;

import com.alucard.client.MemberApiFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 19:39 2018/9/19
 */
@RestController
public class HystrixFeignController {

    @Autowired
    MemberApiFeign memberApiFeign;

    @HystrixCommand(fallbackMethod = "fallback1")
    @GetMapping("/orderToUserInfo")
    public String orderToUserInfoHystrix() {
        System.out.println("orderToUserInfo:" + "当前线程池名称:" + Thread.currentThread().getName());
        return memberApiFeign.getMember();
    }

    @RequestMapping("/fallback1")
    public String fallback1() {
        return "系统错误!!!!";
    }
}
