package com.qiji.dao;

import java.util.List;

import com.qiji.domain.ServiceList;

public interface ServiceListMapper {
    int insert(ServiceList record);

    int insertSelective(ServiceList record);
    
    public List<ServiceList> getServiceByProp(ServiceList serviceList);
    
    public List<ServiceList> getServiceById(Integer serviceId);
    
    
    
}