package com.qiji.domain;

import java.util.Date;

public class MicroMessage {
    private Integer id;

    private Integer recid;

    private String msg;

    private Integer msgType;

    private Integer isRead;

    private Date createTime;

    private Date readTime;

    private Integer recuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Integer getRecuid() {
        return recuid;
    }

    public void setRecuid(Integer recuid) {
        this.recuid = recuid;
    }
}