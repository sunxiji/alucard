package com.alucard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    @GetMapping("/getOrderInfo")
    public Map<String,Object> getOrderInfo(HttpServletResponse response){
        //System.out.println("我能打印出来么？？");
        //response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> result = new HashMap<>();
        result.put("code","200");
        result.put("info","order info is {xxx}");
        return result;
    }
}
