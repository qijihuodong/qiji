package com.qiji.dao;

import com.qiji.domain.MicroOrderContent;

public interface MicroOrderContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroOrderContent record);

    int insertSelective(MicroOrderContent record);

    MicroOrderContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroOrderContent record);

    int updateByPrimaryKey(MicroOrderContent record);
}