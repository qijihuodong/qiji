package com.qiji.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroServiceContentMapper;
import com.qiji.dao.MicroServiceContentStandardMapper;
import com.qiji.dao.MicroServiceMapper;
import com.qiji.dao.ServiceContentMapper;
import com.qiji.dao.ServiceContentStandardMapper;
import com.qiji.dao.ServiceListMapper;
import com.qiji.domain.MicroService;
import com.qiji.domain.MicroServiceContent;
import com.qiji.domain.MicroServiceContentStandard;
import com.qiji.domain.ServiceContent;
import com.qiji.domain.ServiceContentStandard;
import com.qiji.domain.ServiceList;
import com.qiji.service.IServiceService;
import com.qiji.vo.ServiceListVo;

@Service("serviceService")
public class ServiceServiceImpl implements IServiceService {

	@Autowired
	private MicroServiceMapper microServiceMapper;
	
	@Autowired
	private ServiceListMapper serviceListMapper;
	
	
	@Autowired
	private ServiceContentMapper serviceContentMapper;
	
	
	@Autowired
	private ServiceContentStandardMapper serviceContentStandardMapper;
	
	@Override
	public Map<Integer,List<ServiceList>> getIndexServiceList(Integer nums,MicroServiceContent servicecontent ) {
		//1. 首页刚加载时，按时间排序获取server_id
		
		//2. 省市区、学校、院系、价格、预约、评价从content排除后，去除server_id
		MicroService service = new MicroService();
		
		service.setStartIndex(0);
		service.setNums(nums);
		service.setStatus(new Byte("1"));//审核通过
		
		Map<Integer,List<ServiceList>> resultMap = new HashMap<Integer,List<ServiceList>>();
		//1. 获取最新的服务记录
		List<MicroService> services = microServiceMapper.getNewestService(service);
		
		for(MicroService tmpService : services){
			
			ServiceList selServiceList = new ServiceList();
			selServiceList.setServiceId(Long.valueOf(tmpService.getId()));
			resultMap.put(tmpService.getId(), serviceListMapper.getServiceByProp(selServiceList ));
			
		}
		
		return resultMap;
		
	}

	@Override
	public List<ServiceListVo> getServiceList(MicroService microService,
			ServiceList serviceList) {
		
		List<ServiceListVo> lists = new ArrayList<ServiceListVo>();
		microService.setStatus(new Byte("1"));//审核通过
		List<MicroService> services = microServiceMapper.getServiceByProp(microService);
		for(MicroService tmpService : services){
			if(null == serviceList){
				serviceList= new ServiceList();
			}
			serviceList.setServiceId(Long.valueOf(tmpService.getId()));
			
			
			ServiceListVo vo = new ServiceListVo();
			vo.setServiceId(tmpService.getId());
			
			vo.setServiceList(serviceListMapper.getServiceByProp(serviceList ));
			lists.add(vo);
		}
		return lists;
	}

	@Override
	public Integer countServiceList(MicroService microService,
			ServiceList serviceList) {
		microService.setStatus(new Byte("1"));//审核通过
		return microServiceMapper.countServiceByProp(microService);
	}

	@Override
	public List<ServiceList> getServiceHeaderById(Integer serviceId) {
		return serviceListMapper.getServiceById(serviceId);
	}
	
	
	@Override
	public List<ServiceContentStandard> getServiceStandardById(Integer serviceId) {
		return serviceContentStandardMapper.getServiceContentStandardByServiceId(serviceId);
	}

	@Override
	public List<ServiceContent> getServiceDetailById(Integer serviceId) {
		return serviceContentMapper.getServiceContentByServiceId(serviceId);
	}

	

}
