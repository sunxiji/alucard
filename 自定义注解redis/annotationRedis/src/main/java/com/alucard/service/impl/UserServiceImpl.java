package com.alucard.service.impl;

import com.alucard.annotation.ExtRedisCache;
import com.alucard.entity.User;
import com.alucard.mapper.UserMapper;
import com.alucard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alucard
 * @Description
 * @Date Create in 19:11 2018/10/25
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @ExtRedisCache(cacheKey = "user",timeOut = 1500)
    @Override
    public List<User> getUser() {
        System.out.println("如果没有缓存我才会进来---->");
        return userMapper.queryAll();
    }
}
