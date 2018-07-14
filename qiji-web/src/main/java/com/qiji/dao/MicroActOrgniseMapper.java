package com.qiji.dao;

import com.qiji.domain.MicroActOrgnise;

public interface MicroActOrgniseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroActOrgnise record);

    int insertSelective(MicroActOrgnise record);

    MicroActOrgnise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroActOrgnise record);

    int updateByPrimaryKey(MicroActOrgnise record);
}