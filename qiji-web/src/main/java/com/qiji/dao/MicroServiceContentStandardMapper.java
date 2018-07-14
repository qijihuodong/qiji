package com.qiji.dao;

import com.qiji.domain.MicroServiceContentStandard;

public interface MicroServiceContentStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroServiceContentStandard record);

    int insertSelective(MicroServiceContentStandard record);

    MicroServiceContentStandard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroServiceContentStandard record);

    int updateByPrimaryKey(MicroServiceContentStandard record);
}