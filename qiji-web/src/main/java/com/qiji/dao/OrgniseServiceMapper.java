package com.qiji.dao;

import com.qiji.domain.OrgniseService;

public interface OrgniseServiceMapper {
    int insert(OrgniseService record);

    int insertSelective(OrgniseService record);
}