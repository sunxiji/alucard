package com.alucard.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:16 2018/9/18
 */
@RestController
public class MemberController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getMember")
    public String getMember(){
        return "getMember!!!serverPort:"+serverPort;
    }
}
