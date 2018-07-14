package com.qiji.dao;

import com.qiji.domain.MicroCarousel;

public interface MicroCarouselMapper {
    int deleteByPrimaryKey(Integer carouselId);

    int insert(MicroCarousel record);

    int insertSelective(MicroCarousel record);

    MicroCarousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(MicroCarousel record);

    int updateByPrimaryKey(MicroCarousel record);
}