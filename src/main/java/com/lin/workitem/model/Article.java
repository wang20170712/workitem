package com.lin.workitem.model;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String classify;

    private String type;

    private Integer sort;

    private String key;

    private String abstracts;

    private String author;

    private String source;

    private Byte allowreply;

    private Date replyStarttime;

    private Date replyEndtime;

    private Byte deleteStatus;

    private Date createtime;

    private Date updatetime;

    private String articleContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getAbstracts() { return abstracts;}

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts == null ? null : abstracts.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Byte getAllowreply() {
        return allowreply;
    }

    public void setAllowreply(Byte allowreply) {
        this.allowreply = allowreply;
    }

    public Date getReplyStarttime() {
        return replyStarttime;
    }

    public void setReplyStarttime(Date replyStarttime) {
        this.replyStarttime = replyStarttime;
    }

    public Date getReplyEndtime() {
        return replyEndtime;
    }

    public void setReplyEndtime(Date replyEndtime) {
        this.replyEndtime = replyEndtime;
    }

    public Byte getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}