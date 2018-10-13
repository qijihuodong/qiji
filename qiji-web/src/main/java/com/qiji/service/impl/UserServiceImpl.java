package com.qiji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroActivitiesMapper;
import com.qiji.dao.MicroMessageMapper;
import com.qiji.dao.MicroOrderMapper;
import com.qiji.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	public MicroOrderMapper microOrderMapper;//企业主动购买
	@Autowired
	public MicroActivitiesMapper microActivitiesMapper;//服务商主动抢单
	@Autowired
	public MicroMessageMapper microMessageMapper;//消息
	
	@Override
	public Integer getMyOrderNum(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMyAssessNum(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMyMessageNum(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMyConfirmNum(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMyReleaseNum(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMyJoinNum(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
