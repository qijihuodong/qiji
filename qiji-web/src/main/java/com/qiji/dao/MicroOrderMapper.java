package com.qiji.dao;

import com.qiji.domain.MicroOrder;

public interface MicroOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroOrder record);

    int insertSelective(MicroOrder record);

    MicroOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroOrder record);

    int updateByPrimaryKey(MicroOrder record);
}