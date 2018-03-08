package com.qzh.store.entity;

import javax.persistence.*;

@Table(name = "decoration_signboard")
public class DecorationSignboard {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 招牌背景图地址
     */
    @Column(name = "signboard_picture_url")
    private String signboardPictureUrl;

    /**
     * 1是默认，2是自定义
     */
    @Column(name = "is_default")
    private Integer isDefault;

    /**
     * 装修id
     */
    @Column(name = "decoration_id")
    private Integer decorationId;

    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 招牌内容,富文本框编辑的内容
     */
    @Column(name = "signborad_text")
    private String signboradText;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取招牌背景图地址
     *
     * @return signboard_picture_url - 招牌背景图地址
     */
    public String getSignboardPictureUrl() {
        return signboardPictureUrl;
    }

    /**
     * 设置招牌背景图地址
     *
     * @param signboardPictureUrl 招牌背景图地址
     */
    public void setSignboardPictureUrl(String signboardPictureUrl) {
        this.signboardPictureUrl = signboardPictureUrl;
    }

    /**
     * 获取1是默认，2是自定义
     *
     * @return is_default - 1是默认，2是自定义
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置1是默认，2是自定义
     *
     * @param isDefault 1是默认，2是自定义
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取装修id
     *
     * @return decoration_id - 装修id
     */
    public Integer getDecorationId() {
        return decorationId;
    }

    /**
     * 设置装修id
     *
     * @param decorationId 装修id
     */
    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    /**
     * @return store_id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * @param storeId
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取招牌内容,富文本框编辑的内容
     *
     * @return signborad_text - 招牌内容,富文本框编辑的内容
     */
    public String getSignboradText() {
        return signboradText;
    }

    /**
     * 设置招牌内容,富文本框编辑的内容
     *
     * @param signboradText 招牌内容,富文本框编辑的内容
     */
    public void setSignboradText(String signboradText) {
        this.signboradText = signboradText;
    }
}