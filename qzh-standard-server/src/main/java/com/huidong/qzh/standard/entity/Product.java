package com.huidong.qzh.standard.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Product {
    /**
     * 商品表
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
     * 促销价
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 产品价格(原价)
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 商品编码
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 条形码
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * 库存
     */
    private BigDecimal stock;

    /**
     * 点击量
     */
    @Column(name = "click_volume")
    private Integer clickVolume;

    /**
     * 销量
     */
    @Column(name = "sales_volume")
    private Integer salesVolume;

    /**
     * 图片路径
     */
    @Column(name = "picture_path")
    private String picturePath;

    /**
     * 货品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 获取商品表
     *
     * @return id - 商品表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品表
     *
     * @param id 商品表
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
     * 获取促销价
     *
     * @return promotion_price - 促销价
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置促销价
     *
     * @param promotionPrice 促销价
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取产品价格(原价)
     *
     * @return original_price - 产品价格(原价)
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置产品价格(原价)
     *
     * @param originalPrice 产品价格(原价)
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取商品编码
     *
     * @return product_code - 商品编码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置商品编码
     *
     * @param productCode 商品编码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 获取条形码
     *
     * @return bar_code - 条形码
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * 设置条形码
     *
     * @param barCode 条形码
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public BigDecimal getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    /**
     * 获取点击量
     *
     * @return click_volume - 点击量
     */
    public Integer getClickVolume() {
        return clickVolume;
    }

    /**
     * 设置点击量
     *
     * @param clickVolume 点击量
     */
    public void setClickVolume(Integer clickVolume) {
        this.clickVolume = clickVolume;
    }

    /**
     * 获取销量
     *
     * @return sales_volume - 销量
     */
    public Integer getSalesVolume() {
        return salesVolume;
    }

    /**
     * 设置销量
     *
     * @param salesVolume 销量
     */
    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    /**
     * 获取图片路径
     *
     * @return picture_path - 图片路径
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * 设置图片路径
     *
     * @param picturePath 图片路径
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    /**
     * 获取货品id
     *
     * @return goods_id - 货品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品id
     *
     * @param goodsId 货品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}