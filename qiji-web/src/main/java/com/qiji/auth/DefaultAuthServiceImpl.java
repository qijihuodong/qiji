package com.qiji.auth;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public abstract class DefaultAuthServiceImpl implements AuthService {
	
	public static RestTemplate getRestTemplate() {// 手动添加
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(120000);
        List<HttpMessageConverter<?>> messageConverters = new LinkedList<HttpMessageConverter<?>>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<Source>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        RestTemplate restTemplate=new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

	@Override
	public String getAccessToken(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOpenId(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String refreshToken(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthorizationUrl() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getUserInfo(String accessToken, String openId) {
		// TODO Auto-generated method stub
		return null;
	}

}
