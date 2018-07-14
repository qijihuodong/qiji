package com.qiji.dao;

import com.qiji.domain.MicroAuthUserOrgnise;

public interface MicroAuthUserOrgniseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAuthUserOrgnise record);

    int insertSelective(MicroAuthUserOrgnise record);

    MicroAuthUserOrgnise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAuthUserOrgnise record);

    int updateByPrimaryKey(MicroAuthUserOrgnise record);
}