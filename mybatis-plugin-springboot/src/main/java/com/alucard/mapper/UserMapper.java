package com.alucard.mapper;

import com.alucard.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	List<User> queryUsersByPage(Map<String, Object> data);
}
