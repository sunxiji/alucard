package com.alucard.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${zhangsan_conf}")
    private String zhangsanConf;

    @Value("${alucard}")
    private String alucard;

    @RequestMapping("/getZhangsanConf")
    public String getZhangsanConf(){
        return zhangsanConf;
    }

    @RequestMapping("/getAlucard")
    public String getAlucard(){
        return alucard;
    }
}
