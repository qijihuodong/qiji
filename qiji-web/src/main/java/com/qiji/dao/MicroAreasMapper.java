package com.qiji.dao;

import java.util.List;

import com.qiji.domain.MicroAreas;

public interface MicroAreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAreas record);

    int insertSelective(MicroAreas record);

    MicroAreas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAreas record);

    int updateByPrimaryKey(MicroAreas record);
    
    public List<MicroAreas> getAllAreas();
    
    
    public List<MicroAreas> getAreasByCityId(String cityId);
    
    
}