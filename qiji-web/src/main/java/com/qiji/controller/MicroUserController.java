package com.qiji.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.common.SysException;
import com.qiji.domain.MicroCodeMsg;
import com.qiji.domain.MicroUsers;
import com.qiji.service.IMicroCodeMsgService;
import com.qiji.service.IMicroUsersService;
import com.qiji.utils.SendSmsUtils;

@RestController
@RequestMapping("/users")
public class MicroUserController {

	private final static Logger logger = LoggerFactory.getLogger(MicroUserController.class);
	@Autowired
	private IMicroUsersService microUsersService;
	@Autowired
	private IMicroCodeMsgService microCodeMsgService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<MicroUsers> findAllUsers(Integer pageNum, Integer pageSize){
		return microUsersService.findAllUsers(pageNum, pageSize);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelJson login(HttpServletRequest request,MicroUsers user){
		ModelJson modelJson = new ModelJson();
		HttpSession session = request.getSession();
		try{
			MicroUsers loginUser = microUsersService.login(user);
			modelJson.setObj(loginUser);
			session.setAttribute("user",loginUser);
		}catch(BusinessException e){
			modelJson.setSucc(false);
			modelJson.setMessage(e.getMessage());
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}catch(Exception e){
			modelJson.setSucc(false);
			modelJson.setOperSucc(false);
			modelJson.setMessage("系统异常！");
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}
		return modelJson;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public ModelJson logout(HttpServletRequest request,MicroUsers user){
		ModelJson modelJson = new ModelJson();
		HttpSession session = request.getSession();
		try{
			session.removeAttribute("user");
		}catch(BusinessException e){
			modelJson.setSucc(false);
			modelJson.setMessage(e.getMessage());
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}catch(Exception e){
			modelJson.setSucc(false);
			modelJson.setOperSucc(false);
			modelJson.setMessage("系统异常！");
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}
		return modelJson;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelJson register(HttpServletRequest request){
		ModelJson modelJson = new ModelJson();
		HttpSession session = request.getSession();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			MicroUsers user = new MicroUsers();
			
			user.setUtel(request.getParameter("utel"));
			user.setUpwd(request.getParameter("upwd"));
			user.setVcode(request.getParameter("vcode"));
			user.setUtype(request.getParameter("utype") == null?null:new Byte(request.getParameter("utype")));
			if(null == user.getUtype()){
				modelJson.setMessage("系统错误，请联系管理员！");
				logger.error("未选择用户类型，请检查！");
			}else if(StringUtils.isBlank(user.getUtel())){
				modelJson.setMessage("请输入手机号！");
			}else if(StringUtils.isBlank(user.getVcode())){
				modelJson.setMessage("请输入验证码！");
			}else if(StringUtils.isBlank(user.getUpwd())){
				modelJson.setMessage("请输入密码！");
			}

			if(!StringUtils.isBlank(modelJson.getMessage())){
				throw new BusinessException(modelJson.getMessage());
			}
			MicroCodeMsg record = new MicroCodeMsg();
			record.setMobile(user.getUtel());
			record.setCode(user.getVcode());
			record.setAddTime((int)(new Date().getTime()/1000));
			if(!microCodeMsgService.isVCodeExits(record)){
				modelJson.setMessage("验证码错误！");
			}else if(!microCodeMsgService.isVCodeRight(record)){
				modelJson.setMessage("验证码错误！");
			}
			
			if(!StringUtils.isBlank(modelJson.getMessage())){
				throw new BusinessException(modelJson.getMessage());
			}
			
			
			
			String ip = request.getHeader("X-Forwarded-For");
			if (!StringUtils.isBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
				// 多次反向代理后会有多个ip值，第一个ip才是真实ip
				int index = ip.indexOf(",");
				if (index != -1) {
					ip = ip.substring(0, index);
				}
			}else{
				ip = request.getHeader("X-Real-IP");
				if (!StringUtils.isBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
				}else{
					ip = request.getRemoteAddr();
				}
			}
			
			
			user.setLoginIp(ip);
			microUsersService.register(user);
			MicroUsers loginUser = microUsersService.login(user);
			session.setAttribute("user",loginUser);
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(user);
			modelJson.setMessage("注册成功！");
			session.setAttribute("user",user);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	@RequestMapping(value="/getVCode",method=RequestMethod.POST)
	public ModelJson getVCode(MicroUsers user){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		try{
			if(null == user){
				modelJson.setMessage("请输入手机号！");
			}else if(StringUtils.isBlank(user.getUtel())){
				modelJson.setMessage("请输入手机号！");
			}else if(StringUtils.isBlank(user.getVcode()) && microUsersService.isUserExits(user)){
				//手机号已存在，请直接登录
				modelJson.setMessage("手机号已存在，请直接登录！");
			}else{
				MicroCodeMsg microCodeMsg = SendSmsUtils.sendVCodeSms(user.getUtel());
				microCodeMsgService.addVCode(microCodeMsg);
				modelJson.setSucc(true);
				modelJson.setOperSucc(true);
				modelJson.setMessage("验证码发送成功！");
			}
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	
	@RequestMapping(value="/forget",method=RequestMethod.POST)
	public ModelJson forget(HttpServletRequest request){
		ModelJson modelJson = new ModelJson();
		HttpSession session = request.getSession();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setCode("");
		modelJson.setObj(null);
		
		try{
			MicroUsers user = new MicroUsers();
			
			user.setUtel(request.getParameter("utel"));
			user.setUpwd(request.getParameter("upwd"));
			user.setVcode(request.getParameter("vcode"));
			if(StringUtils.isBlank(user.getUtel())){
				modelJson.setMessage("请输入手机号！");
			}else if(StringUtils.isBlank(user.getVcode())){
				modelJson.setMessage("请输入验证码！");
			}else if(StringUtils.isBlank(user.getUpwd())){
				modelJson.setMessage("请输入密码！");
			}

			if(!StringUtils.isBlank(modelJson.getMessage())){
				throw new BusinessException(modelJson.getMessage());
			}
			MicroCodeMsg record = new MicroCodeMsg();
			record.setMobile(user.getUtel());
			record.setCode(user.getVcode());
			record.setAddTime((int)(new Date().getTime()/1000));
			if(!microUsersService.isUserExits(user)){
				modelJson.setCode("001");
				modelJson.setMessage("用户不存在，请先注册！");
			}else if(!microCodeMsgService.isVCodeExits(record)){
				modelJson.setMessage("验证码错误！");
			}else if(!microCodeMsgService.isVCodeRight(record)){
				modelJson.setMessage("验证码错误！");
			}
			
			if(!StringUtils.isBlank(modelJson.getMessage())){
				throw new BusinessException(modelJson.getMessage());
			}
			
			
			microUsersService.forget(user);
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(user);
			modelJson.setMessage("重置密码成功！");
			session.setAttribute("user",user);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	@RequestMapping(value="/uMyInfo",method=RequestMethod.POST)
	public ModelJson uMyInfo(HttpServletRequest request,MicroUsers user){
		ModelJson modelJson = new ModelJson();
		HttpSession session = request.getSession();
		try{
			MicroUsers loginUser = microUsersService.updateMyInfo(user);
			request.getSession().setAttribute("user", loginUser);
			modelJson.setObj(loginUser);
			session.setAttribute("user",loginUser);
		}catch(BusinessException e){
			modelJson.setSucc(false);
			modelJson.setMessage(e.getMessage());
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}catch(Exception e){
			modelJson.setSucc(false);
			modelJson.setOperSucc(false);
			modelJson.setMessage("系统异常！");
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}
		return modelJson;
	}
	
	@RequestMapping(value="/getMyInfo",method=RequestMethod.POST)
	public ModelJson getMyInfo(HttpServletRequest request,String utel){
		ModelJson modelJson = new ModelJson();
		HttpSession session = request.getSession();
		try{
			MicroUsers loginUser = microUsersService.getMyInfo(utel);
			modelJson.setObj(loginUser);
		}catch(BusinessException e){
			modelJson.setSucc(false);
			modelJson.setMessage(e.getMessage());
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}catch(Exception e){
			modelJson.setSucc(false);
			modelJson.setOperSucc(false);
			modelJson.setMessage("系统异常！");
			modelJson.setObj(null);
			logger.error(e.getMessage());
			return modelJson;
		}
		return modelJson;
	}
}
