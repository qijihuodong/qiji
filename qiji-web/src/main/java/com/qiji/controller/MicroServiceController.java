package com.qiji.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.common.SysException;
import com.qiji.domain.MicroService;
import com.qiji.domain.ServiceList;
import com.qiji.service.IServiceService;
import com.qiji.utils.PageBean;
import com.qiji.vo.ServiceListVo;

@RestController
@RequestMapping("/service")
public class MicroServiceController {

	private final static Logger logger = LoggerFactory.getLogger(MicroServiceController.class);
	
	@Autowired
	private IServiceService serviceService;
	
	
	@RequestMapping(value="/getServiceList",method=RequestMethod.POST)
	public ModelJson getServiceList(Integer page,Integer rows,MicroService microService,ServiceList serviceList){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		if(page == null){
			page = 1;
		}else if(page <=0 ){
			page = 1;
		}
		
		if(rows == null){
			rows = 7;
		}
		try{
			PageHelper.startPage(page, rows);
			
			List<ServiceListVo> serviceLists = serviceService.getServiceList(microService, serviceList);
			
			
			PageInfo<ServiceListVo> pageInfo = new PageInfo<ServiceListVo>(serviceLists);
			
			PageBean<ServiceListVo> pageBean = new PageBean<ServiceListVo>();
			pageBean.setItems(serviceLists);
//			pageBean.setTotalNum(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
			pageBean.setTotalNum(serviceService.countServiceList(microService, serviceList));
			pageBean.setTotalPage(pageInfo.getPageNum());
			
			
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(pageBean);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			e.printStackTrace();
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			e.printStackTrace();
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	
}
