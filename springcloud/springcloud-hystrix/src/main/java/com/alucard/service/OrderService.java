package com.alucard.service;

import org.springframework.stereotype.Service;

/**
 * @author alucard
 * @Description
 * @Date Create in 18:26 2018/9/19
 */
@Service
public class OrderService {

   public String getOrder(){
       System.out.println("getOrder1:"+Thread.currentThread().getName());
       try {
           Thread.sleep(1500);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return "getOrder success";
   }

    public String getOrderForOther(){
        System.out.println("getOrderForOther:"+Thread.currentThread().getName());
        return "getOrderForOther success";
    }
}
