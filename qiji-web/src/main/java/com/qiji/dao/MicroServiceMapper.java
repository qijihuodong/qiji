package com.qiji.dao;

import java.util.List;

import com.qiji.domain.MicroService;

public interface MicroServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroService record);

    int insertSelective(MicroService record);

    MicroService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroService record);

    int updateByPrimaryKey(MicroService record);
   
   /**
    * 获取最新服务
    * @param service
    * @return
    */
    public List<MicroService> getNewestService(MicroService service);
    
    
    public List<MicroService> getServiceByProp(MicroService microService);
    
    
    
    public Integer countServiceByProp(MicroService microService);
    
}