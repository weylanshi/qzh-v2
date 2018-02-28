package com.huidong.qzh.util.common.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSearchDTO implements Serializable{

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
     * 是否自营  1 是
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
                ", eipMemberName=" + eipMemberName +
                '}';
    }
}
