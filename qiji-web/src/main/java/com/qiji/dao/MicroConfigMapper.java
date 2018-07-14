package com.qiji.dao;

import com.qiji.domain.MicroConfig;

public interface MicroConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroConfig record);

    int insertSelective(MicroConfig record);

    MicroConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroConfig record);

    int updateByPrimaryKey(MicroConfig record);
}