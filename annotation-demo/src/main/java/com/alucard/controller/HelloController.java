package com.alucard.controller;

import com.alucard.annotation.Alucard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:48 2018/10/27
 */
@RestController
public class HelloController {

    @Alucard(beanId = 1,className="com.alucard.controller",arr={"1","2"})
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
}
