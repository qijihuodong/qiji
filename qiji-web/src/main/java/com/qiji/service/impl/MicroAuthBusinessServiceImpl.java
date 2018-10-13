package com.qiji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroAuthBusinessMapper;
import com.qiji.service.IMicroAuthBusinessService;

@Service("microAuthBusinessService")
public class MicroAuthBusinessServiceImpl implements IMicroAuthBusinessService {

	@Autowired
	private MicroAuthBusinessMapper microAuthBusinessMapper;
	
	@Override
	public Integer getBusinessNums() {
		return microAuthBusinessMapper.getNums();
	}

}
