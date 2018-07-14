package com.qiji.dao;

import com.qiji.domain.MicroVote;

public interface MicroVoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroVote record);

    int insertSelective(MicroVote record);

    MicroVote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroVote record);

    int updateByPrimaryKey(MicroVote record);
}