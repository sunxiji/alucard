package com.alucard;

import com.alucard.entity.User;
import com.alucard.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationRedisApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("张三");
        mapper.save(user);
        System.out.println("插入用户信息"+user.getUsername());
    }

    @Test
    public void set(){
        redisTemplate.opsForValue().set("test:set","testValue1");
    }

}
