package com.alucard.controller;

import com.alucard.entity.DriverEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    //spring 提供了最简单的方法，CrossOrigin
//    @CrossOrigin
    @RequestMapping("/getOrderInfo")
    public Map<String, Object> getOrderInfo(HttpServletResponse response) {
        //System.out.println("我能打印出来么？？");
        //response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("info", "order info is {xxx}");
        return result;
    }

    /**
     * 复杂的请求对象，会先预检（OPTIONS）
     * @param driver
     * @return
     */
    @PostMapping("/postJson")
    public Map<String,Object> postJson(@RequestBody DriverEntity driver){
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("info", driver.getName()+","+driver.getAge());
        return result;
    }

    //spring框架提供了跨域
    @RequestMapping("/getOrderInfoCrossOrigin")
    @CrossOrigin
    public Map<String, Object> getOrderInfoCrossOrigin(@RequestBody DriverEntity driver) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("info", driver.getName()+","+driver.getAge());
        return result;
    }
}
