package com.alucard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShiroApplication {
    /**
     * SysUser: 用来存储用户的密码，用户名等等信息。
     * SysRole: 角色表，存放所有的角色信息
     * SysAuth:权限表，定义了一些操作访问权限信息。
     * SysUserRole: SysUser和SysRole的关联表。
     * SysRoleAuth：SysRole和SysAuth的关联表。
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }
}
