package com.qiji.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import com.qiji.common.BusinessException;
import com.qiji.common.ModelJson;
import com.qiji.common.SysException;
import com.qiji.domain.MicroOrder;
import com.qiji.domain.MicroUsers;
import com.qiji.pay.service.IMicroOrderService;
import com.qiji.pay.service.IWxPayService;
import com.qiji.service.IMicroUsersService;
import com.qiji.utils.QrCodeUtils;
import com.qiji.vo.WxPayOrderVo;


@RestController
@RequestMapping(value = "/wxPay")
public class WxPayController {
	
	private Logger logger = LoggerFactory.getLogger(WxPayController.class);
	
	@Autowired
	private IWxPayService wxPayService;
	
	@Autowired
	private WXPayConfig myWxPayConfig;
	@Autowired
	private IMicroUsersService microUsersService;
	
	private IMicroOrderService microOrderService;
	
	@RequestMapping(value = "/unifiedOrder", method = RequestMethod.POST)
	public ModelJson payCallback(HttpServletRequest request,HttpServletResponse response,MicroOrder order) {
		ModelJson returnJson = new ModelJson();
		returnJson.setOperSucc(false);
		returnJson.setSucc(false);
		WxPayOrderVo vo = new WxPayOrderVo();
	    try{
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
				returnJson.setMessage("跳转");
				returnJson.setObj("index.html");
//				request.getRequestDispatcher("/index").forward(request, response);
				return returnJson;
			}
			MicroUsers user = (MicroUsers) session.getAttribute("user");
			order.setBuyUid(user.getUid());
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
			logger.info("ip : " + ip);
			Map<String,String> datas = wxPayService.unifiedOrder(order, ip);
			if(StringUtils.isBlank(datas.get("code_url"))){
				throw new BusinessException("调用微信服务失败！");
			}else{
				returnJson.setOperSucc(true);
				returnJson.setSucc(true);
				vo.setQrCode(QrCodeUtils.getImageBase64String(QrCodeUtils.createQRCode(datas.get("code_url"))));
				vo.setOrderId(datas.get("out_trade_no"));//订单号
				vo.setOrderNm(datas.get("orderNm"));//服务名称
				returnJson.setObj(vo);
			}
			
	    }catch(BusinessException e){
	    	returnJson.setMessage(e.getMessage());
	    }catch(SysException e){
	    	returnJson.setMessage(e.getMessage());
	    }catch (Exception e){
	        logger.error("微信支付回调通知失败",e);
	        returnJson.setMessage("系统异常，请联系管理员!");
	    }
	    return returnJson;
	}
	
	
	/**
     * 获得微信支付通知回调结果
     * @param req
     * @param resp
     * @throws Exception 
     * @throws IOException
     */
    @RequestMapping(value = "/getWxPayNotify")
    public ModelJson getWxPayNotify(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	
    	ModelJson returnJson = new ModelJson();
		returnJson.setOperSucc(false);
		returnJson.setSucc(false);
		
		InputStream is = null;
		BufferedReader in = null;
		
        String notifyData = "";
        try {
            is = req.getInputStream();
            StringBuffer sb = new StringBuffer();  
            String s;
            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((s = in.readLine()) != null){  
                sb.append(s);  
            }  
            in.close();  
            is.close();

            notifyData = sb.toString();
            if(StringUtils.isBlank(notifyData)){
            	logger.error("微信响应失败！");
            	throw new BusinessException("微信响应失败");
            }
            
            
            WXPay wxpay = new WXPay(myWxPayConfig);
            Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);  // 转换成map
            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
                logger.info("支付成功");
                // 签名正确
                // 进行处理。
                // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
                //根据订单号查询订单信息，核对订单金额
                String out_trade_no = notifyMap.get("out_trade_no");
                String total_fee    = notifyMap.get("total_fee");
                String transaction_id    = notifyMap.get("transaction_id");
                MicroOrder order =  new MicroOrder();
                order.setTradeNo(out_trade_no);
                order.setWeixinTradeNo(transaction_id);
                order.setStatus(new Byte("1"));
                order.setPrice(new BigDecimal(total_fee).multiply(new BigDecimal("100")));
				//TODO 根据订单号查询状态和金额
                //更新订单信息到订单表
                microOrderService.updateOrderByTradeNo(order );
                
            }
            else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                logger.error("支付失败");
            }

            logger.info("微信支付返回的通知为：" + notifyMap);
            returnJson.setOperSucc(true);
            returnJson.setSucc(true);
            returnJson.setMessage("支付成功！");
            resp.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
        } catch(BusinessException e){
	    	returnJson.setMessage(e.getMessage());
	    }catch(SysException e){
	    	returnJson.setMessage(e.getMessage());
	    }catch (Exception e){
	        logger.error("微信支付回调通知失败",e);
	        returnJson.setMessage("系统异常，请联系管理员!");
	    }
	    return returnJson;
    }


}
