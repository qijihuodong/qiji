package com.qiji.service;

import com.qiji.domain.MicroCart;


/**
 * 购物车
 * @author zjw
 *
 */
public interface IMicroCartService {
	/**
	 * 获取购物车商品个数
	 * @param microCart
	 * @return
	 */
	public Integer getCartNums(MicroCart microCart);
}
