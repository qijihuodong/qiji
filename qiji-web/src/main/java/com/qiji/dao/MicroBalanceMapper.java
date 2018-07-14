package com.qiji.dao;

import com.qiji.domain.MicroBalance;

public interface MicroBalanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroBalance record);

    int insertSelective(MicroBalance record);

    MicroBalance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroBalance record);

    int updateByPrimaryKey(MicroBalance record);
}