package com.alucard.dao;

import com.alucard.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

	public User login(User user);

	List<User> queryUsersByPage(Map<String, Object> data);
}
