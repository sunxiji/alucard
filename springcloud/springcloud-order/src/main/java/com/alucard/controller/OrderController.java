package com.alucard.controller;

import com.alucard.client.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:30 2018/9/18
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberApiFeign memberApiFeign;

    @GetMapping("/getOrder")
    public String getOrder(){
        return "getOrder!!!";
    }

    @GetMapping("/orderToGetMember")
    public String orderToGetMember(){
        String memberUrl = "http://alucard-member/getMember";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }

    @GetMapping("/orderToGetMemberByFeign")
    public String orderToGetMemberByFeign(){
        String member = memberApiFeign.getMember();
        return member;
    }

}
