package com.qiji.service;

import java.util.List;
import java.util.Map;

import com.qiji.domain.MicroCategory;

public interface IMicroCategoryService {
	
	/**
	 * 获取首页服务分类
	 * @return
	 */
	public Map<String, List<MicroCategory>> getIndexMicroCategoryList();
	
	/**
	 * 获取服务大类
	 * @return
	 */
	public List<MicroCategory> getRootCategoryList();

	/**
	 * 根据服务大类获取细类
	 * @param rootId
	 * @return
	 */
	public List<MicroCategory> getSecondCategoryList(Integer rootId);
	
	/**
	 * 获取需求和服务页面第一条细类
	 * @return
	 */
	public List<MicroCategory> getFirstForSecondCategory();
	
	
}
