package com.qiji.domain;

public class ServiceContent {
    private Long contentId;

    private Long contentServerId;

    private Long contentConfigId;

    private String contentValue;

    private Long configId;

    private String configName;

    private Integer configFormtype;

    private Long configSort;

    private Long configCategoryId;

    private Integer configShow;

    private String configIntro;

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getContentServerId() {
        return contentServerId;
    }

    public void setContentServerId(Long contentServerId) {
        this.contentServerId = contentServerId;
    }

    public Long getContentConfigId() {
        return contentConfigId;
    }

    public void setContentConfigId(Long contentConfigId) {
        this.contentConfigId = contentConfigId;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue == null ? null : contentValue.trim();
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public Integer getConfigFormtype() {
        return configFormtype;
    }

    public void setConfigFormtype(Integer configFormtype) {
        this.configFormtype = configFormtype;
    }

    public Long getConfigSort() {
        return configSort;
    }

    public void setConfigSort(Long configSort) {
        this.configSort = configSort;
    }

    public Long getConfigCategoryId() {
        return configCategoryId;
    }

    public void setConfigCategoryId(Long configCategoryId) {
        this.configCategoryId = configCategoryId;
    }

    public Integer getConfigShow() {
        return configShow;
    }

    public void setConfigShow(Integer configShow) {
        this.configShow = configShow;
    }

    public String getConfigIntro() {
        return configIntro;
    }

    public void setConfigIntro(String configIntro) {
        this.configIntro = configIntro == null ? null : configIntro.trim();
    }
}