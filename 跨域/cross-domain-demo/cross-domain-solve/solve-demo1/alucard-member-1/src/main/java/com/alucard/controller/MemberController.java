package com.alucard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    /**
     * jsop方式
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "indexJsonp";
    }

    /**
     * CrosFilter
     * @return
     */
    @GetMapping("/index1")
    public String index1() {
        return "indexFilter";
    }

    /**
     * 复杂请求
     * @return
     */
    @GetMapping("/index2")
    public String index2() {
        return "indexComplex";
    }

    /**
     * 通过spring提供的注解解决
     * @return
     */
    @GetMapping("/index3")
    public String index3() {
        return "indexSpring";
    }
}
