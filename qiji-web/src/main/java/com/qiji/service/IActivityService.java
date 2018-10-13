package com.qiji.service;

import java.util.List;

import com.qiji.domain.ActivityList;
import com.qiji.domain.MicroActivities;
import com.qiji.vo.MicroActivitiesVo;

public interface IActivityService {
	/**
	 * 获取首页企业需求
	 * @param nums
	 * @param activities
	 * @return
	 */
	public List<ActivityList> getIndexServiceList(Integer nums,MicroActivities activities );
	
	
	/**
	 * 获取企业需求详情
	 * @param activityActid
	 * @return
	 */
	public ActivityList getActivityDetailById(Integer activityActid);
	
	/**
	 * 获取企业需求列表
	 * @param activities
	 * @return
	 */
	public List<ActivityList> getAcvitityList(ActivityList activityList );
	
	
	/**
	 * 添加需要或活动
	 * @param microActivities
	 */
	public void addActivity(MicroActivitiesVo microActivitiesVo);
}
