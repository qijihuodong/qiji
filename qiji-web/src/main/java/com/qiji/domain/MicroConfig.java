package com.qiji.domain;

import java.util.Date;

public class MicroConfig {
    private Integer id;

    private String businessNotify;

    private String organiseNotify;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessNotify() {
        return businessNotify;
    }

    public void setBusinessNotify(String businessNotify) {
        this.businessNotify = businessNotify == null ? null : businessNotify.trim();
    }

    public String getOrganiseNotify() {
        return organiseNotify;
    }

    public void setOrganiseNotify(String organiseNotify) {
        this.organiseNotify = organiseNotify == null ? null : organiseNotify.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}