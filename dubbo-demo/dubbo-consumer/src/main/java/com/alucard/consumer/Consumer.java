package com.alucard.consumer;

import com.alucard.api.DemoApiService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:38 2018/9/21
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        System.out.println("consumer start");
        DemoApiService demoApiService = context.getBean(DemoApiService.class);
        String result = demoApiService.getUser(1L);
        System.out.println("result:" + result);
    }
}
