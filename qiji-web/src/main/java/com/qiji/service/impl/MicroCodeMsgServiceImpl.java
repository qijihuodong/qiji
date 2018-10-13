package com.qiji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiji.dao.MicroCodeMsgMapper;
import com.qiji.domain.MicroCodeMsg;
import com.qiji.service.IMicroCodeMsgService;

@Service("microCodeMsgService")
public class MicroCodeMsgServiceImpl implements IMicroCodeMsgService {

	@Autowired
	private MicroCodeMsgMapper microCodeMsgMapper;
	@Override
	public void addVCode(MicroCodeMsg record) {
		microCodeMsgMapper.insert(record);
	}

	@Override
	public boolean isVCodeRight(MicroCodeMsg record) {
		if(microCodeMsgMapper.isVCodeRight(record) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isVCodeExits(MicroCodeMsg record) {
		if(microCodeMsgMapper.isVCodeExits(record) > 0){
			return true;
		}
		return false;
	}

}
