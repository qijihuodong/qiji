package com.qiji.dao;

import com.qiji.domain.MicroOrgniseApply;

public interface MicroOrgniseApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroOrgniseApply record);

    int insertSelective(MicroOrgniseApply record);

    MicroOrgniseApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroOrgniseApply record);

    int updateByPrimaryKey(MicroOrgniseApply record);
}