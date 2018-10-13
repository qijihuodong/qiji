package com.qiji.vo;

import java.util.List;

import com.qiji.domain.ServiceList;

public class ServiceListVo {
	private Integer serviceId;
	private List<ServiceList> serviceList;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public List<ServiceList> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<ServiceList> serviceList) {
		this.serviceList = serviceList;
	}
	
	
}
