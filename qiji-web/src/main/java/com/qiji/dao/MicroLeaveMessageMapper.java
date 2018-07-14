package com.qiji.dao;

import com.qiji.domain.MicroLeaveMessage;

public interface MicroLeaveMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroLeaveMessage record);

    int insertSelective(MicroLeaveMessage record);

    MicroLeaveMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroLeaveMessage record);

    int updateByPrimaryKey(MicroLeaveMessage record);
}