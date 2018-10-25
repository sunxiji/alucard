package com.alucard.controller;

import com.alibaba.fastjson.JSON;
import com.alucard.annotation.ExtRedisCache;
import com.alucard.entity.User;
import com.alucard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author alucard
 * @Description
 * @Date Create in 18:42 2018/10/25
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    public String getUser(){
        List<User> user = userService.getUser();
        System.out.println(user.toString());
        return JSON.toJSONString(user);
    }
}
