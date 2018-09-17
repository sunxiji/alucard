package com.alucard.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:44 2018/9/15
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
