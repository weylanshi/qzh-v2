package com.huidong.qzh.portal.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "eip_home_ad")
public class EipHomeAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "ad_title")
    private String adTitle;

    /**
     * 广告文字
     */
    @Column(name = "ad_text")
    private String adText;

    /**
     * 广告图片 [{pic:"",class_id:""},{}]
     */
    @Column(name = "ad_pic")
    private String adPic;

    /**
     * 广告位分类
     */
    @Column(name = "ad_type")
    private String adType;

    /**
     * 广告位分类名称
     */
    @Column(name = "ad_type_text")
    private String adTypeText;

    /**
     * 广告开始时间
     */
    @Column(name = "ad_start_time")
    private Date adStartTime;

    /**
     * 广告结束时间
     */
    @Column(name = "ad_end_time")
    private Date adEndTime;

    /**
     * 广告状态 1可用，0不可用
     */
    private Integer status;

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
     * 获取标题
     *
     * @return ad_title - 标题
     */
    public String getAdTitle() {
        return adTitle;
    }

    /**
     * 设置标题
     *
     * @param adTitle 标题
     */
    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    /**
     * 获取广告文字
     *
     * @return ad_text - 广告文字
     */
    public String getAdText() {
        return adText;
    }

    /**
     * 设置广告文字
     *
     * @param adText 广告文字
     */
    public void setAdText(String adText) {
        this.adText = adText;
    }

    /**
     * 获取广告图片 [{pic:"",class_id:""},{}]
     *
     * @return ad_pic - 广告图片 [{pic:"",class_id:""},{}]
     */
    public String getAdPic() {
        return adPic;
    }

    /**
     * 设置广告图片 [{pic:"",class_id:""},{}]
     *
     * @param adPic 广告图片 [{pic:"",class_id:""},{}]
     */
    public void setAdPic(String adPic) {
        this.adPic = adPic;
    }

    /**
     * 获取广告位分类
     *
     * @return ad_type - 广告位分类
     */
    public String getAdType() {
        return adType;
    }

    /**
     * 设置广告位分类
     *
     * @param adType 广告位分类
     */
    public void setAdType(String adType) {
        this.adType = adType;
    }

    /**
     * 获取广告位分类名称
     *
     * @return ad_type_text - 广告位分类名称
     */
    public String getAdTypeText() {
        return adTypeText;
    }

    /**
     * 设置广告位分类名称
     *
     * @param adTypeText 广告位分类名称
     */
    public void setAdTypeText(String adTypeText) {
        this.adTypeText = adTypeText;
    }

    /**
     * 获取广告开始时间
     *
     * @return ad_start_time - 广告开始时间
     */
    public Date getAdStartTime() {
        return adStartTime;
    }

    /**
     * 设置广告开始时间
     *
     * @param adStartTime 广告开始时间
     */
    public void setAdStartTime(Date adStartTime) {
        this.adStartTime = adStartTime;
    }

    /**
     * 获取广告结束时间
     *
     * @return ad_end_time - 广告结束时间
     */
    public Date getAdEndTime() {
        return adEndTime;
    }

    /**
     * 设置广告结束时间
     *
     * @param adEndTime 广告结束时间
     */
    public void setAdEndTime(Date adEndTime) {
        this.adEndTime = adEndTime;
    }

    /**
     * 获取广告状态 1可用，0不可用
     *
     * @return status - 广告状态 1可用，0不可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置广告状态 1可用，0不可用
     *
     * @param status 广告状态 1可用，0不可用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}