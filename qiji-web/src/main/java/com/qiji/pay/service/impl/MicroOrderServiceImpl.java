package com.qiji.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroOrderMapper;
import com.qiji.domain.MicroOrder;
import com.qiji.pay.service.IMicroOrderService;

@Service("microOrderService")
public class MicroOrderServiceImpl implements IMicroOrderService {

	@Autowired
	private MicroOrderMapper microOrderMapper;
	
	public MicroOrderMapper getMicroOrderMapper() {
		return microOrderMapper;
	}

	public void setMicroOrderMapper(MicroOrderMapper microOrderMapper) {
		this.microOrderMapper = microOrderMapper;
	}

	@Override
	public MicroOrder queryOrderByTradeNo(String tradeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MicroOrder> queryMyBuyOrder(Integer buyUid, Byte status,
			Byte tradeStatus) {
		return microOrderMapper.queryMyBuyOrder(buyUid, status, tradeStatus);
	}

	@Override
	public List<MicroOrder> queryMySellOrder(Integer sellUid, Byte status,
			Byte tradeStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MicroOrder> queryMyOrder(Integer uid, Byte status,
			Byte tradeStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderByTradeNo(MicroOrder order) {
		microOrderMapper.updateOrderByTradeNo(order);
	}

}
