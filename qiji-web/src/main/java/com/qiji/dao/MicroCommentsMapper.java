package com.qiji.dao;

import com.qiji.domain.MicroComments;

public interface MicroCommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroComments record);

    int insertSelective(MicroComments record);

    MicroComments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroComments record);

    int updateByPrimaryKey(MicroComments record);
}