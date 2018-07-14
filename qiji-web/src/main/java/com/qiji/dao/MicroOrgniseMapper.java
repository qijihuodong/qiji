package com.qiji.dao;

import com.qiji.domain.MicroOrgnise;

public interface MicroOrgniseMapper {
    int deleteByPrimaryKey(Integer ogid);

    int insert(MicroOrgnise record);

    int insertSelective(MicroOrgnise record);

    MicroOrgnise selectByPrimaryKey(Integer ogid);

    int updateByPrimaryKeySelective(MicroOrgnise record);

    int updateByPrimaryKey(MicroOrgnise record);
}