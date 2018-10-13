package com.qiji.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.common.SysException;
import com.qiji.domain.ActivityList;
import com.qiji.service.IActivityService;
import com.qiji.utils.PageBean;
import com.qiji.vo.MicroActivitiesVo;

@RestController
@RequestMapping("/activity")
public class MicroActivityController {

	private final static Logger logger = LoggerFactory.getLogger(MicroActivityController.class);
	
	@Autowired
	private IActivityService activityService;
	
	
	@RequestMapping(value="/getActivityList",method=RequestMethod.POST)
	public ModelJson getActivityList(Integer page,Integer rows,ActivityList activityList){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		if(page == null){
			page = 1;
		}else if(page <=0 ){
			page = 1;
		}
		
		if(rows == null){
			rows = 7;
		}
		try{
			PageHelper.startPage(page, rows);
			List<ActivityList> activityLists = activityService.getAcvitityList(activityList);
			PageInfo<ActivityList> pageInfo = new PageInfo<ActivityList>(activityLists);
			
			PageBean<ActivityList> pageBean = new PageBean<ActivityList>();
			pageBean.setItems(activityLists);
			pageBean.setTotalNum(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
			pageBean.setTotalPage(pageInfo.getPageNum());
			
			
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(pageBean);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			e.printStackTrace();
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			e.printStackTrace();
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	
	
	@RequestMapping(value="/addActivity",method=RequestMethod.POST)
	public ModelJson getActivityList(MicroActivitiesVo vo){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		try{
			activityService.addActivity(vo);
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setMessage("发布成功！");
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			e.printStackTrace();
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			e.printStackTrace();
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	
	
	
}
