package com.huidong.qzh.standard.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_goods")
public class ProductGoods {
    /**
     * 货品表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货物名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 一口价
     */
    @Column(name = "fixed_price")
    private BigDecimal fixedPrice;

    /**
     * 销量
     */
    @Column(name = "sales_volume")
    private Integer salesVolume;

    /**
     * 总库存
     */
    private Integer stock;

    /**
     * 商家id    eip_member
     */
    @Column(name = "eip_member_id")
    private Integer eipMemberId;

    /**
     * 是否推荐 （1.推荐）
     */
    @Column(name = "is_recommend")
    private Integer isRecommend;

    /**
     * 单位
     */
    private String unit;

    /**
     * 是否自营  1 是
     */
    @Column(name = "self_support")
    private Integer selfSupport;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 是否发布   1 是 
     */
    @Column(name = "is_publish")
    private Integer isPublish;

    /**
     * 自定义分类的ID
     */
    @Column(name = "custom_category_id")
    private String customCategoryId;

    /**
     * 条形码
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * 商品编码
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 是否热门
     */
    @Column(name = "is_hot")
    private Integer isHot;

    /**
     * 是否新品
     */
    @Column(name = "is_new")
    private Integer isNew;

    /**
     * 收藏数量
     */
    @Column(name = "collect_num")
    private Integer collectNum;

    /**
     * 点击量
     */
    @Column(name = "click_volume")
    private Integer clickVolume;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 获取货品表
     *
     * @return id - 货品表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置货品表
     *
     * @param id 货品表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取货物名称
     *
     * @return goods_name - 货物名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置货物名称
     *
     * @param goodsName 货物名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取一口价
     *
     * @return fixed_price - 一口价
     */
    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    /**
     * 设置一口价
     *
     * @param fixedPrice 一口价
     */
    public void setFixedPrice(BigDecimal fixedPrice) {
        this.fixedPrice = fixedPrice;
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
     * 获取总库存
     *
     * @return stock - 总库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置总库存
     *
     * @param stock 总库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取商家id    eip_member
     *
     * @return eip_member_id - 商家id    eip_member
     */
    public Integer getEipMemberId() {
        return eipMemberId;
    }

    /**
     * 设置商家id    eip_member
     *
     * @param eipMemberId 商家id    eip_member
     */
    public void setEipMemberId(Integer eipMemberId) {
        this.eipMemberId = eipMemberId;
    }

    /**
     * 获取是否推荐 （1.推荐）
     *
     * @return is_recommend - 是否推荐 （1.推荐）
     */
    public Integer getIsRecommend() {
        return isRecommend;
    }

    /**
     * 设置是否推荐 （1.推荐）
     *
     * @param isRecommend 是否推荐 （1.推荐）
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取是否自营  1 是
     *
     * @return self_support - 是否自营  1 是
     */
    public Integer getSelfSupport() {
        return selfSupport;
    }

    /**
     * 设置是否自营  1 是
     *
     * @param selfSupport 是否自营  1 是
     */
    public void setSelfSupport(Integer selfSupport) {
        this.selfSupport = selfSupport;
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取是否发布   1 是 
     *
     * @return is_publish - 是否发布   1 是 
     */
    public Integer getIsPublish() {
        return isPublish;
    }

    /**
     * 设置是否发布   1 是 
     *
     * @param isPublish 是否发布   1 是 
     */
    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    /**
     * 获取自定义分类的ID
     *
     * @return custom_category_id - 自定义分类的ID
     */
    public String getCustomCategoryId() {
        return customCategoryId;
    }

    /**
     * 设置自定义分类的ID
     *
     * @param customCategoryId 自定义分类的ID
     */
    public void setCustomCategoryId(String customCategoryId) {
        this.customCategoryId = customCategoryId;
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
     * 获取是否热门
     *
     * @return is_hot - 是否热门
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * 设置是否热门
     *
     * @param isHot 是否热门
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取是否新品
     *
     * @return is_new - 是否新品
     */
    public Integer getIsNew() {
        return isNew;
    }

    /**
     * 设置是否新品
     *
     * @param isNew 是否新品
     */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    /**
     * 获取收藏数量
     *
     * @return collect_num - 收藏数量
     */
    public Integer getCollectNum() {
        return collectNum;
    }

    /**
     * 设置收藏数量
     *
     * @param collectNum 收藏数量
     */
    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
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
    @Transient
    private ProductGoodsPicture pic;

    public ProductGoodsPicture getPic() {
        return pic;
    }

    public void setPic(ProductGoodsPicture pic) {
        this.pic = pic;
    }

    public Integer getClickVolume() {
        return clickVolume;
    }

    public void setClickVolume(Integer clickVolume) {
        this.clickVolume = clickVolume;
    }
}