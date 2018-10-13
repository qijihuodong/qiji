package com.qiji.dao;

import java.util.List;

import com.qiji.domain.ServiceContent;

public interface ServiceContentMapper {
    int insert(ServiceContent record);

    int insertSelective(ServiceContent record);
    
    public List<ServiceContent> getServiceContentByIds(List<Integer> ids);
    public List<ServiceContent> getServiceContentByServiceId(Integer serviceId);
}