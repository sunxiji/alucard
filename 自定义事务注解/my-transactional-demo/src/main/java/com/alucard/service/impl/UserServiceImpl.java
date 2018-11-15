package com.alucard.service.impl;

import com.alucard.annotation.AluTransactional;
import com.alucard.entity.User;
import com.alucard.mapper.UserMapper;
import com.alucard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alucard
 * @Description
 * @Date Create in 12:39 2018/11/15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @AluTransactional
    @Override
    public int insertUser(User user) {
        int count = userMapper.insertUser(user);
        int result = 1 / user.getAge();
        return count;
    }
}
