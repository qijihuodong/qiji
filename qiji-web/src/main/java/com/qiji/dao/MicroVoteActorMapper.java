package com.qiji.dao;

import com.qiji.domain.MicroVoteActor;

public interface MicroVoteActorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroVoteActor record);

    int insertSelective(MicroVoteActor record);

    MicroVoteActor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroVoteActor record);

    int updateByPrimaryKey(MicroVoteActor record);
}