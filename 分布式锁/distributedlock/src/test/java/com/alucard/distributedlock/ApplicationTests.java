package com.alucard.distributedlock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void set() {
        String key = "alucard";
        String value = UUID.randomUUID().toString();
        //setIfAbsent 就是setnx
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, value);
        System.out.println("flag:" + flag);
    }
}
