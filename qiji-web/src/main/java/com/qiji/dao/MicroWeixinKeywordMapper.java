package com.qiji.dao;

import com.qiji.domain.MicroWeixinKeyword;

public interface MicroWeixinKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroWeixinKeyword record);

    int insertSelective(MicroWeixinKeyword record);

    MicroWeixinKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroWeixinKeyword record);

    int updateByPrimaryKeyWithBLOBs(MicroWeixinKeyword record);

    int updateByPrimaryKey(MicroWeixinKeyword record);
}