package com.qiji.dao;

import com.qiji.domain.MicroAuthUserBusiness;

public interface MicroAuthUserBusinessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAuthUserBusiness record);

    int insertSelective(MicroAuthUserBusiness record);

    MicroAuthUserBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAuthUserBusiness record);

    int updateByPrimaryKey(MicroAuthUserBusiness record);
}