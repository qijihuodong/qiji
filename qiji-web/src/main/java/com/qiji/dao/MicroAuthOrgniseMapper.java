package com.qiji.dao;

import com.qiji.domain.MicroAuthOrgnise;

public interface MicroAuthOrgniseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroAuthOrgnise record);

    int insertSelective(MicroAuthOrgnise record);

    MicroAuthOrgnise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroAuthOrgnise record);

    int updateByPrimaryKeyWithBLOBs(MicroAuthOrgnise record);

    int updateByPrimaryKey(MicroAuthOrgnise record);
    
    public Integer getNums();
}