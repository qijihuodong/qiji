package com.qiji.dao;

import com.qiji.domain.MicroCart;

public interface MicroCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroCart record);

    int insertSelective(MicroCart record);

    MicroCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroCart record);

    int updateByPrimaryKey(MicroCart record);
}