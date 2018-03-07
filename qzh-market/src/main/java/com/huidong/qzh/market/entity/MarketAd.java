package com.huidong.qzh.market.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "market_ad")
public class MarketAd {
    /**
     * 推荐和促销表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品价格  促销价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 产品链接地址
     */
    @Column(name = "product_picture_url")
    private String productPictureUrl;

    /**
     * 产品出售类型   促销 2   推荐  1
     */
    @Column(name = "product_sell_type")
    private Integer productSellType;

    /**
     * 活动名称
     */
    @Column(name = "product_sell_activity")
    private String productSellActivity;

    /**
     * 原价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 货品ID
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 单位
     */
    @Column(name = "product_unit")
    private String productUnit;

    /**
     * 获取推荐和促销表
     *
     * @return id - 推荐和促销表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置推荐和促销表
     *
     * @param id 推荐和促销表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品价格  促销价
     *
     * @return product_price - 产品价格  促销价
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置产品价格  促销价
     *
     * @param productPrice 产品价格  促销价
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取产品链接地址
     *
     * @return product_picture_url - 产品链接地址
     */
    public String getProductPictureUrl() {
        return productPictureUrl;
    }

    /**
     * 设置产品链接地址
     *
     * @param productPictureUrl 产品链接地址
     */
    public void setProductPictureUrl(String productPictureUrl) {
        this.productPictureUrl = productPictureUrl;
    }

    /**
     * 获取产品出售类型   促销 2   推荐  1
     *
     * @return product_sell_type - 产品出售类型   促销 2   推荐  1
     */
    public Integer getProductSellType() {
        return productSellType;
    }

    /**
     * 设置产品出售类型   促销 2   推荐  1
     *
     * @param productSellType 产品出售类型   促销 2   推荐  1
     */
    public void setProductSellType(Integer productSellType) {
        this.productSellType = productSellType;
    }

    /**
     * 获取活动名称
     *
     * @return product_sell_activity - 活动名称
     */
    public String getProductSellActivity() {
        return productSellActivity;
    }

    /**
     * 设置活动名称
     *
     * @param productSellActivity 活动名称
     */
    public void setProductSellActivity(String productSellActivity) {
        this.productSellActivity = productSellActivity;
    }

    /**
     * 获取原价
     *
     * @return original_price - 原价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价
     *
     * @param originalPrice 原价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取货品ID
     *
     * @return goods_id - 货品ID
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品ID
     *
     * @param goodsId 货品ID
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取单位
     *
     * @return product_unit - 单位
     */
    public String getProductUnit() {
        return productUnit;
    }

    /**
     * 设置单位
     *
     * @param productUnit 单位
     */
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
}