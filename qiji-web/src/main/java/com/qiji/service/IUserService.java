package com.qiji.service;

public interface IUserService {
	
	/**
	 * 我的订单
	 * @param uid
	 * @return
	 */
	public Integer getMyOrderNum(Integer uid);
	
	/**
	 * 待评价的
	 * @param uid
	 * @return
	 */
	public Integer getMyAssessNum(Integer uid);
	
	/**
	 * 我的消息
	 * @param uid
	 * @return
	 */
	public Integer getMyMessageNum(Integer uid);
	
	/**
	 * 待确认的
	 * @param uid
	 * @return
	 */
	public Integer getMyConfirmNum(Integer uid);
	
	/**
	 * 我发布的
	 * @param uid
	 * @return
	 */
	public Integer getMyReleaseNum(Integer uid);
	
	
	/**
	 * 合作中的
	 * @param uid
	 * @return
	 */
	public Integer getMyJoinNum(Integer uid);

	
}
