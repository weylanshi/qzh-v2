package com.huidong.qzh.portal.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ap_shopnews")
public class ApShopnews {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员ID
     */
    @Column(name = "memberId")
    private Integer memberid;

    /**
     * 账户ID
     */
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String origin;

    /**
     * 新闻创建日期
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 阅读次数
     */
    @Column(name = "readTimes")
    private Integer readtimes;

    /**
     * 删除标记,0代表正常，1代表删除
     */
    @Column(name = "delFlag")
    private Integer delflag;

    /**
     * 新闻类别
     */
    @Column(name = "newsClassification")
    private String newsclassification;

    /**
     * 新闻内容
     */
    @Column(name = "newsTxt")
    private String newstxt;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取会员ID
     *
     * @return memberId - 会员ID
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * 设置会员ID
     *
     * @param memberid 会员ID
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * 获取账户ID
     *
     * @return accountId - 账户ID
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置账户ID
     *
     * @param accountid 账户ID
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取新闻标题
     *
     * @return title - 新闻标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置新闻标题
     *
     * @param title 新闻标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取来源
     *
     * @return origin - 来源
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置来源
     *
     * @param origin 来源
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 获取新闻创建日期
     *
     * @return createDate - 新闻创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置新闻创建日期
     *
     * @param createdate 新闻创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取阅读次数
     *
     * @return readTimes - 阅读次数
     */
    public Integer getReadtimes() {
        return readtimes;
    }

    /**
     * 设置阅读次数
     *
     * @param readtimes 阅读次数
     */
    public void setReadtimes(Integer readtimes) {
        this.readtimes = readtimes;
    }

    /**
     * 获取删除标记,0代表正常，1代表删除
     *
     * @return delFlag - 删除标记,0代表正常，1代表删除
     */
    public Integer getDelflag() {
        return delflag;
    }

    /**
     * 设置删除标记,0代表正常，1代表删除
     *
     * @param delflag 删除标记,0代表正常，1代表删除
     */
    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    /**
     * 获取新闻类别
     *
     * @return newsClassification - 新闻类别
     */
    public String getNewsclassification() {
        return newsclassification;
    }

    /**
     * 设置新闻类别
     *
     * @param newsclassification 新闻类别
     */
    public void setNewsclassification(String newsclassification) {
        this.newsclassification = newsclassification;
    }

    /**
     * 获取新闻内容
     *
     * @return newsTxt - 新闻内容
     */
    public String getNewstxt() {
        return newstxt;
    }

    /**
     * 设置新闻内容
     *
     * @param newstxt 新闻内容
     */
    public void setNewstxt(String newstxt) {
        this.newstxt = newstxt;
    }
}