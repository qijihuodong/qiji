package com.qiji.common;

import java.io.Serializable;

/**
 * 通用返回json结构
 * @author zjw
 *
 */
public class ModelJson implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean isOperSucc = true;//操作是否成功（包含异常等）
	private boolean succ = true;//交易是否成功
	private String message;
	private String code;
	private Object obj;
	
	public boolean isOperSucc() {
		return isOperSucc;
	}
	public void setOperSucc(boolean isOperSucc) {
		this.isOperSucc = isOperSucc;
	}
	public boolean isSucc() {
		return succ;
	}
	public void setSucc(boolean succ) {
		this.succ = succ;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
}
