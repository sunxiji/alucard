package com.alucard.mapper;

import com.alucard.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface PermissionMapper {

    /**
     * 查询苏所有权限
     *
     * @return
     */
    @Select(" select * from sys_permission ")
    List<Permission> findAllPermission();

}
