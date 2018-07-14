package com.qiji.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroCategoryMapper;
import com.qiji.domain.MicroCategory;
import com.qiji.service.IMicroCategoryService;

@Service("microCategoryService")
public class MicroCategoryServiceImpl implements IMicroCategoryService {
	@Autowired
	private MicroCategoryMapper microCategoryMapper;
	@Override
	public Map<String, List<MicroCategory>> getMicroCategoryList() {
		
		Map<String, List<MicroCategory>> categorys = new HashMap<String, List<MicroCategory>>();
		MicroCategory record = new MicroCategory();
		record.setParentId(0);
		List<MicroCategory> topCatagorys = microCategoryMapper.getCatagoryByParentId(record );
		for(MicroCategory topCatagory : topCatagorys){
			record.setParentId(topCatagory.getId());
			List<MicroCategory> secondCatagorys = microCategoryMapper.getCatagoryByParentId(record );
			categorys.put(topCatagory.getName(), secondCatagorys);
			
		}
		
		// TODO Auto-generated method stub
		return categorys;
	}

}
