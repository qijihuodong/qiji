package com.qiji.domain;

import java.util.Date;

public class MicroActivities {
    private Integer actid;

    private Integer ogid;

    private String ogname;

    private String tel;

    private String title;

    private String address;

    private String pictureUrl;

    private Integer star;

    private Integer actType;

    private Integer status;

    private Integer isQiangdan;

    private Integer joinNum;

    private Integer applyNum;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Date endTime;

    private Integer categoryPid;

    private Integer categoryId;

    private String applyname;

    private String email;

    private String job;

    private Date checkTime;

    public Integer getActid() {
        return actid;
    }

    public void setActid(Integer actid) {
        this.actid = actid;
    }

    public Integer getOgid() {
        return ogid;
    }

    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }

    public String getOgname() {
        return ogname;
    }

    public void setOgname(String ogname) {
        this.ogname = ogname == null ? null : ogname.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getActType() {
        return actType;
    }

    public void setActType(Integer actType) {
        this.actType = actType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsQiangdan() {
        return isQiangdan;
    }

    public void setIsQiangdan(Integer isQiangdan) {
        this.isQiangdan = isQiangdan;
    }

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCategoryPid() {
        return categoryPid;
    }

    public void setCategoryPid(Integer categoryPid) {
        this.categoryPid = categoryPid;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname == null ? null : applyname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}