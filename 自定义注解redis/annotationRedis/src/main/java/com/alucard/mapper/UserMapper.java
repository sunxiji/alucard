package com.alucard.mapper;
 
import java.util.List;

import com.alucard.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
	
	int save(User user);
	
	User selectById(Integer id);
	
	int updateById(User user);
	
	int deleteById(Integer id);
	
	List<User> queryAll();

	
}
