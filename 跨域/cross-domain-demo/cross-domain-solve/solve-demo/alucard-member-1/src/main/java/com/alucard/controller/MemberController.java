package com.alucard.controller;

import com.alibaba.fastjson.JSONObject;
import com.alucard.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    public static final String GET_ORDER_INFO_URL = "http://b.alucard.com:8081/getOrderInfo";
    /**
     * jsop方式
     *
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "indexJsonp";
    }

    /**
     * CrosFilter
     *
     * @return
     */
    @GetMapping("/index1")
    public String index1() {
        return "indexFilter";
    }

    /**
     * 复杂请求
     *
     * @return
     */
    @GetMapping("/index2")
    public String index2() {
        return "indexComplex";
    }

    /**
     * 通过spring提供的注解解决
     *
     * @return
     */
    @GetMapping("/index3")
    public String index3() {
        return "indexSpring";
    }

    /**
     * 通过HttpClient
     *
     * @return
     */
    @GetMapping("/index4")
    public String index4() {
        return "indexHttpClient";
    }

    /**
     * 通过HttpClient获取getOrderInfo
     * @return
     */
    @RequestMapping("httpclientToGetOrderInfo")
    @ResponseBody
    public JSONObject httpclientToGetOrderInfo() {
        // 通过httpclient方式获取b.alucard.com 的getOrderInfo
        JSONObject jsonObject = HttpClientUtils.httpGet(GET_ORDER_INFO_URL);
        return jsonObject;
    }

    /**
     * 通过nginx
     *
     * @return
     */
    @GetMapping("/index5")
    public String index5() {
        return "indexNginx";
    }

    /**
     * 通过zuul
     *
     * @return
     */
    @GetMapping("/index6")
    public String index6() {
        return "indexZuul";
    }
}
