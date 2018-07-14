package com.qiji.dao;

import com.qiji.domain.MicroPushtaskUserlist;

public interface MicroPushtaskUserlistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroPushtaskUserlist record);

    int insertSelective(MicroPushtaskUserlist record);

    MicroPushtaskUserlist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroPushtaskUserlist record);

    int updateByPrimaryKey(MicroPushtaskUserlist record);
}