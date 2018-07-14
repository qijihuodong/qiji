package com.qiji.dao;

import com.qiji.domain.MicroSchoolResource;

public interface MicroSchoolResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(MicroSchoolResource record);

    int insertSelective(MicroSchoolResource record);

    MicroSchoolResource selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(MicroSchoolResource record);

    int updateByPrimaryKey(MicroSchoolResource record);
}