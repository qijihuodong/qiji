package com.qiji.domain;

import java.util.Date;

public class MicroMember {
    private Integer id;

    private String name;

    private Byte age;

    private Byte gender;

    private String phone;

    private Date addTime;

    private String award;

    private Byte operator;

    private String openid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award == null ? null : award.trim();
    }

    public Byte getOperator() {
        return operator;
    }

    public void setOperator(Byte operator) {
        this.operator = operator;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}