package com.qiji.dao;

import com.qiji.domain.MicroActFeedback;

public interface MicroActFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroActFeedback record);

    int insertSelective(MicroActFeedback record);

    MicroActFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroActFeedback record);

    int updateByPrimaryKey(MicroActFeedback record);
}