package com.qiji.dao;

import com.qiji.domain.MicroContactus;

public interface MicroContactusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroContactus record);

    int insertSelective(MicroContactus record);

    MicroContactus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroContactus record);

    int updateByPrimaryKey(MicroContactus record);
}