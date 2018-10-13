package com.qiji.service;

import java.util.List;
import java.util.Map;

import com.qiji.domain.MicroService;
import com.qiji.domain.MicroServiceContent;
import com.qiji.domain.ServiceContent;
import com.qiji.domain.ServiceContentStandard;
import com.qiji.domain.ServiceList;
import com.qiji.vo.ServiceListVo;

public interface IServiceService {
	/**
	 * 获取首页服务列表
	 * @param nums
	 * @param servicecontent
	 * @return
	 */
	public Map<Integer,List<ServiceList>> getIndexServiceList(Integer nums,MicroServiceContent servicecontent );
	
	
	/**
	 * 根据服务ID获取服务描述信息
	 * @param serviceId
	 * @return
	 */
	public List<ServiceList> getServiceHeaderById(Integer serviceId);
	
	
	/**
	 * 获取服务详情
	 * @param activityActid
	 * @return
	 */
	public List<ServiceContent> getServiceDetailById(Integer serviceId);
	
	/**
	 * 获取服务规格
	 * @param serviceId
	 * @return
	 */
	public List<ServiceContentStandard> getServiceStandardById(Integer serviceId);
	
	/**
	 * 获取服务列表
	 * @param activities
	 * @return
	 */
	public List<ServiceListVo> getServiceList(MicroService microService,ServiceList serviceList );
	
	
	public Integer countServiceList(MicroService microService,ServiceList serviceList );
	
}
