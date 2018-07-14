package com.qiji.dao;

import com.qiji.domain.MicroVoteRecord;

public interface MicroVoteRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroVoteRecord record);

    int insertSelective(MicroVoteRecord record);

    MicroVoteRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroVoteRecord record);

    int updateByPrimaryKey(MicroVoteRecord record);
}