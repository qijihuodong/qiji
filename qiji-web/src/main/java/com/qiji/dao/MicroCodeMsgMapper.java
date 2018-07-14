package com.qiji.dao;

import com.qiji.domain.MicroCodeMsg;

public interface MicroCodeMsgMapper {
    int deleteByPrimaryKey(Integer codeId);

    int insert(MicroCodeMsg record);

    int insertSelective(MicroCodeMsg record);

    MicroCodeMsg selectByPrimaryKey(Integer codeId);

    int updateByPrimaryKeySelective(MicroCodeMsg record);

    int updateByPrimaryKey(MicroCodeMsg record);
}