package com.qiji.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.common.SysException;
import com.qiji.domain.MicroCategory;
import com.qiji.service.IMicroCategoryService;

@RestController
@RequestMapping("/category")
public class MicroCategoryController {

	private final static Logger logger = LoggerFactory.getLogger(MicroCategoryController.class);
	
	@Autowired
	private IMicroCategoryService microCategoryService;
	
	
	@RequestMapping(value="/getSecondCategory",method=RequestMethod.POST)
	public ModelJson getSecondCategory(Integer category_parent_id){
		ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		
		try{
			List<MicroCategory> secondCategoryLists = microCategoryService.getSecondCategoryList(category_parent_id);
			modelJson.setSucc(true);
			modelJson.setOperSucc(true);
			modelJson.setObj(secondCategoryLists);
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
