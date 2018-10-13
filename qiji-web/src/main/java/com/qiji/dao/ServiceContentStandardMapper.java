package com.qiji.dao;

import java.util.List;

import com.qiji.domain.ServiceContentStandard;

public interface ServiceContentStandardMapper {
    int insert(ServiceContentStandard record);

    int insertSelective(ServiceContentStandard record);
    
    public List<ServiceContentStandard> getServiceContentStandardByIds(List<Integer> ids);
    

    public List<ServiceContentStandard> getServiceContentStandardByServiceId(Integer serviceId);
}