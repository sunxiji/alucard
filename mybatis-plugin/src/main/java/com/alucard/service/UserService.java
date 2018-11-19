package com.alucard.service;

import com.alucard.entity.User;

import java.util.List;

public interface UserService {

	public User login(User user);

	List<User> queryUsersByPage(int currPage, int pageSize);
}
