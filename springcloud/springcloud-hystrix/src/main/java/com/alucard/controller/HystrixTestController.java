package com.alucard.controller;

import com.alucard.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 18:25 2018/9/19
 */
@RestController
public class HystrixTestController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getOrder1")
    public String getOrder1(){
        return orderService.getOrder();
    }

    @HystrixCommand(fallbackMethod = "orderToUserInfoFallback")
    @GetMapping("/getOrder2")
    public String getOrder2(){
        return orderService.getOrderForOther();
    }

    @GetMapping("/orderToUserInfoFallback")
    public String orderToUserInfoFallback() {
        System.out.println("系统错误!!!!");
        return "系统错误!!!!";
    }
}
