package com.qiji.domain;

public class ServiceList {
    private Long serviceId;
    
    private String serviceUrl;
    
    private String serviceType;

    private String servicePropName;

    private String propType;

    private String propSort;

    private String servicePropValue;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    
    

    public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getServicePropName() {
        return servicePropName;
    }

    public void setServicePropName(String servicePropName) {
        this.servicePropName = servicePropName == null ? null : servicePropName.trim();
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType == null ? null : propType.trim();
    }

    public String getPropSort() {
        return propSort;
    }

    public void setPropSort(String propSort) {
        this.propSort = propSort == null ? null : propSort.trim();
    }

    public String getServicePropValue() {
        return servicePropValue;
    }

    public void setServicePropValue(String servicePropValue) {
        this.servicePropValue = servicePropValue == null ? null : servicePropValue.trim();
    }
}