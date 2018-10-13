package com.qiji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroSchoolMapper;
import com.qiji.domain.MicroSchool;
import com.qiji.service.IMicroSchoolService;

@Service("microSchoolService")
public class MicroSchoolServiceImpl implements IMicroSchoolService {

	@Autowired
	private MicroSchoolMapper microSchoolMapper;
	
	@Override
	public List<String> getSchoolTypes() {
		// TODO Auto-generated method stub
		return microSchoolMapper.getSchoolTypes();
	}

	@Override
	public List<MicroSchool> getSchoolsByType(String type) {
		return microSchoolMapper.getSchoolsByType(type);
	}

	@Override
	public List<Integer> getSchoolIdsByType(String type) {
		return microSchoolMapper.getSchoolIdsByType(type);
	}

}
