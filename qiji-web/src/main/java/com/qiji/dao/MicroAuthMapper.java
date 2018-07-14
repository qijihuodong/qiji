package com.qiji.dao;

import com.qiji.domain.MicroAuth;

public interface MicroAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAuth record);

    int insertSelective(MicroAuth record);

    MicroAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAuth record);

    int updateByPrimaryKey(MicroAuth record);
}