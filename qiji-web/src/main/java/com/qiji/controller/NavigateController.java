package com.qiji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qiji.common.SysException;
import com.qiji.domain.ActivityList;
import com.qiji.domain.MicroCategory;
import com.qiji.domain.MicroCities;
import com.qiji.domain.MicroOrder;
import com.qiji.domain.MicroServiceContent;
import com.qiji.domain.MicroUsers;
import com.qiji.domain.ServiceContent;
import com.qiji.domain.ServiceContentStandard;
import com.qiji.domain.ServiceList;
import com.qiji.pay.service.IMicroOrderService;
import com.qiji.service.IActivityService;
import com.qiji.service.IMicroAuthBusinessService;
import com.qiji.service.IMicroAuthOrgniseService;
import com.qiji.service.IMicroCategoryService;
import com.qiji.service.IMicroCitiesService;
import com.qiji.service.IMicroSchoolService;
import com.qiji.service.IMicroUsersService;
import com.qiji.service.IServiceService;
import com.qiji.vo.PayVo;

@RestController
public class NavigateController {

	@Autowired
	private IMicroCategoryService microCategoryService;
	@Autowired
	private IServiceService serviceService;
	@Autowired
	private IActivityService activityService;
	@Autowired
	private IMicroCitiesService microCitiesService;
	@Autowired
	private IMicroSchoolService microSchoolService;
	@Autowired
	private IMicroUsersService microUsersService;
	
	@Autowired
	private IMicroOrderService microOrderService;
	
	@Autowired
	private IMicroAuthBusinessService microAuthBusinessService;
	@Autowired
	private IMicroAuthOrgniseService microAuthOrgniseService;
	
	
	
	
	
	
	
	
	@RequestMapping({"/","/index.html","index"})
	public ModelAndView index(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("serviceList", microCategoryService.getIndexMicroCategoryList());
		MicroServiceContent servicecontent = new MicroServiceContent();
		data.put("serviceContentList",serviceService.getIndexServiceList(4, servicecontent ));
		data.put("activityContentList", activityService.getIndexServiceList(4, null));
		data.put("businessNums",microAuthBusinessService.getBusinessNums());
		data.put("OrgniseNums",microAuthOrgniseService.getOrgniseNums());
		return new ModelAndView("index",data);
	}
	@RequestMapping(value={"/register.html","register"},method=RequestMethod.GET)
	public ModelAndView register(){
		return new ModelAndView("register");
	}
	@RequestMapping(value={"/forget.html","forget"},method=RequestMethod.GET)
	public ModelAndView forget(){
		return new ModelAndView("forget");
	}
	
	@RequestMapping(value={"/about.html","about"},method=RequestMethod.GET)
	public ModelAndView about(){
		return new ModelAndView("about");
	}
	
	@RequestMapping(value={"/require.html","require"},method=RequestMethod.GET)
	public ModelAndView require(){
		
		Map<String,Object> data = new HashMap<String,Object>();
		
		
		List<MicroCategory> rootCategoryLists = microCategoryService.getRootCategoryList();//类型
		List<MicroCategory> secondCategoryLists = microCategoryService.getFirstForSecondCategory();//分类
		List<MicroCities> microCitiesLists = microCitiesService.getCapitals();//地区（省会）
		List<String> schoolTypes = microSchoolService.getSchoolTypes();//院校
		List<ActivityList> activityLists = activityService.getIndexServiceList(7, null);//分页显示前7条记录
		
		data.put("require_rootCategoryLists", rootCategoryLists);
		data.put("require_secondCategoryLists", secondCategoryLists);
		data.put("require_microCitiesLists", microCitiesLists);
		data.put("require_schoolTypes", schoolTypes);
		data.put("require_activityLists", activityLists);
		
		return new ModelAndView("require",data);
	}
	
	@RequestMapping(value={"/service.html","service"},method=RequestMethod.GET)
	public ModelAndView service(){
		
		Map<String,Object> data = new HashMap<String,Object>();
		
		
		List<MicroCategory> rootCategoryLists = microCategoryService.getRootCategoryList();//类型
		List<MicroCategory> secondCategoryLists = microCategoryService.getFirstForSecondCategory();//分类
		List<MicroCities> microCitiesLists = microCitiesService.getCapitals();//地区（省会）
		List<String> schoolTypes = microSchoolService.getSchoolTypes();//院校
		MicroServiceContent servicecontent = new MicroServiceContent();
		
		
		data.put("service_rootCategoryLists", rootCategoryLists);
		data.put("service_secondCategoryLists", secondCategoryLists);
		data.put("service_microCitiesLists", microCitiesLists);
		data.put("service_schoolTypes", schoolTypes);
		data.put("serviceContentList",serviceService.getIndexServiceList(7, servicecontent ));
		
		return new ModelAndView("service",data);
	}
	
	
	@RequestMapping(value={"/requireXQ.html","requireXQ"},method=RequestMethod.GET)
	public ModelAndView requireXQ(Integer activityActid){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("requireXQ_activityDetail", activityService.getActivityDetailById(activityActid));
		return new ModelAndView("requireXQ",data);
	}
	
