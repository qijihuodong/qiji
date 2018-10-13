package com.qiji.dao;

import com.qiji.domain.UserService;

public interface UserServiceMapper {
    int insert(UserService record);

    int insertSelective(UserService record);
}