package com.qiji.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="returnsms")
public class ReturnSms {
	private String returnstatus;
	private String message;
	private String remainpoint;
	private String taskID;
	private String successCounts;
	
	@XmlElement
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	@XmlElement
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@XmlElement
	public String getRemainpoint() {
		return remainpoint;
	}
	public void setRemainpoint(String remainpoint) {
		this.remainpoint = remainpoint;
	}
	@XmlElement
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	@XmlElement
	public String getSuccessCounts() {
		return successCounts;
	}
	public void setSuccessCounts(String successCounts) {
		this.successCounts = successCounts;
	}
	@Override
	public String toString() {
		return "ReturnSms [returnstatus=" + returnstatus + ", message="
				+ message + ", remainpoint=" + remainpoint + ", taskID="
				+ taskID + ", successCounts=" + successCounts + "]";
	}
	
	
}
