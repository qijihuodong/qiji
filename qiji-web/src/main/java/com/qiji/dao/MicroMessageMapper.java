package com.qiji.dao;

import com.qiji.domain.MicroMessage;

import java.util.List;

public interface MicroMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroMessage record);

    int insertSelective(MicroMessage record);

    MicroMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroMessage record);

    int updateByPrimaryKey(MicroMessage record);

    List<MicroMessage> selectList(MicroMessage param);
}