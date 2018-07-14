package com.qiji.domain;

import java.util.Date;

public class MicroVoteActor {
    private Integer id;

    private Integer userid;

    private Integer voteid;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getVoteid() {
        return voteid;
    }

    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}