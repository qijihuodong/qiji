package com.qiji.domain;

public class ActivityListWithBLOBs extends ActivityList {
    private String activityContent;

    private String activityNeeds;

    private String activityActback;

    private String activityMoney;

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public String getActivityNeeds() {
        return activityNeeds;
    }

    public void setActivityNeeds(String activityNeeds) {
        this.activityNeeds = activityNeeds == null ? null : activityNeeds.trim();
    }

    public String getActivityActback() {
        return activityActback;
    }

    public void setActivityActback(String activityActback) {
        this.activityActback = activityActback == null ? null : activityActback.trim();
    }

    public String getActivityMoney() {
        return activityMoney;
    }

    public void setActivityMoney(String activityMoney) {
        this.activityMoney = activityMoney == null ? null : activityMoney.trim();
    }
}