	@RequestMapping(value={"/serviceXQ.html","serviceXQ"},method=RequestMethod.GET)
	public ModelAndView serviceXQ(Integer serviceId){
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("requireXQ_head", serviceService.getServiceHeaderById(serviceId));
		data.put("requireXQ_content", serviceService.getServiceDetailById(serviceId));
		data.put("requireXQ_content_standard", serviceService.getServiceStandardById(serviceId));		
		
		return new ModelAndView("serviceXQ",data);
	}
	
	@RequestMapping(value={"/publishXQ.html","publishXQ"},method=RequestMethod.GET)
	public ModelAndView publicXQ(){
		Map<String,Object> data = new HashMap<String,Object>();
		List<MicroCategory> rootCategoryLists = microCategoryService.getRootCategoryList();//类型
		List<MicroCategory> secondCategoryLists = microCategoryService.getFirstForSecondCategory();//分类
		
		data.put("publishXQ_secondCategoryLists", secondCategoryLists);
		data.put("publishXQ_rootCategoryLists", rootCategoryLists);
		return new ModelAndView("publishXQ",data);
	}
	
	@RequestMapping(value={"myInfo.html","myInfo"},method=RequestMethod.GET)
	public ModelAndView myInfo(HttpServletRequest request){
		Map<String,Object> data = new HashMap<String,Object>();
		HttpSession session = request.getSession();	
		
		MicroUsers loginUser = null;
		if(null == session.getAttribute("user")){//说明未登录
			String utel = request.getParameter("utel");
			String upwd = request.getParameter("upwd");
			
			if(StringUtils.isNotBlank(utel) && StringUtils.isNotBlank(upwd)){
				MicroUsers user = new MicroUsers();
				user.setUtel(utel);
				user.setUpwd(upwd);
				loginUser = microUsersService.login(user );
				session.setAttribute("user", loginUser);
			}
			
		}
		
		if(session == null || session.getAttribute("user") == null){
			return new ModelAndView("index");
		}
		MicroUsers user = (MicroUsers) session.getAttribute("user");
		
		String url = "";
		if(user.getUtype() == 2){//服务商
			url = "/service/myInfo";
		}else if(user.getUtype() == 3){//雇主
			url = "/business/myInfo";
		}else{
			throw new SysException("无法确定用户身份!");
		}
		
		data.put("user", user);
		
		return new ModelAndView(url,data);
	}
	
	@RequestMapping(value={"/myOrder.html","myOrder"},method=RequestMethod.GET)
	public ModelAndView myOrder(HttpServletRequest request){
		
		Map<String,Object> data = new HashMap<String,Object>();
		HttpSession session = request.getSession();	
		
		MicroUsers loginUser = null;
		if(null == session.getAttribute("user")){//说明未登录
			String utel = request.getParameter("utel");
			String upwd = request.getParameter("upwd");
			
			if(StringUtils.isNotBlank(utel) && StringUtils.isNotBlank(upwd)){
				MicroUsers user = new MicroUsers();
				user.setUtel(utel);
				user.setUpwd(upwd);
				loginUser = microUsersService.login(user );
				session.setAttribute("user", loginUser);
			}
			
		}
		
		if(session == null || session.getAttribute("user") == null){
			return new ModelAndView("index");
		}
		MicroUsers user = (MicroUsers) session.getAttribute("user");
		
		String url = "";
		if(user.getUtype() == 2){//服务商
			url = "my-order";
		}else if(user.getUtype() == 3){//雇主
			url = "my1-order";
		}else{
			throw new SysException("无法确定用户身份!");
		}
		List<MicroOrder> microOrdersNeedPay = microOrderService.queryMyBuyOrder(user.getUid(), Byte.valueOf("0"), null);//待付款的
		List<MicroOrder> microOrdersHasPay = microOrderService.queryMyBuyOrder(user.getUid(), Byte.valueOf("1"), null);//付款的
		data.put("microOrdersNeedPay", microOrdersNeedPay);
		data.put("microOrdersHasPay", microOrdersHasPay);
		data.put("user", user);
		
		return new ModelAndView(url,data);
	}
	
