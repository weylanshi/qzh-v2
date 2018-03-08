package com.huidong.qzh.util.common.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductSearchDTO implements Serializable {

    /**
     * 商品id
     */
    private Integer productGoodsId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 原价
     */
    private BigDecimal originalPrice;
    /**
     * 促销价
     */
    private BigDecimal promotionPrice;
    /**
     * 销量
     */
    private Integer salesVolume;
    /**
     * 图片路径
     */
    private String picturePath;
    /**
     * 是否自营  1 是 0 否
     */
    private Integer selfSupport;
    /**
     * 商家id    eip_member
     */
    private Integer eipMemberId;
    /**
     * 商家名称    eip_member
     */
    private String eipMemberName;
    /**
     * 点击量
     */
    private Integer clickVolume;
    /**
     * 是否新品
     */
    private Integer isNew;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 平台分类id
     */
    private Integer categoryId;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 规格
     */
    private String specOptionName;
    /**
     * 单位
     */
    private String unit;
    /**
     * 店铺的产品自定义分类 id
     */
    private String customCategoryId;



    public Integer getProductGoodsId() {
        return productGoodsId;
    }

    public void setProductGoodsId(Integer productGoodsId) {
        this.productGoodsId = productGoodsId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getSelfSupport() {
        return selfSupport;
    }

    public void setSelfSupport(Integer selfSupport) {
        this.selfSupport = selfSupport;
    }

    public Integer getEipMemberId() {
        return eipMemberId;
    }

    public void setEipMemberId(Integer eipMemberId) {
        this.eipMemberId = eipMemberId;
    }

    public String getEipMemberName() {
        return eipMemberName;
    }

    public void setEipMemberName(String eipMemberName) {
        this.eipMemberName = eipMemberName;
    }

    public Integer getClickVolume() {
        return clickVolume;
    }

    public void setClickVolume(Integer clickVolume) {
        this.clickVolume = clickVolume;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecOptionName() {
        return specOptionName;
    }

    public void setSpecOptionName(String specOptionName) {
        this.specOptionName = specOptionName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCustomCategoryId() {
        return customCategoryId;
    }

    public void setCustomCategoryId(String customCategoryId) {
        this.customCategoryId = customCategoryId;
    }

    @Override
    public String toString() {
        return "ProductSearchDTO{" +
                "productGoodsId=" + productGoodsId +
                ", productName='" + productName + '\'' +
                ", originalPrice=" + originalPrice +
                ", promotionPrice=" + promotionPrice +
                ", salesVolume=" + salesVolume +
                ", picturePath='" + picturePath + '\'' +
                ", selfSupport=" + selfSupport +
                ", eipMemberId=" + eipMemberId +
                ", eipMemberName='" + eipMemberName + '\'' +
                ", clickVolume=" + clickVolume +
                ", isNew=" + isNew +
                ", updateTime=" + updateTime +
                ", categoryId=" + categoryId +
                ", brand='" + brand + '\'' +
                ", specOptionName='" + specOptionName + '\'' +
                ", unit='" + unit + '\'' +
                ", customCategoryId='" + customCategoryId + '\'' +
                '}';
    }
}
