package com.alucard.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alucard.api.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:50 2018/9/21
 */
@RestController
public class OrderController {
    @Reference
    private MemberService memberService;

    @GetMapping("/getMemberInfo")
    public String getMemberInfo(@RequestParam String name){
        String memberInfo = memberService.getMemberInfo(name);
        return memberInfo;
    }
}
