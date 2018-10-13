package com.qiji.dao;

import java.util.List;

import com.qiji.domain.MicroProvinces;

public interface MicroProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroProvinces record);

    int insertSelective(MicroProvinces record);

    MicroProvinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroProvinces record);

    int updateByPrimaryKey(MicroProvinces record);
    
    public List<MicroProvinces> getAllProvinces();
}