package com.qiji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroAuthOrgniseMapper;
import com.qiji.service.IMicroAuthOrgniseService;

@Service("microAuthOrgniseService")
public class MicroAuthOrgniseServiceImpl implements IMicroAuthOrgniseService {

	@Autowired
	private MicroAuthOrgniseMapper microAuthOrgniseMapper;
	
	@Override
	public Integer getOrgniseNums() {
		return microAuthOrgniseMapper.getNums();
	}

}
