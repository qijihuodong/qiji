package com.qiji.pay.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.qiji.common.BusinessException;
import com.qiji.common.SysException;
import com.qiji.dao.MicroOrderMapper;
import com.qiji.dao.MicroServiceContentStandardMapper;
import com.qiji.dao.MicroServiceMapper;
import com.qiji.dao.ServiceListMapper;
import com.qiji.domain.MicroOrder;
import com.qiji.domain.MicroService;
import com.qiji.domain.MicroServiceContentStandard;
import com.qiji.domain.ServiceList;
import com.qiji.pay.service.IWxPayService;
import com.qiji.utils.PayNumGenUtils;

@Service("wxPayService")
public class WxPayServiceImpl implements IWxPayService {

	private static Logger logger = Logger.getLogger(WxPayServiceImpl.class);
	@Autowired
	private WXPayConfig myWxPayConfig;
	@Autowired
	private MicroServiceMapper microServiceMapper;
	
	@Autowired
	private MicroServiceContentStandardMapper microServiceContentStandardMapper;
//	@Autowired
//	private MicroServiceContentMapper microServiceContentMapper;
//	@Autowired
//	private MicroServiceContentStandardMapper microServiceContentStandardMapper;
//	@Autowired
//	private MicroCategoryConfigMapper microCategoryConfigMapper;
//	@Autowired
//	private MicroCategoryMapper microCategoryMapper;
	
	@Autowired
	private MicroOrderMapper microOrderMapper;
	
