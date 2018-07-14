package com.qiji.domain;

public class MicroUserTagList {
    private Integer userTagId;

    private Integer tagId;

    private Integer userId;

    private String addTime;

    public Integer getUserTagId() {
        return userTagId;
    }

    public void setUserTagId(Integer userTagId) {
        this.userTagId = userTagId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }
}