package com.huidong.qzh.market.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "industry_promotion_pc")
public class IndustryPromotionPc {
    /**
     * 产业商圈首页 促销专区
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片的地址
     */
    @Column(name = "picture_url")
    private String pictureUrl;

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
     * 货品的ID  用于进入商品详情
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 是否显示   1显示   0 不显示
     */
    @Column(name = "is_display")
    private Integer isDisplay;

    /**
     * 排序  小的优先
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
     * 获取产业商圈首页 促销专区
     *
     * @return id - 产业商圈首页 促销专区
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈首页 促销专区
     *
     * @param id 产业商圈首页 促销专区
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取货品的ID  用于进入商品详情
     *
     * @return goods_id - 货品的ID  用于进入商品详情
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品的ID  用于进入商品详情
     *
     * @param goodsId 货品的ID  用于进入商品详情
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取是否显示   1显示   0 不显示
     *
     * @return is_display - 是否显示   1显示   0 不显示
     */
    public Integer getIsDisplay() {
        return isDisplay;
    }

    /**
     * 设置是否显示   1显示   0 不显示
     *
     * @param isDisplay 是否显示   1显示   0 不显示
     */
    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 获取排序  小的优先
     *
     * @return sort - 排序  小的优先
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序  小的优先
     *
     * @param sort 排序  小的优先
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取开始时间
     *
     * @return startTime - 开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置开始时间
     *
     * @param starttime 开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取结束时间
     *
     * @return endTime - 结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置结束时间
     *
     * @param endtime 结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}