package com.qiji.dao;

import java.util.List;

import com.qiji.domain.ActivityList;
import com.qiji.domain.ActivityListWithBLOBs;

public interface ActivityListMapper {
    int insert(ActivityListWithBLOBs record);

    int insertSelective(ActivityListWithBLOBs record);
    
    public List<ActivityList> getNewestActivity(ActivityList activityList);
    
    public List<ActivityList> getActivityByProp(ActivityList activityList);
    
    public ActivityList getActivityById(Integer activityActid);
    
    
    
}