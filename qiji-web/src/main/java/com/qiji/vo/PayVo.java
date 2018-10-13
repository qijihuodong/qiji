package com.qiji.vo;

public class PayVo {
	private Long serviceId;
	private Long serviceStandardId;
	private Long requiredId;
	
	private String categoryType;
	private String title;
	private String desc;
	private String priceAll;//全款
	private String priceFront;//定金
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Long getServiceStandardId() {
		return serviceStandardId;
	}
	public void setServiceStandardId(Long serviceStandardId) {
		this.serviceStandardId = serviceStandardId;
	}
	public Long getRequiredId() {
		return requiredId;
	}
	public void setRequiredId(Long requiredId) {
		this.requiredId = requiredId;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPriceAll() {
		return priceAll;
	}
	public void setPriceAll(String priceAll) {
		this.priceAll = priceAll;
	}
	public String getPriceFront() {
		return priceFront;
	}
	public void setPriceFront(String priceFront) {
		this.priceFront = priceFront;
	}
	
	
}
