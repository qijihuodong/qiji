package com.qiji.dao;

import com.qiji.domain.MicroMember;

public interface MicroMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroMember record);

    int insertSelective(MicroMember record);

    MicroMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroMember record);

    int updateByPrimaryKey(MicroMember record);
}