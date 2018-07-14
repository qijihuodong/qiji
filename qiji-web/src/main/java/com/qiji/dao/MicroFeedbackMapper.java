package com.qiji.dao;

import com.qiji.domain.MicroFeedback;
import com.qiji.domain.MicroFeedbackWithBLOBs;

public interface MicroFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroFeedbackWithBLOBs record);

    int insertSelective(MicroFeedbackWithBLOBs record);

    MicroFeedbackWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroFeedbackWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MicroFeedbackWithBLOBs record);

    int updateByPrimaryKey(MicroFeedback record);
}