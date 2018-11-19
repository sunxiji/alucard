package com.alucard.service;

import com.alucard.entity.User;

import java.util.List;

public interface UserService {

	List<User> queryUsersByPage(int currPage, int pageSize);
}
