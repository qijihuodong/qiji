package com.qiji.domain;

import java.math.BigDecimal;
import java.util.Date;

public class MicroOrder {
    private Integer id;

    private Integer buyUid;

    private Integer sellUid;

    private Integer standardId;

    private Integer serviceId;

    private BigDecimal price;

    private Integer number;

    private Date addTime;

    private Byte status;

    private String tradeNo;

    private String taobaoTradeNo;

    private Byte tradeStatus;

    private String weixinTradeNo;

    private String requirement;

    private String feedback;

    private String comment;

    private String requirementAttach;

    private String feedbackAttach;

    private String commentAttach;

    private Byte order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyUid() {
        return buyUid;
    }

    public void setBuyUid(Integer buyUid) {
        this.buyUid = buyUid;
    }

    public Integer getSellUid() {
        return sellUid;
    }

    public void setSellUid(Integer sellUid) {
        this.sellUid = sellUid;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getTaobaoTradeNo() {
        return taobaoTradeNo;
    }

    public void setTaobaoTradeNo(String taobaoTradeNo) {
        this.taobaoTradeNo = taobaoTradeNo == null ? null : taobaoTradeNo.trim();
    }

    public Byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getWeixinTradeNo() {
        return weixinTradeNo;
    }

    public void setWeixinTradeNo(String weixinTradeNo) {
        this.weixinTradeNo = weixinTradeNo == null ? null : weixinTradeNo.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getRequirementAttach() {
        return requirementAttach;
    }

    public void setRequirementAttach(String requirementAttach) {
        this.requirementAttach = requirementAttach == null ? null : requirementAttach.trim();
    }

    public String getFeedbackAttach() {
        return feedbackAttach;
    }

    public void setFeedbackAttach(String feedbackAttach) {
        this.feedbackAttach = feedbackAttach == null ? null : feedbackAttach.trim();
    }

    public String getCommentAttach() {
        return commentAttach;
    }

    public void setCommentAttach(String commentAttach) {
        this.commentAttach = commentAttach == null ? null : commentAttach.trim();
    }

    public Byte getOrder() {
        return order;
    }

    public void setOrder(Byte order) {
        this.order = order;
    }
}