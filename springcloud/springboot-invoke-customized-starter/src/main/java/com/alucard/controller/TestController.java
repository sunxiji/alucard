package com.alucard.controller;

import com.alucard.starter.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 17:49 2018/9/28
 */
@RestController
public class TestController {
    @Autowired
    PersonService personService;

    @GetMapping("/test")
    public void hello(){
        personService.sayHello();
    }
}
