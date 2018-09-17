package com.alucard.rabbitmq;

import com.alucard.rabbitmq.entity.Order;
import com.alucard.rabbitmq.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSend1() throws Exception{
        Order order = new Order();
        order.setId("20180915000001");
        order.setName("测试订单");
        order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
        orderSender.send(order);
    }

}
