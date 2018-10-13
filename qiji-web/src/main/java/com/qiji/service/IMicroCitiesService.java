package com.qiji.service;

import java.util.List;

import com.qiji.domain.MicroCities;

public interface IMicroCitiesService {
	
	/**
	 * 获取全部城市列表
	 * @return
	 */
	public List<MicroCities> getAllCities();
	
	/**
	 * 获取省会城市列表
	 * @return
	 */
	public List<MicroCities> getCapitals();
	
	/**
	 * 根据省ID获取城市列表
	 * @param proviceId
	 * @return
	 */
	public List<MicroCities> getCitiesByProvinceId(String proviceid);

}
