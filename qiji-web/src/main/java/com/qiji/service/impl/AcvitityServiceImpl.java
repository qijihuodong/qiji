package com.qiji.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.common.BusinessException;
import com.qiji.common.utils.BeanUtils;
import com.qiji.dao.ActivityListMapper;
import com.qiji.dao.MicroActivitiesMapper;
import com.qiji.domain.ActivityList;
import com.qiji.domain.MicroActivities;
import com.qiji.domain.MicroActivitiesWithBLOBs;
import com.qiji.service.IActivityService;
import com.qiji.vo.MicroActivitiesVo;

@Service("activityService")
public class AcvitityServiceImpl implements IActivityService {

	@Autowired
	private ActivityListMapper activityListMapper;
	
	@Autowired
	private MicroActivitiesMapper microActivitiesMapper;

	@Override
	public List<ActivityList> getIndexServiceList(Integer nums,
			MicroActivities activities) {
		ActivityList selActivityList = new ActivityList();
		selActivityList.setStartIndex(0);
		selActivityList.setNums(nums);
		selActivityList.setParentCategoryName("线上");
		return activityListMapper.getNewestActivity(selActivityList);
	}



	@Override
	public ActivityList getActivityDetailById(Integer activityActid) {
		return activityListMapper.getActivityById(activityActid);
	}



	@Override
	public List<ActivityList> getAcvitityList(ActivityList activityList) {
		return activityListMapper.getActivityByProp(activityList);
	}



	@Override
	public void addActivity(MicroActivitiesVo microActivitiesVo) {
		if(null == microActivitiesVo){
			throw new BusinessException("发布失败！");
		}
		

		MicroActivitiesWithBLOBs microActivities = new MicroActivitiesWithBLOBs();
		BeanUtils.copyClassByParValue(microActivitiesVo, microActivities, null);
		microActivities.setCreateTime(new Date());
		microActivities.setStatus(0);
		microActivitiesMapper.insert(microActivities);
	}

}
