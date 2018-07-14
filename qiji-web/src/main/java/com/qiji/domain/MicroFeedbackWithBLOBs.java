package com.qiji.domain;

public class MicroFeedbackWithBLOBs extends MicroFeedback {
    private String links;

    private String comment;

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links == null ? null : links.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}