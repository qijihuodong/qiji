package com.qiji.dao;

import com.qiji.domain.MicroActivityApply;

public interface MicroActivityApplyMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(MicroActivityApply record);

    int insertSelective(MicroActivityApply record);

    MicroActivityApply selectByPrimaryKey(Integer applyId);

    int updateByPrimaryKeySelective(MicroActivityApply record);

    int updateByPrimaryKey(MicroActivityApply record);
}