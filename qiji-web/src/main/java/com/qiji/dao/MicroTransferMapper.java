package com.qiji.dao;

import com.qiji.domain.MicroTransfer;

public interface MicroTransferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroTransfer record);

    int insertSelective(MicroTransfer record);

    MicroTransfer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroTransfer record);

    int updateByPrimaryKey(MicroTransfer record);
}