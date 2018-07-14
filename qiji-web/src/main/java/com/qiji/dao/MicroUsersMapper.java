package com.qiji.dao;

import java.util.List;

import com.qiji.domain.MicroUsers;

public interface MicroUsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(MicroUsers record);

    int insertSelective(MicroUsers record);

    MicroUsers selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(MicroUsers record);

    int updateByPrimaryKey(MicroUsers record);
    
    List<MicroUsers> findAllUsers();
    
    int isUserExists(MicroUsers record);
    
    MicroUsers getLoginUser(MicroUsers user);
}