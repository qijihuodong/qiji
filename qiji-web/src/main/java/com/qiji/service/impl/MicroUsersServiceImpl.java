package com.qiji.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qiji.common.BusinessException;
import com.qiji.common.utils.ShaUtils;
import com.qiji.dao.MicroUsersMapper;
import com.qiji.domain.MicroUsers;
import com.qiji.service.IMicroUsersService;

@Service("microUsersService")
public class MicroUsersServiceImpl implements IMicroUsersService {

	private final static Logger logger = LoggerFactory.getLogger(MicroUsersServiceImpl.class);
	@Autowired
	private MicroUsersMapper microUsersMapper;
	
	@Override
	public MicroUsers login(MicroUsers user) {
		
		
		if(!isUserExits(user)){
			throw new BusinessException("用户不存在，请先注册！");
		}
		MicroUsers loginUser = null;
		try{
			user.setUpwd(ShaUtils.encryptSHA(user.getUpwd()));
			loginUser = microUsersMapper.getLoginUser(user);
			if(null == loginUser){
				throw new BusinessException("用户不存在或密码不正确！");
			}
		}catch(BusinessException e){
			throw new BusinessException(e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new BusinessException("系统异常！");
		}
		return loginUser;
	}

	@Override
	public List<MicroUsers> findAllUsers(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return microUsersMapper.findAllUsers();
	}

	@Override
	public boolean isUserExits(MicroUsers user) {
		String message = "";
//		message = checkUserIsNull(user);
		
		if(!StringUtils.isBlank(message)){
			throw new BusinessException(message);
		}
		if(microUsersMapper.isUserExists(user) > 0){
			return true;
		}
		return false;
	}
	
//	private String checkUserIsNull(MicroUsers user){
//		String message = "";
//		if(null == user || StringUtils.isBlank(user.getUtel())){
//			message = "请输入手机号！";
//		}else if(StringUtils.isBlank(user.getUpwd())){
//			message = "请输入密码！";
//		}else if(null == user.getUtype()){
//			message = "系统异常！";
//		}
//		
//		return message;
//	}

	@Override
	public void register(MicroUsers user) {
		
		if(isUserExits(user)){
			throw new BusinessException("用户已存在，请直接登录！");
		}
		try{
			user.setUpwd(ShaUtils.encryptSHA(user.getUpwd()));
			user.setCreateTime(new Date());
			user.setStatus(new Byte("0"));
			
			microUsersMapper.insertSelective(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException("系统异常！");
			
		}
		
	}
	
	@Override
	public void forget(MicroUsers user) {
		
		try{
			user.setUpwd(ShaUtils.encryptSHA(user.getUpwd()));
			user.setUpdateTime(new Date());
			
			microUsersMapper.updateByPrimaryKey(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException("系统异常！");
			
		}
		
	}

	@Override
	public MicroUsers updateMyInfo(MicroUsers user) {
		MicroUsers loginUser = null;
		try{
			loginUser = microUsersMapper.getUserByUtel(user.getUtel());
			if(null == loginUser){
				throw new BusinessException("用户不存在，请先注册！");
			}
			loginUser.setUid(loginUser.getUid());
			loginUser.setNickname(user.getNickname());
			loginUser.setEmail(user.getEmail());
			loginUser.setAddress(user.getAddress());
			loginUser.setLogourl(user.getLogourl());
			loginUser.setUpdateTime(new Date());
			loginUser.setGender(user.getGender());
			loginUser.setIntro(user.getIntro());
			loginUser.setSchool(user.getSchool());
			loginUser.setName(user.getSchool());
			loginUser.setMobile(user.getMobile());
			loginUser.setIdCardImg1(user.getIdCardImg1());
			loginUser.setIdCardImg2(user.getIdCardImg2());
			loginUser.setImg1(user.getImg1());
			loginUser.setImg2(user.getImg2());
			loginUser.setImg3(user.getImg3());
			microUsersMapper.updateMyInfoByPrimaryKey(loginUser);
			
		}catch(BusinessException e){
			throw new BusinessException(e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new BusinessException("系统异常！");
		}
		return loginUser;
	}

	@Override
	public MicroUsers getMyInfo(String utel) {
		MicroUsers loginUser = null;
		try{
			loginUser = microUsersMapper.getUserByUtel(utel);
			if(null == loginUser){
				throw new BusinessException("用户不存在，请先注册！");
			}
			
		}catch(BusinessException e){
			throw new BusinessException(e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new BusinessException("系统异常！");
		}
		return loginUser;
	}
}
