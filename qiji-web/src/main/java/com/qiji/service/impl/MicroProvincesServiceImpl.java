package com.qiji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroProvincesMapper;
import com.qiji.domain.MicroProvinces;
import com.qiji.service.IMicroProvincesService;

@Service("microProvincesService")
public class MicroProvincesServiceImpl implements IMicroProvincesService {
	
	
	@Autowired
	private MicroProvincesMapper microProvincesMapper;
	@Override
	public List<MicroProvinces> getAllProvinces() {
		return microProvincesMapper.getAllProvinces();
	}

}
