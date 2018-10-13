package com.qiji.pay.service;

import java.util.Map;

import com.qiji.domain.MicroOrder;

public interface IWxPayService {

	/**
	 * 统一下单服务
	 * @param data
	 * @return
	 */
	public Map<String,String> unifiedOrder(MicroOrder order,String ip);
	
	/**
	 * 查询订单
	 * @param order
	 * @param ip
	 * @return
	 */
	public Map<String,String> orderquery(MicroOrder order,String ip);
	
	/**
	 * 关闭订单
	 * @param order
	 * @param ip
	 * @return
	 */
	public Map<String,String> closeorder(MicroOrder order,String ip);
	
	
}
