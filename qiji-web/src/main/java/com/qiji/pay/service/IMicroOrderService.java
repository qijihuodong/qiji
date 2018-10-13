package com.qiji.pay.service;

import java.util.List;

import com.qiji.domain.MicroOrder;

public interface IMicroOrderService {

	/**
	 * 根据订单号查询订单信息
	 * @param tradeNo
	 * @return
	 */
	public MicroOrder queryOrderByTradeNo(String tradeNo);
	
	/**
	 * 根据交易状态或支付状态，查询购买的订单
	 * @param buyUid
	 * @param status
	 * @param tradeStatus
	 * @return
	 */
	public List<MicroOrder> queryMyBuyOrder(Integer buyUid,Byte status,Byte tradeStatus);
	
	/**
	 * 根据交易状态或支付状态，查询卖出的订单
	 * @param sellUid
	 * @param status
	 * @param tradeStatus
	 * @return
	 */
	public List<MicroOrder> queryMySellOrder(Integer sellUid,Byte status,Byte tradeStatus);
	
	
	/**
	 * 根据交易状态或支付状态，查询我的订单（含买入、卖出）
	 * @param uid
	 * @param status
	 * @param tradeStatus
	 * @return
	 */
	public List<MicroOrder> queryMyOrder(Integer uid,Byte status,Byte tradeStatus);
	
	/**
	 * 根据订单号和价钱更新订单状态
	 * @param order
	 */
	public void updateOrderByTradeNo(MicroOrder order);
	
}
