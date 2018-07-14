package com.qiji.domain;

import java.util.Date;

public class MicroVoteUser {
    private Integer id;

    private Integer userid;

    private Byte status;

    private Date createtime;

    private Byte voteid;

    private Integer cnt;

    private String declaration;

    private Date checktime;

    private String picture;

    private Integer rank;

    private Integer rankcnt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getVoteid() {
        return voteid;
    }

    public void setVoteid(Byte voteid) {
        this.voteid = voteid;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration == null ? null : declaration.trim();
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRankcnt() {
        return rankcnt;
    }

    public void setRankcnt(Integer rankcnt) {
        this.rankcnt = rankcnt;
    }
}