package com.qiji.dao;

import com.qiji.domain.MicroCategoryConfig;

public interface MicroCategoryConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroCategoryConfig record);

    int insertSelective(MicroCategoryConfig record);

    MicroCategoryConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroCategoryConfig record);

    int updateByPrimaryKey(MicroCategoryConfig record);
}