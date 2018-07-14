package com.qiji.dao;

import com.qiji.domain.MicroCities;

public interface MicroCitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroCities record);

    int insertSelective(MicroCities record);

    MicroCities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroCities record);

    int updateByPrimaryKey(MicroCities record);
}