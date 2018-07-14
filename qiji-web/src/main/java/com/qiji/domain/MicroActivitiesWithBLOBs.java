package com.qiji.domain;

public class MicroActivitiesWithBLOBs extends MicroActivities {
    private String content;

    private String needs;

    private String actback;

    private String money;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs == null ? null : needs.trim();
    }

    public String getActback() {
        return actback;
    }

    public void setActback(String actback) {
        this.actback = actback == null ? null : actback.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }
}