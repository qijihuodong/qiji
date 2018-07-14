package com.qiji.domain;

import java.util.Date;

public class MicroAuthBusiness {
    private Integer id;

    private Integer uid;

    private String name;

    private String service;

    private String img1;

    private String img2;

    private String img3;

    private String address;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    private Date checkTime;

    private String applyName;

    private String applyContact;

    private String applyEmail;

    private String bakApplyName;

    private String bakApplyContact;

    private String bakApplyEmail;

    private String production;

    private String email;

    private String logourl;

    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getApplyContact() {
        return applyContact;
    }

    public void setApplyContact(String applyContact) {
        this.applyContact = applyContact == null ? null : applyContact.trim();
    }

    public String getApplyEmail() {
        return applyEmail;
    }

    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail == null ? null : applyEmail.trim();
    }

    public String getBakApplyName() {
        return bakApplyName;
    }

    public void setBakApplyName(String bakApplyName) {
        this.bakApplyName = bakApplyName == null ? null : bakApplyName.trim();
    }

    public String getBakApplyContact() {
        return bakApplyContact;
    }

    public void setBakApplyContact(String bakApplyContact) {
        this.bakApplyContact = bakApplyContact == null ? null : bakApplyContact.trim();
    }

    public String getBakApplyEmail() {
        return bakApplyEmail;
    }

    public void setBakApplyEmail(String bakApplyEmail) {
        this.bakApplyEmail = bakApplyEmail == null ? null : bakApplyEmail.trim();
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production == null ? null : production.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl == null ? null : logourl.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}