	@RequestMapping(value={"/myTradeInfo.html","myTradeInfo"},method=RequestMethod.GET)
	public ModelAndView myTradeInfo(HttpServletRequest request){
		
		Map<String,Object> data = new HashMap<String,Object>();
		HttpSession session = request.getSession();	
		
		MicroUsers loginUser = null;
		if(null == session.getAttribute("user")){//说明未登录
			String utel = request.getParameter("utel");
			String upwd = request.getParameter("upwd");
			
			if(StringUtils.isNotBlank(utel) && StringUtils.isNotBlank(upwd)){
				MicroUsers user = new MicroUsers();
				user.setUtel(utel);
				user.setUpwd(upwd);
				loginUser = microUsersService.login(user );
				session.setAttribute("user", loginUser);
			}
			
		}
		
		if(session == null || session.getAttribute("user") == null){
			return new ModelAndView("index");
		}
		MicroUsers user = (MicroUsers) session.getAttribute("user");
		
		String url = "";
		if(user.getUtype() == 2){//服务商
			url = "my-transaction-records";
		}else if(user.getUtype() == 3){//雇主
			url = "my1-transaction-records";
		}else{
			throw new SysException("无法确定用户身份!");
		}
		
		data.put("user", user);
		
		return new ModelAndView(url,data);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value={"/service_providers.html","service_providers"},method=RequestMethod.GET)
	public ModelAndView service_providers(){
		Map<String,Object> data = new HashMap<String,Object>();
		List<MicroCategory> rootCategoryLists = microCategoryService.getRootCategoryList();//类型
		List<MicroCategory> secondCategoryLists = microCategoryService.getFirstForSecondCategory();//分类
		
		data.put("publishXQ_secondCategoryLists", secondCategoryLists);
		data.put("publishXQ_rootCategoryLists", rootCategoryLists);
		return new ModelAndView("service_providers",data);
	}
	
	@RequestMapping(value={"/pay.html","pay"},method=RequestMethod.GET)
	public ModelAndView pay(Integer serviceId,Long contentStandardId){
		
		Map<String,Object> data = new HashMap<String,Object>();
		
		List<ServiceList> serviceList = serviceService.getServiceHeaderById(serviceId);
		List<ServiceContent> serviceContentList = serviceService.getServiceDetailById(serviceId);
		List<ServiceContentStandard> serviceContentStandardList = serviceService.getServiceStandardById(serviceId);
		
		PayVo payVo = new PayVo();
		payVo.setServiceId(Long.valueOf(serviceId));
		payVo.setServiceStandardId(contentStandardId);
		for(ServiceList service : serviceList){
			if("服务名称".equals(service.getServicePropName())){
				payVo.setTitle(service.getServicePropValue());
			}
			if("服务商".equals(service.getServicePropName())){
				payVo.setDesc(service.getServicePropValue());
			}
		}
		String price = "";
		for(ServiceContent serviceContent : serviceContentList){
			if("单价".equals(serviceContent.getConfigName())){
				price = serviceContent.getContentValue();
			}
		}
		if(StringUtils.isBlank(price)){
			for(ServiceContentStandard serviceContentStandard : serviceContentStandardList){
				if(contentStandardId == serviceContentStandard.getContentStandardId()){
					price = serviceContentStandard.getContentStandardPrice();
					break;
				}
			}
		}
		
		if(StringUtils.isNoneBlank(price)){
			price = price.replace("元","").trim();
		}
		
		
		
		payVo.setPriceAll(price);
		
		
		
		
		
		data.put("payVo", payVo);
		
		return new ModelAndView("pay",data);
	}
	
	@RequestMapping(value={"/pay_type.html","pay_type"},method=RequestMethod.GET)
	public ModelAndView pay_type(Integer serviceId,Long contentStandardId){
		
		Map<String,Object> data = new HashMap<String,Object>();
		List<ServiceList> serviceList = serviceService.getServiceHeaderById(serviceId);
		List<ServiceContent> serviceContentList = serviceService.getServiceDetailById(serviceId);
		List<ServiceContentStandard> serviceContentStandardList = serviceService.getServiceStandardById(serviceId);
		
		PayVo payVo = new PayVo();
		payVo.setServiceId(Long.valueOf(serviceId));
		payVo.setServiceStandardId(contentStandardId);
		for(ServiceList service : serviceList){
			if("服务名称".equals(service.getServicePropName())){
				payVo.setTitle(service.getServicePropValue());
			}
			if("服务商".equals(service.getServicePropName())){
				payVo.setDesc(service.getServicePropValue());
			}
		}
		String price = "";
		for(ServiceContent serviceContent : serviceContentList){
			if("单价".equals(serviceContent.getConfigName())){
				price = serviceContent.getContentValue();
			}
		}
		if(StringUtils.isBlank(price)){
			for(ServiceContentStandard serviceContentStandard : serviceContentStandardList){
				if(contentStandardId == serviceContentStandard.getContentStandardId()){
					price = serviceContentStandard.getContentStandardPrice();
					break;
				}
			}
		}
		
		if(StringUtils.isNoneBlank(price)){
			price = price.replace("元","").trim();
		}
		
		
		
		payVo.setPriceAll(price);
		
		
		
		
		
		data.put("payVo", payVo);
		
		return new ModelAndView("pay_type",data);
	}
	
}
