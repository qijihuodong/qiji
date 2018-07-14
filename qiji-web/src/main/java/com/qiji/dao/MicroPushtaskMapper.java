package com.qiji.dao;

import com.qiji.domain.MicroPushtask;

public interface MicroPushtaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroPushtask record);

    int insertSelective(MicroPushtask record);

    MicroPushtask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroPushtask record);

    int updateByPrimaryKey(MicroPushtask record);
}