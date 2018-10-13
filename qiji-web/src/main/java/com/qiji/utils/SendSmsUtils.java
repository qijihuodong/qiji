package com.qiji.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.qiji.common.BusinessException;
import com.qiji.common.SysException;
import com.qiji.domain.MicroCodeMsg;
import com.qiji.entity.ReturnSms;

public class SendSmsUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(SendSmsUtils.class);
	
	/**
	 * 获取6位随机验证码
	 * @return
	 */
	private static String getVCode(){
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
		return verifyCode;
	}
	
	private static String getSmsContent(String vCode){
		String smsContent = "您的验证码是" + vCode + "，请在5分钟内使用，登陆网址： http://qj101.com ，记得收藏，更多详情可关注公众号：奇迹活动。";
		return smsContent;
	}
	
	
	public static MicroCodeMsg sendVCodeSms(String mobile){
		
		String smsContent = "";
		String smsEncode = "UTF-8";
		MicroCodeMsg microCodeMsg = new MicroCodeMsg();
		String vCode = getVCode();
		
		if(StringUtils.isBlank(mobile)){
			logger.error("手机号码为空！");
			throw new BusinessException("手机号码为空！");
		}
		microCodeMsg.setCode(vCode);
		microCodeMsg.setMobile(mobile);
		microCodeMsg.setAddTime((int)(new Date().getTime()/1000));
		microCodeMsg.setResult("");
		
		try {
			smsContent = URLEncoder.encode(getSmsContent(vCode), smsEncode);
			StringBuilder sb = new StringBuilder("http://www.duanxin10086.com/sms.aspx?action=send");
			sb.append("&userid=14777");
			sb.append("&account=qijihuodong");
			sb.append("&password=123456");
			sb.append("&mobile=").append(mobile);
			sb.append("&content=").append(smsContent);
			sb.append("&taskName=sendvcode&checkcontent=0&mobilenumber=1&countnumber=1&telephonenumber=0");
			String url = sb.toString();
			JSONObject jsonObject = HttpUtil.doGet(url, null);
			logger.info( "调用短信中心返回报文：" + jsonObject.toJSONString());
			boolean success = jsonObject.getBooleanValue("success");
			String message = jsonObject.getString("msg");
			int code = jsonObject.getIntValue("code");
			String data = null;
			if(success){
				data = jsonObject.getString("data");
				if(StringUtils.isBlank(data)){
					logger.error("调用短信中心错误，错误原因：返回报文格式错误！");
					throw new SysException("调用短信中心错误，错误原因：返回报文格式错误！");
				}
				microCodeMsg.setResult(data);
				StringReader sr = new StringReader(data);
				ReturnSms returnSms = JaxbUtil.convertToJavaBean(ReturnSms.class, sr);
				if(null == returnSms){
					logger.error("解析报文错误！");
					throw new SysException("解析报文错误！");
				}
				if(StringUtils.isBlank(returnSms.getReturnstatus())){
					logger.error("无法获取调用短信中心状态！");
					throw new SysException("无法获取调用短信中心状态！");
				}
				logger.info( "解析后报文：" + returnSms.toString());
				if("Success".equalsIgnoreCase(returnSms.getReturnstatus())){
					return microCodeMsg;
				}else{
					logger.error("调用短信中心错误，错误信息：" + returnSms.getMessage()==null?"":returnSms.getMessage());
					throw new BusinessException("调用短信中心错误，错误信息：" + returnSms.getMessage()==null?"":returnSms.getMessage());
				}
			}else{//有报错，不会返回data
				logger.error("调用短信中心错误，错误码："+ code + "错误信息：" + message);
				throw new SysException("调用短信中心错误，错误码："+ code + "错误信息：" + message);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("系统内部错误，不支持的编码格式！");
			throw new SysException("系统内部错误，不支持的编码格式！");
		} catch (SysException e){
			logger.error(e.getMessage());
			throw new SysException(e.getMessage());
		}
	}
	
	
}
