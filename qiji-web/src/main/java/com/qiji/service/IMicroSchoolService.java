package com.qiji.service;

import java.util.List;

import com.qiji.domain.MicroSchool;

public interface IMicroSchoolService {

	/**
	 * 获取学校类型（一本、二本、三本、专科）
	 * @return
	 */
	public List<String> getSchoolTypes();
    
	/**
	 * 根据类型获取学校列表
	 * @param type
	 * @return
	 */
    public List<MicroSchool> getSchoolsByType(String type);
    
    
    /**
     * 根据类型获取学校ID列表
     * @param type
     * @return
     */
    public List<Integer> getSchoolIdsByType(String type);
}
