package com.alucard.api.service;

import com.alucard.api.DemoApiService;

/**
 * @author alucard
 * @Description
 * @Date Create in 17:03 2018/9/20
 */
public class DemoApiServiceImpl implements DemoApiService {

    public String getUser(Long userId) {
        System.out.println("生产者调用消费者服务接口userId:" + userId);
        return "alucard";
    }
}
