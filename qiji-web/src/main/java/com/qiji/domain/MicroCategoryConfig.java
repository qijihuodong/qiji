package com.qiji.domain;

public class MicroCategoryConfig {
    private Integer id;

    private String name;

    private Byte formtype;

    private Integer sort;

    private Integer categoryId;

    private Byte show;

    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getFormtype() {
        return formtype;
    }

    public void setFormtype(Byte formtype) {
        this.formtype = formtype;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Byte getShow() {
        return show;
    }

    public void setShow(Byte show) {
        this.show = show;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}