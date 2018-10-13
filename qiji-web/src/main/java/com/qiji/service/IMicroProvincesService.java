package com.qiji.service;

import java.util.List;

import com.qiji.domain.MicroProvinces;

public interface IMicroProvincesService {
	
	/**
	 * 获取全部省列表
	 * @return
	 */
	public List<MicroProvinces> getAllProvinces();
	
	
}
