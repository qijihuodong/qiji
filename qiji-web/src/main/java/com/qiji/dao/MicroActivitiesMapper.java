package com.qiji.dao;

import com.qiji.domain.MicroActivities;
import com.qiji.domain.MicroActivitiesWithBLOBs;

public interface MicroActivitiesMapper {
    int deleteByPrimaryKey(Integer actid);

    int insert(MicroActivitiesWithBLOBs record);

    int insertSelective(MicroActivitiesWithBLOBs record);

    MicroActivitiesWithBLOBs selectByPrimaryKey(Integer actid);

    int updateByPrimaryKeySelective(MicroActivitiesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MicroActivitiesWithBLOBs record);

    int updateByPrimaryKey(MicroActivities record);
}