package com.huidong.qzh.market.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "industry_product_categrory_ad_pc")
public class IndustryProductCategroryAdPc {
    /**
     * 产业商圈首页 产品分类的广告位图片
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 表industry_product_category_pc表的主键
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 图片的地址
     */
    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * 货品的ID  用于进入详情页
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 图片的类型   1 大图  2小图
     */
    @Column(name = "picture_types")
    private Integer pictureTypes;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 销量
     */
    @Column(name = "sale_volume")
    private Integer saleVolume;

    /**
     * 店铺简称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 会员等级  （例如：金牌会员  普通会员）
     */
    @Column(name = "member_level")
    private String memberLevel;

    /**
     * 图片排序  大排大  小排小
     */
    private Integer sort;

    /**
     * 开始时间
     */
    @Column(name = "startTime")
    private Date starttime;

    /**
     * 结束时间
     */
    @Column(name = "endTime")
    private Date endtime;

    /**
     * 获取产业商圈首页 产品分类的广告位图片
     *
     * @return id - 产业商圈首页 产品分类的广告位图片
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈首页 产品分类的广告位图片
     *
     * @param id 产业商圈首页 产品分类的广告位图片
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取表industry_product_category_pc表的主键
     *
     * @return category_id - 表industry_product_category_pc表的主键
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置表industry_product_category_pc表的主键
     *
     * @param categoryId 表industry_product_category_pc表的主键
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取图片的地址
     *
     * @return picture_url - 图片的地址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 设置图片的地址
     *
     * @param pictureUrl 图片的地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取货品的ID  用于进入详情页
     *
     * @return goods_id - 货品的ID  用于进入详情页
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品的ID  用于进入详情页
     *
     * @param goodsId 货品的ID  用于进入详情页
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取图片的类型   1 大图  2小图
     *
     * @return picture_types - 图片的类型   1 大图  2小图
     */
    public Integer getPictureTypes() {
        return pictureTypes;
    }

    /**
     * 设置图片的类型   1 大图  2小图
     *
     * @param pictureTypes 图片的类型   1 大图  2小图
     */
    public void setPictureTypes(Integer pictureTypes) {
        this.pictureTypes = pictureTypes;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品价格
     *
     * @return product_price - 商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品价格
     *
     * @param productPrice 商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取销量
     *
     * @return sale_volume - 销量
     */
    public Integer getSaleVolume() {
        return saleVolume;
    }

    /**
     * 设置销量
     *
     * @param saleVolume 销量
     */
    public void setSaleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
    }

    /**
     * 获取店铺简称
     *
     * @return store_name - 店铺简称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置店铺简称
     *
     * @param storeName 店铺简称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 获取会员等级  （例如：金牌会员  普通会员）
     *
     * @return member_level - 会员等级  （例如：金牌会员  普通会员）
     */
    public String getMemberLevel() {
        return memberLevel;
    }

    /**
     * 设置会员等级  （例如：金牌会员  普通会员）
     *
     * @param memberLevel 会员等级  （例如：金牌会员  普通会员）
     */
    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}