package com.qiji.service;

import java.util.List;

import com.qiji.domain.MicroCarousel;

/**
 * 首页轮播图
 * @author zjw
 *
 */
public interface IMicroCarouselService {
	public List<MicroCarousel> getMicroCarousels(MicroCarousel microCarousel);
}
