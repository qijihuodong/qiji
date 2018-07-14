package com.qiji.dao;

import com.qiji.domain.MicroUserOrgnise;

public interface MicroUserOrgniseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroUserOrgnise record);

    int insertSelective(MicroUserOrgnise record);

    MicroUserOrgnise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroUserOrgnise record);

    int updateByPrimaryKey(MicroUserOrgnise record);
}