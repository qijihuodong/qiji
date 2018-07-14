package com.qiji.dao;

import com.qiji.domain.MicroUserTagList;

public interface MicroUserTagListMapper {
    int deleteByPrimaryKey(Integer userTagId);

    int insert(MicroUserTagList record);

    int insertSelective(MicroUserTagList record);

    MicroUserTagList selectByPrimaryKey(Integer userTagId);

    int updateByPrimaryKeySelective(MicroUserTagList record);

    int updateByPrimaryKey(MicroUserTagList record);
}