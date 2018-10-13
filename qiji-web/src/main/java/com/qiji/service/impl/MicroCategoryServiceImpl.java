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
	public Map<String, List<MicroCategory>> getIndexMicroCategoryList() {
		
		Map<String, List<MicroCategory>> categorys = new HashMap<String, List<MicroCategory>>();
		//获取顶级服务列表
		List<MicroCategory> topCatagorys = microCategoryMapper.getCategoryByParentId(0);
		//获取第二级服务列表
		for(MicroCategory topCatagory : topCatagorys){
			List<MicroCategory> secondCatagorys = microCategoryMapper.getCategoryByParentId(topCatagory.getId() );
			categorys.put(topCatagory.getName(), secondCatagorys);
			
		}
		
		return categorys;
	}
	
	@Override
	public List<MicroCategory> getRootCategoryList(){
		//获取顶级服务列表
		List<MicroCategory> topCatagorys = microCategoryMapper.getCategoryByParentId(0);
		return topCatagorys;
	}

	@Override
	public List<MicroCategory> getSecondCategoryList(Integer rootId){
		List<MicroCategory> secondCatagorys = microCategoryMapper.getCategoryByParentId(rootId);
		return secondCatagorys;
	}

	@Override
	public List<MicroCategory> getFirstForSecondCategory() {
		return microCategoryMapper.getFirstForSecondCategory();
	}
}
