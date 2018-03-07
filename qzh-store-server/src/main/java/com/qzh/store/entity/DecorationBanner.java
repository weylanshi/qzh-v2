package com.qzh.store.entity;

import javax.persistence.*;

@Table(name = "decoration_banner")
public class DecorationBanner {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 是否显示模块标题，1是，0否
     */
    @Column(name = "is_show_title")
    private Integer isShowTitle;

    /**
     * 图片信息
     */
    private String picture;

    /**
     * 切换效果，1上下滚动，2渐变滚动
     */
    private Integer effect;

    /**
     * 店铺ID
     */
    @Column(name = "store_id")
    private Integer storeId;

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
     * 获取模块标题
     *
     * @return title - 模块标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置模块标题
     *
     * @param title 模块标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取是否显示模块标题，1是，0否
     *
     * @return is_show_title - 是否显示模块标题，1是，0否
     */
    public Integer getIsShowTitle() {
        return isShowTitle;
    }

    /**
     * 设置是否显示模块标题，1是，0否
     *
     * @param isShowTitle 是否显示模块标题，1是，0否
     */
    public void setIsShowTitle(Integer isShowTitle) {
        this.isShowTitle = isShowTitle;
    }

    /**
     * 获取图片信息
     *
     * @return picture - 图片信息
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置图片信息
     *
     * @param picture 图片信息
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取切换效果，1上下滚动，2渐变滚动
     *
     * @return effect - 切换效果，1上下滚动，2渐变滚动
     */
    public Integer getEffect() {
        return effect;
    }

    /**
     * 设置切换效果，1上下滚动，2渐变滚动
     *
     * @param effect 切换效果，1上下滚动，2渐变滚动
     */
    public void setEffect(Integer effect) {
        this.effect = effect;
    }

    /**
     * 获取店铺ID
     *
     * @return store_id - 店铺ID
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置店铺ID
     *
     * @param storeId 店铺ID
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}