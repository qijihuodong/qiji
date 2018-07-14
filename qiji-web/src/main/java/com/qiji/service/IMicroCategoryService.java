package com.qiji.service;

import java.util.List;
import java.util.Map;

import com.qiji.domain.MicroCategory;

public interface IMicroCategoryService {
	public Map<String, List<MicroCategory>> getMicroCategoryList();
}
