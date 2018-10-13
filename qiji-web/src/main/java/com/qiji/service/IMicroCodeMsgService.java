package com.qiji.service;

import com.qiji.domain.MicroCodeMsg;

public interface IMicroCodeMsgService {
	
	public void addVCode(MicroCodeMsg record);

	public boolean isVCodeRight(MicroCodeMsg record);
    
    public boolean isVCodeExits(MicroCodeMsg record);
}
