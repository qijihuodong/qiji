package com.qiji.dao;

import com.qiji.domain.MicroService;

public interface MicroServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroService record);

    int insertSelective(MicroService record);

    MicroService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroService record);

    int updateByPrimaryKey(MicroService record);
}