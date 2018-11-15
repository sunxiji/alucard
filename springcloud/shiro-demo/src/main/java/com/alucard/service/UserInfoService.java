package com.alucard.service;

import com.alucard.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
}
