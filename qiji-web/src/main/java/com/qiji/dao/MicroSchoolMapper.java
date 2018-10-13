package com.qiji.dao;

import java.util.List;

import com.qiji.domain.MicroSchool;

public interface MicroSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroSchool record);

    int insertSelective(MicroSchool record);

    MicroSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroSchool record);

    int updateByPrimaryKey(MicroSchool record);
    
    public List<String> getSchoolTypes();
    
    public List<MicroSchool> getSchoolsByType(String type);
    
    public List<Integer> getSchoolIdsByType(String type);
    
    
}