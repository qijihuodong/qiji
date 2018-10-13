package com.qiji.service;

import java.util.List;

import com.qiji.domain.MicroAreas;

public interface IMicroAreasService {
	
	/**
	 * 获取全部地区列表
	 * @return
	 */
	public List<MicroAreas> getAllAreas();
	
	/**
	 * 根据城市ID获取区列表
	 * @param cityId
	 * @return
	 */
	public List<MicroAreas> getAreasByCityId(String cityId);

}
