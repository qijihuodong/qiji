package com.qiji.dao;

import com.qiji.domain.MicroPersonalCarousel;

public interface MicroPersonalCarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroPersonalCarousel record);

    int insertSelective(MicroPersonalCarousel record);

    MicroPersonalCarousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroPersonalCarousel record);

    int updateByPrimaryKey(MicroPersonalCarousel record);
}