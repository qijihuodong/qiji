package com.qiji.domain;

import java.util.Date;

public class MicroVote {
    private Integer id;

    private String orgname;

    private String name;

    private String introduce;

    private String rule;

    private String banner;

    private Date begintime;

    private Date endtime;

    private Date createtime;

    private Byte needaudit;

    private Integer intervalhour;

    private String proposer;

    private String process;

    private String awards;

    private String proxyname;

    private String bgPic;

    private String declarationNotice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getNeedaudit() {
        return needaudit;
    }

    public void setNeedaudit(Byte needaudit) {
        this.needaudit = needaudit;
    }

    public Integer getIntervalhour() {
        return intervalhour;
    }

    public void setIntervalhour(Integer intervalhour) {
        this.intervalhour = intervalhour;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer == null ? null : proposer.trim();
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards == null ? null : awards.trim();
    }

    public String getProxyname() {
        return proxyname;
    }

    public void setProxyname(String proxyname) {
        this.proxyname = proxyname == null ? null : proxyname.trim();
    }

    public String getBgPic() {
        return bgPic;
    }

    public void setBgPic(String bgPic) {
        this.bgPic = bgPic == null ? null : bgPic.trim();
    }

    public String getDeclarationNotice() {
        return declarationNotice;
    }

    public void setDeclarationNotice(String declarationNotice) {
        this.declarationNotice = declarationNotice == null ? null : declarationNotice.trim();
    }
}