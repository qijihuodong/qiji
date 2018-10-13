package com.qiji.dao;

import com.qiji.domain.MicroAuthBusiness;

public interface MicroAuthBusinessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAuthBusiness record);

    int insertSelective(MicroAuthBusiness record);

    MicroAuthBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAuthBusiness record);

    int updateByPrimaryKeyWithBLOBs(MicroAuthBusiness record);

    int updateByPrimaryKey(MicroAuthBusiness record);
    
    public Integer getNums();
}