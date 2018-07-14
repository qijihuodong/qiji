package com.qiji.domain;

import java.util.Date;

public class MicroContactus {
    private Integer id;

    private String province;

    private String topcatogory;

    private String subcatogory;

    private String name;

    private String tel;

    private String needs;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getTopcatogory() {
        return topcatogory;
    }

    public void setTopcatogory(String topcatogory) {
        this.topcatogory = topcatogory == null ? null : topcatogory.trim();
    }

    public String getSubcatogory() {
        return subcatogory;
    }

    public void setSubcatogory(String subcatogory) {
        this.subcatogory = subcatogory == null ? null : subcatogory.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs == null ? null : needs.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}