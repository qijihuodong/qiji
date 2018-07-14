package com.qiji.dao;

import com.qiji.domain.MicroAreas;

public interface MicroAreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAreas record);

    int insertSelective(MicroAreas record);

    MicroAreas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAreas record);

    int updateByPrimaryKey(MicroAreas record);
}