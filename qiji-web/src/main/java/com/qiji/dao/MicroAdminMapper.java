package com.qiji.dao;

import com.qiji.domain.MicroAdmin;

public interface MicroAdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(MicroAdmin record);

    int insertSelective(MicroAdmin record);

    MicroAdmin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(MicroAdmin record);

    int updateByPrimaryKey(MicroAdmin record);
}