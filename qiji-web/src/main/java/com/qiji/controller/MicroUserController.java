package com.qiji.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.domain.MicroUsers;
import com.qiji.service.IMicroUsersService;

@RestController
@RequestMapping("/users")
public class MicroUserController {

	private final static Logger logger = LoggerFactory.getLogger(MicroUserController.class);
	@Autowired
	private IMicroUsersService microUsersService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<MicroUsers> findAllUsers(Integer pageNum, Integer pageSize){
		return microUsersService.findAllUsers(pageNum, pageSize);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelJson login(MicroUsers user){
		ModelJson modelJson = new ModelJson();
		
		try{
			MicroUsers loginUser = microUsersService.login(user);
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
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelJson register(HttpServletRequest request){
		ModelJson modelJson = new ModelJson();
		
		try{
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
			
			
			MicroUsers user = new MicroUsers();
			user.setLoginIp(ip);
			user.setUtel(request.getParameter("utel"));
			user.setUpwd(request.getParameter("upwd"));
			user.setUtype(request.getParameter("utype") == null?null:new Byte(request.getParameter("utype")));
			microUsersService.register(user);
			
		}catch(BusinessException e){
			modelJson.setSucc(false);
			modelJson.setMessage(e.getMessage());
			modelJson.setObj(null);
			logger.error(e.getMessage());
			e.printStackTrace();
			return modelJson;
		}catch(Exception e){
			modelJson.setSucc(false);
			modelJson.setOperSucc(false);
			modelJson.setMessage("系统异常！");
			modelJson.setObj(null);
			e.printStackTrace();
			logger.error(e.getMessage());
			return modelJson;
		}
		return modelJson;
	}
	
}
