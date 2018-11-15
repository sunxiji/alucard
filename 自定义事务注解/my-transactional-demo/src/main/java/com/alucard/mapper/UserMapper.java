package com.alucard.mapper;

import com.alucard.entity.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author alucard
 * @Description
 * @Date Create in 12:32 2018/11/15
 */
public interface UserMapper {

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insertUser(User user);
}
