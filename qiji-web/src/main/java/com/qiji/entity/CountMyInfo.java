package com.qiji.entity;

public class CountMyInfo {
	private Integer nums;
	/**
	 * 统计类型：
	 * 1-我的订单
	 * 2-待评价的
	 * 3-最新消息
	 * 4-待确定的
	 * 5-我发布的
	 * 6-合作中的
	 */
	private String type;
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
