package com.qiji.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.common.SysException;
import com.qiji.domain.MicroAreas;
import com.qiji.domain.MicroCategory;
import com.qiji.domain.MicroCities;
import com.qiji.domain.MicroProvinces;
import com.qiji.service.IMicroAreasService;
import com.qiji.service.IMicroCategoryService;
import com.qiji.service.IMicroCitiesService;
import com.qiji.service.IMicroProvincesService;

@RestController
@RequestMapping("/key")
public class KeysController {

	private final static Logger logger = LoggerFactory.getLogger(KeysController.class);
	
	@Autowired
	private IMicroProvincesService microProvincesService;
	
	@Autowired
	private IMicroCitiesService microCitiesService;
	
	@Autowired
	private IMicroAreasService microAreasService;
	
	
	@RequestMapping(value="/getProvinces",method=RequestMethod.POST)
	public ModelJson getProvinces(){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			List<MicroProvinces> lists = microProvincesService.getAllProvinces();
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(lists);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	@RequestMapping(value="/getCities",method=RequestMethod.POST)
	public ModelJson getCities(){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			List<MicroCities> lists = microCitiesService.getAllCities();
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(lists);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	@RequestMapping(value="/getAreas",method=RequestMethod.POST)
	public ModelJson getAreas(){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			List<MicroAreas> lists = microAreasService.getAllAreas();
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(lists);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	
	@RequestMapping(value="/getCitiesByProvinceId",method=RequestMethod.POST)
	public ModelJson getCitiesByProvinceId(String provinceid){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			List<MicroCities> lists = microCitiesService.getCitiesByProvinceId(provinceid);
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(lists);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
	
	@RequestMapping(value="/getAreasByCityId",method=RequestMethod.POST)
	public ModelJson getAreasByCityId(String cityId){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			List<MicroAreas> lists = microAreasService.getAreasByCityId(cityId);
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(lists);
		}catch(BusinessException e){
			modelJson.setMessage(e.getMessage());
		}catch(SysException e){
			modelJson.setMessage("系统异常！");
		}catch(Exception e){
			modelJson.setMessage("系统异常！");
		}
		return modelJson;
	}
}
