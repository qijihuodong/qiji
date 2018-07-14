package com.qiji.dao;

import com.qiji.domain.MicroSchool;

public interface MicroSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroSchool record);

    int insertSelective(MicroSchool record);

    MicroSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroSchool record);

    int updateByPrimaryKey(MicroSchool record);
}