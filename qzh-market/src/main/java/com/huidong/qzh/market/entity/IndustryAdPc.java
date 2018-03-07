package com.huidong.qzh.market.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "industry_ad_pc")
public class IndustryAdPc {
    /**
     * 产业商圈首页轮播及右侧广告位
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 广告图片的链接地址
     */
    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * 广告点击的链接
     */
    @Column(name = "link_href")
    private String linkHref;

    /**
     * 是否显示   1显示 0 不显示
     */
    @Column(name = "is_display")
    private Integer isDisplay;

    /**
     * 广告类型  1 轮播广告   2 右侧广告
     */
    @Column(name = "ad_types")
    private Integer adTypes;

    /**
     * 广告位排序   小的在前面 优先排
     */
    @Column(name = "ad_sort")
    private Integer adSort;

    /**
     * 广告位的开始时间
     */
    @Column(name = "startTime")
    private Date starttime;

    /**
     * 广告位的结束时间
     */
    @Column(name = "endTime")
    private Date endtime;

    /**
     * 获取产业商圈首页轮播及右侧广告位
     *
     * @return id - 产业商圈首页轮播及右侧广告位
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈首页轮播及右侧广告位
     *
     * @param id 产业商圈首页轮播及右侧广告位
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取广告图片的链接地址
     *
     * @return picture_url - 广告图片的链接地址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 设置广告图片的链接地址
     *
     * @param pictureUrl 广告图片的链接地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取广告点击的链接
     *
     * @return link_href - 广告点击的链接
     */
    public String getLinkHref() {
        return linkHref;
    }

    /**
     * 设置广告点击的链接
     *
     * @param linkHref 广告点击的链接
     */
    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
    }

    /**
     * 获取是否显示   1显示 0 不显示
     *
     * @return is_display - 是否显示   1显示 0 不显示
     */
    public Integer getIsDisplay() {
        return isDisplay;
    }

    /**
     * 设置是否显示   1显示 0 不显示
     *
     * @param isDisplay 是否显示   1显示 0 不显示
     */
    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 获取广告类型  1 轮播广告   2 右侧广告
     *
     * @return ad_types - 广告类型  1 轮播广告   2 右侧广告
     */
    public Integer getAdTypes() {
        return adTypes;
    }

    /**
     * 设置广告类型  1 轮播广告   2 右侧广告
     *
     * @param adTypes 广告类型  1 轮播广告   2 右侧广告
     */
    public void setAdTypes(Integer adTypes) {
        this.adTypes = adTypes;
    }

    /**
     * 获取广告位排序   小的在前面 优先排
     *
     * @return ad_sort - 广告位排序   小的在前面 优先排
     */
    public Integer getAdSort() {
        return adSort;
    }

    /**
     * 设置广告位排序   小的在前面 优先排
     *
     * @param adSort 广告位排序   小的在前面 优先排
     */
    public void setAdSort(Integer adSort) {
        this.adSort = adSort;
    }

    /**
     * 获取广告位的开始时间
     *
     * @return startTime - 广告位的开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置广告位的开始时间
     *
     * @param starttime 广告位的开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取广告位的结束时间
     *
     * @return endTime - 广告位的结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置广告位的结束时间
     *
     * @param endtime 广告位的结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}