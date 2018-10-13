package com.qiji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroAreasMapper;
import com.qiji.domain.MicroAreas;
import com.qiji.service.IMicroAreasService;

@Service("microAreasService")
public class MicroAreasServiceImpl implements IMicroAreasService {

	@Autowired
	private MicroAreasMapper microAreasMapper;
	@Override
	public List<MicroAreas> getAllAreas() {
		return microAreasMapper.getAllAreas();
	}

	@Override
	public List<MicroAreas> getAreasByCityId(String cityId) {
		return microAreasMapper.getAreasByCityId(cityId);
	}

}
