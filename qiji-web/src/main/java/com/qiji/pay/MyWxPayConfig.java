package com.qiji.pay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;
import com.qiji.common.BusinessException;

@Service("myWxPayConfig")
public class MyWxPayConfig extends WXPayConfig {

	private byte[] certData;

	
    @Value("${wxPay.config.app_id}")
    private String app_id;

    @Value("${wxPay.pay.key}")
    private String wx_pay_key;

    @Value("${wxPay.pay.mch_id}")
    private String wx_pay_mch_id;
    @Value("${wxPay.pay.certPath}")
    private String certPath;
    

//    public MyWxPayConfig() throws Exception { // 构造方法读取证书, 通过getCertStream 可以使sdk获取到证书
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
//    }
    

    @Override
    public String getAppID() {
        return app_id;
    }

    @Override
    public String getMchID() {
        return wx_pay_mch_id;
    }

    @Override
    public String getKey() {
        return wx_pay_key;
    }

    @Override
    public InputStream getCertStream() {
    	InputStream certStream = null;
	try {
		File file = new File(certPath);
		certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
	} catch (FileNotFoundException e) {
		throw new BusinessException("未找到秘钥文件！");
	} catch (IOException e) {
		throw new BusinessException("IO异常！");
	}finally{
		try {
			if(null!=certStream){
				certStream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public IWXPayDomain getWXPayDomain() { // 这个方法需要这样实现, 否则无法正常初始化WXPay
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }
            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }

}
