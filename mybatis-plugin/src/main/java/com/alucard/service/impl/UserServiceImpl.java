package com.alucard.service.impl;

import com.alucard.dao.UserDao;
import com.alucard.entity.User;
import com.alucard.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> queryUsersByPage(int currPage, int pageSize) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("currPage", currPage);
        data.put("pageSize", pageSize);
        List<User> list = userDao.queryUsersByPage(data);
        return list;
    }

}
