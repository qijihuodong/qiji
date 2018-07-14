package com.qiji.dao;

import com.qiji.domain.MicroWeixinUser;

public interface MicroWeixinUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroWeixinUser record);

    int insertSelective(MicroWeixinUser record);

    MicroWeixinUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroWeixinUser record);

    int updateByPrimaryKeyWithBLOBs(MicroWeixinUser record);

    int updateByPrimaryKey(MicroWeixinUser record);
}