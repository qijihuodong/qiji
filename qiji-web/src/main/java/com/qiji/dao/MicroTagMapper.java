package com.qiji.dao;

import com.qiji.domain.MicroTag;

public interface MicroTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(MicroTag record);

    int insertSelective(MicroTag record);

    MicroTag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(MicroTag record);

    int updateByPrimaryKey(MicroTag record);
}