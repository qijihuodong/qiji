package com.qiji.dao;

import com.qiji.domain.MicroServiceContent;

public interface MicroServiceContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroServiceContent record);

    int insertSelective(MicroServiceContent record);

    MicroServiceContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroServiceContent record);

    int updateByPrimaryKey(MicroServiceContent record);
    
    
}