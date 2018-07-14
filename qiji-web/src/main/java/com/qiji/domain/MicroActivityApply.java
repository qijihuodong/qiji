package com.qiji.domain;

public class MicroActivityApply {
    private Integer applyId;

    private Integer activityId;

    private Integer orgniseId;

    private String isWin;

    private Integer addTime;

    private String ogname;

    private String title;

    private Integer checkTime;

    private Byte actType;

    private Byte tradeStatus;

    private Integer uid;

    private String feedback;

    private String feedbackAttach;

    private String comment;

    private String commentAttach;

    private Byte star;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getOrgniseId() {
        return orgniseId;
    }

    public void setOrgniseId(Integer orgniseId) {
        this.orgniseId = orgniseId;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin == null ? null : isWin.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getOgname() {
        return ogname;
    }

    public void setOgname(String ogname) {
        this.ogname = ogname == null ? null : ogname.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
    }

    public Byte getActType() {
        return actType;
    }

    public void setActType(Byte actType) {
        this.actType = actType;
    }

    public Byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public String getFeedbackAttach() {
        return feedbackAttach;
    }

    public void setFeedbackAttach(String feedbackAttach) {
        this.feedbackAttach = feedbackAttach == null ? null : feedbackAttach.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCommentAttach() {
        return commentAttach;
    }

    public void setCommentAttach(String commentAttach) {
        this.commentAttach = commentAttach == null ? null : commentAttach.trim();
    }

    public Byte getStar() {
        return star;
    }

    public void setStar(Byte star) {
        this.star = star;
    }
}