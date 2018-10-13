package com.qiji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroCitiesMapper;
import com.qiji.domain.MicroCities;
import com.qiji.service.IMicroCitiesService;

@Service("microCitiesService")
public class MicroCitiesServiceImpl implements IMicroCitiesService {

	@Autowired
	private MicroCitiesMapper microCitiesMapper;
	
	@Override
	public List<MicroCities> getAllCities() {
		return microCitiesMapper.getAllCities();
	}

	@Override
	public List<MicroCities> getCapitals() {
		return microCitiesMapper.getCapitals();
	}

	@Override
	public List<MicroCities> getCitiesByProvinceId(String proviceid) {
		return microCitiesMapper.getCitiesByProvinceId(proviceid);
	}

}
