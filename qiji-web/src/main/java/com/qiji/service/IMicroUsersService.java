package com.qiji.service;

import java.util.List;

import com.qiji.domain.MicroUsers;

public interface IMicroUsersService {
	
	public MicroUsers login(MicroUsers user);
	
	public List<MicroUsers> findAllUsers(Integer pageNum,Integer pageSize);
	
	public boolean isUserExits(MicroUsers user);
	
	public void register(MicroUsers user);
	
	public void forget(MicroUsers user);
	
	public MicroUsers updateMyInfo(MicroUsers user); 
	
	public MicroUsers getMyInfo(String utel);
}
