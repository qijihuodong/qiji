package com.qiji.dao;

import java.util.List;

import com.qiji.domain.MicroCategory;

public interface MicroCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroCategory record);

    int insertSelective(MicroCategory record);

    MicroCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroCategory record);

    int updateByPrimaryKey(MicroCategory record);
    
    List<MicroCategory> getCatagoryByParentId(MicroCategory record);
}