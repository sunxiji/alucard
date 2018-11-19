package com.alucard.service.impl;

import com.alucard.entity.User;
import com.alucard.mapper.UserMapper;
import com.alucard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:50 2018/11/19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUsersByPage(int currPage, int pageSize) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("currPage", currPage);
        data.put("pageSize", pageSize);
        List<User> list = userMapper.queryUsersByPage(data);
        return list;
    }
}
