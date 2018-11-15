package com.alucard.controller;

import com.alucard.annotation.AluTransactional;
import com.alucard.entity.User;
import com.alucard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 12:24 2018/11/15
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/insertUser")
    public String insertUser(String name,Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int i = userService.insertUser(user);
        return "success";
    }
}
