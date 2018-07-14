package com.qiji.domain;

public class MicroSchoolResource {
    private Integer resourceId;

    private String schoolName;

    private String resourceCategory;

    private String resourceStyle;

    private String resourceSize;

    private String resourceName;

    private String resourceMark;

    private String imgUrl;

    private Integer addTime;

    private String resourcePrice;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory == null ? null : resourceCategory.trim();
    }

    public String getResourceStyle() {
        return resourceStyle;
    }

    public void setResourceStyle(String resourceStyle) {
        this.resourceStyle = resourceStyle == null ? null : resourceStyle.trim();
    }

    public String getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(String resourceSize) {
        this.resourceSize = resourceSize == null ? null : resourceSize.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceMark() {
        return resourceMark;
    }

    public void setResourceMark(String resourceMark) {
        this.resourceMark = resourceMark == null ? null : resourceMark.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getResourcePrice() {
        return resourcePrice;
    }

    public void setResourcePrice(String resourcePrice) {
        this.resourcePrice = resourcePrice == null ? null : resourcePrice.trim();
    }
}