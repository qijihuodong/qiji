package com.qiji.domain;

public class ServiceContentStandard {
    private Long contentStandardId;

    private Long contentStandardServerId;

    private Long contentStandardConfigId;

    private String contentStandardName;

    private String contentStandardPrice;

    private Long configId;

    private String configName;

    private Integer configFormtype;

    private Long configSort;

    private Long configCategoryId;

    private Integer configShow;

    private String configIntro;

    public Long getContentStandardId() {
        return contentStandardId;
    }

    public void setContentStandardId(Long contentStandardId) {
        this.contentStandardId = contentStandardId;
    }

    public Long getContentStandardServerId() {
        return contentStandardServerId;
    }

    public void setContentStandardServerId(Long contentStandardServerId) {
        this.contentStandardServerId = contentStandardServerId;
    }

    public Long getContentStandardConfigId() {
        return contentStandardConfigId;
    }

    public void setContentStandardConfigId(Long contentStandardConfigId) {
        this.contentStandardConfigId = contentStandardConfigId;
    }

    public String getContentStandardName() {
        return contentStandardName;
    }

    public void setContentStandardName(String contentStandardName) {
        this.contentStandardName = contentStandardName == null ? null : contentStandardName.trim();
    }

    public String getContentStandardPrice() {
        return contentStandardPrice;
    }

    public void setContentStandardPrice(String contentStandardPrice) {
        this.contentStandardPrice = contentStandardPrice == null ? null : contentStandardPrice.trim();
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