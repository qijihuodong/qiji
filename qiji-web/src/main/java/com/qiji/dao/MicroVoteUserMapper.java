package com.qiji.dao;

import com.qiji.domain.MicroVoteUser;

public interface MicroVoteUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroVoteUser record);

    int insertSelective(MicroVoteUser record);

    MicroVoteUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroVoteUser record);

    int updateByPrimaryKey(MicroVoteUser record);
}