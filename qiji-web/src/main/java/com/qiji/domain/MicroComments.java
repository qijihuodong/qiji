package com.qiji.domain;

import java.util.Date;

public class MicroComments {
    private Integer id;

    private Integer ogid;

    private Integer actid;

    private String comment;

    private Integer grade;

    private Date createTime;

    private String ogname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOgid() {
        return ogid;
    }

    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }

    public Integer getActid() {
        return actid;
    }

    public void setActid(Integer actid) {
        this.actid = actid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOgname() {
        return ogname;
    }

    public void setOgname(String ogname) {
        this.ogname = ogname == null ? null : ogname.trim();
    }
}