	@Value("${wxPay.pay.notify_url}")
    private String notify_url;
	

	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	@Autowired
	private ServiceListMapper serviceListMapper;
	@Override
	public Map<String, String> unifiedOrder(MicroOrder order,String ip) {
		// 发起微信支付
		WXPay wxpay = null;
		Map<String, String> result = new HashMap<String, String>();
		
		try {
		    // ******************************************
		    //
		    //  统一下单
		    //
		    // ******************************************
		    wxpay = new WXPay(myWxPayConfig); // *** 注入自己实现的微信配置类, 创建WXPay核心类, WXPay 包括统一下单接口

		    Map<String, String> data = new HashMap<String, String>();
		    
		    MicroService microService = microServiceMapper.selectByPrimaryKey(order.getServiceId());
		    ServiceList serviceList = new ServiceList();
//		    serviceList.setServicePropName("服务商");
		    serviceList.setServiceId(order.getServiceId().longValue());
			List<ServiceList> serviceLists = serviceListMapper.getServiceByProp(serviceList);
		    if(null == serviceLists || serviceLists.size() <= 0){
		    	logger.error("服务[" + order.getServiceId() + "]信息不存在，请查证！");
		    	throw new BusinessException("获取服务信息失败！");
		    }
		    
		    //获取价钱
		    String orderDesc = "";
		    String orderPriceStr = "";
		    Long orderPrice = 0L;
		    MicroServiceContentStandard standard = null;
		    for(ServiceList list : serviceLists){
		    	if("服务商".equals(list.getServicePropName())){
		    		orderDesc = list.getServicePropValue();
		    	}
		    	if("单价".equals(list.getServicePropName())){
		    		orderPriceStr = list.getServicePropValue();
		    	}
		    	
		    }
	    	if(order.getStandardId() != null){
	    		standard = microServiceContentStandardMapper.selectByPrimaryKey(order.getStandardId());
	    		if(null != standard){
	    			orderPriceStr=standard.getPrice();
	    		}
	    		
	    	}
		    
		    if(StringUtils.isNotBlank(orderPriceStr)){
		    	orderPriceStr = orderPriceStr.replaceAll("元","").replace(" ", "");
		    }else{
		    	logger.error("服务[" + order.getServiceId() + "]金额信息不存在，请查证！");
		    	throw new BusinessException("获取服务金额信息失败！");
		    }
		    
		    try{
		    	orderPrice = Long.valueOf(orderPriceStr) * 100;
		    	order.setPrice(new BigDecimal(orderPriceStr));
		    }catch (NumberFormatException e) {
		    	logger.error("服务[" + order.getServiceId() + "]金额信息不正确，请查证！");
		    	throw new BusinessException("获取服务金额信息失败！");
			}
		    
		    String out_trade_no = PayNumGenUtils.genOrderIdByTime("1");
		    data.put("body", orderDesc);//商品简单描述，该字段请按照规范传递，具体请见参数规定
		    data.put("detail", "奇迹活动服务购买");//商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”
		    data.put("out_trade_no", out_trade_no); // 订单唯一编号, 不允许重复
		    data.put("device_info", "WEB");//自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
//		    data.put("nonce_str", "1111");//随机字符串，长度要求在32位以内。推荐随机数生成算法(wxPay中已实现)
//		    data.put("total_fee", String.valueOf(transOrder.getOrderAmount().multiply(new BigDecimal(100)).intValue())); // 订单金额, 单位分
		    
		    //先写死为一分钱，后续金额取值逻辑要协商
		    data.put("total_fee", orderPrice.toString()); // 订单金额, 单位分
		    
		    
		    
		    
		    
		    
		    data.put("spbill_create_ip", ip); // 下单ip
//		    data.put("openid", openId); // 微信公众号统一标示openid
		    data.put("notify_url", notify_url); // 订单结果通知, 微信主动回调此接口
		    logger.info(notify_url);
		    data.put("trade_type", "NATIVE");  // JSAPI-公众号支付  NATIVE-扫码支付 APP-APP支付   说明详见参数规定
	        data.put("product_id", order.getServiceId()+ "" +microService.getUid());//trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。

	        //写入订单表
	        order.setSellUid(microService.getUid());
//	        order.setStandardId(standardId);
	        order.setAddTime(new Date());
	        //TODO
	        order.setNumber(1);//数量暂时写死为1
	        order.setStatus(new Byte("0"));//0-未支付 1-已成功
	        order.setTradeNo(out_trade_no);
	        order.setTradeStatus(new Byte("0"));//交易状态 0-待确认 1-平台确认 2-雇主确认 3-服务商完成确认 4-雇主完成确认
	        
		    logger.info("发起微信支付下单接口, request=" + data);
		    Map<String, String> response = wxpay.unifiedOrder(data); // 微信sdk集成方法, 统一下单接口unifiedOrder, 此处请求   MD5加密   加密方式
//		    logger.info("微信支付下单成功, 返回值 response={}", response);
		    if(null == response){
		    	logger.error("调用微信服务未收到响应！");
		    	throw new BusinessException("调用微信服务失败！");
		    }
		    logger.info("微信支付下单接口响应, response=" + response);
		    
		    String returnCode = response.get("return_code");
		    if (!"SUCCESS".equals(returnCode)) {
		    	logger.error("调用微信服务失败，失败原因：" + response.get("return_msg"));
		    	throw new BusinessException("调用微信服务失败！");
		    }
		    String resultCode = response.get("result_code");
		    if (!"SUCCESS".equals(resultCode)) {
		    	String errCode = response.get("err_code");
		    	logger.error("调用微信服务失败，错误码：" + errCode + "，错误描述：" + response.get("err_code_des"));
		    	
		    	if(StringUtils.isBlank(errCode)){
		    		throw new BusinessException("调用微信服务失败！");
		    	}else if("NOTENOUGH".equals(errCode.trim())) {
		    		throw new BusinessException("余额不足，请充值！");
		    	}else if("ORDERPAID".equals(errCode.trim())) {
		    		throw new BusinessException("订单已支付，无需重复操作！");
		    	}else if("ORDERCLOSED".equals(errCode.trim())) {
		    		throw new BusinessException("当前订单已关闭，请重新下单！");
		    	}else if("OUT_TRADE_NO_USED".equals(errCode.trim())) {
		    		throw new BusinessException("订单号重复！");
		    	}
		    	
		    	
		    	throw new BusinessException("调用微信服务失败！");
		    }
		    microOrderMapper.insert(order);
		    String nonce_str = response.get("nonce_str");//微信返回的随机字符串
		    String sign = response.get("sign");//微信返回的签名值
		    String prepay_id = response.get("prepay_id");//微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
		    String code_url = response.get("code_url");//trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
		    
		    result.put("nonce_str",nonce_str);
		    result.put("sign",sign);
		    result.put("prepay_id",prepay_id);
		    result.put("code_url",code_url);
		    result.put("out_trade_no", out_trade_no);
		    result.put("orderNm",orderDesc);
	
		    return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SysException("系统错误，请联系管理员！");
		}
		
		
	}
	@Override
	public Map<String, String> orderquery(MicroOrder order, String ip) {
		
		// 发起微信支付
				WXPay wxpay = null;
				Map<String, String> result = new HashMap<String, String>();
				
				try {
					wxpay = new WXPay(myWxPayConfig); // *** 注入自己实现的微信配置类, 创建WXPay核心类, WXPay 包括统一下单接口
					Map<String, String> reqData = new HashMap<String, String>();
					
					//transaction_id 微信订单号
					//out_trade_no 商户订单号
					//nonce_str 随机字符串
					//sign 签名
					//sign_type 签名类型
					
					wxpay.orderQuery(reqData );
				   
				}catch(Exception e){
					
				}
		
		
		
		
		
		return null;
	}
	@Override
	public Map<String, String> closeorder(MicroOrder order, String ip) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
