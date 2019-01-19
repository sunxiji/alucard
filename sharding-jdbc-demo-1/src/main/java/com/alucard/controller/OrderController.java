package com.alucard.controller;

import com.alucard.dao.OrderRepository;
import com.alucard.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:48 2018/12/12
 */
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/insert")
    public String insert(){
        for (int i = 0; i < 30; i++) {
            orderRepository.save(new OrderEntity((long)i,(long)i));
        }
        return "success";
    }

    @GetMapping("/queryAll")
    public Object queryAll(){
        Iterable<OrderEntity> all = orderRepository.findAll();
        return all;
    }
}
