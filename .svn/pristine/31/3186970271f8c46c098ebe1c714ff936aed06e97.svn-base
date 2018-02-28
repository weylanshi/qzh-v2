package com.huidong.qzh.market.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "market_slide")
public class MarketSlide {
    /**
     * 产业商圈轮播图表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 轮播图名称
     */
    @Column(name = "slide_name")
    private String slideName;

    /**
     * 创建时间
     */
    @Column(name = "slide_create_date")
    private Date slideCreateDate;

    /**
     * 轮播图链接地址
     */
    @Column(name = "slide_picture_url")
    private String slidePictureUrl;

    /**
     * 轮播图位置状态,一个顶部（1），一个是中间的（2）
     */
    @Column(name = "slide_type")
    private Integer slideType;

    /**
     * 轮播图扩展字段
     */
    @Column(name = "slide_extend")
    private String slideExtend;

    /**
     * 货品ID
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 获取产业商圈轮播图表
     *
     * @return id - 产业商圈轮播图表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈轮播图表
     *
     * @param id 产业商圈轮播图表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取轮播图名称
     *
     * @return slide_name - 轮播图名称
     */
    public String getSlideName() {
        return slideName;
    }

    /**
     * 设置轮播图名称
     *
     * @param slideName 轮播图名称
     */
    public void setSlideName(String slideName) {
        this.slideName = slideName;
    }

    /**
     * 获取创建时间
     *
     * @return slide_create_date - 创建时间
     */
    public Date getSlideCreateDate() {
        return slideCreateDate;
    }

    /**
     * 设置创建时间
     *
     * @param slideCreateDate 创建时间
     */
    public void setSlideCreateDate(Date slideCreateDate) {
        this.slideCreateDate = slideCreateDate;
    }

    /**
     * 获取轮播图链接地址
     *
     * @return slide_picture_url - 轮播图链接地址
     */
    public String getSlidePictureUrl() {
        return slidePictureUrl;
    }

    /**
     * 设置轮播图链接地址
     *
     * @param slidePictureUrl 轮播图链接地址
     */
    public void setSlidePictureUrl(String slidePictureUrl) {
        this.slidePictureUrl = slidePictureUrl;
    }

    /**
     * 获取轮播图位置状态,一个顶部（1），一个是中间的（2）
     *
     * @return slide_type - 轮播图位置状态,一个顶部（1），一个是中间的（2）
     */
    public Integer getSlideType() {
        return slideType;
    }

    /**
     * 设置轮播图位置状态,一个顶部（1），一个是中间的（2）
     *
     * @param slideType 轮播图位置状态,一个顶部（1），一个是中间的（2）
     */
    public void setSlideType(Integer slideType) {
        this.slideType = slideType;
    }

    /**
     * 获取轮播图扩展字段
     *
     * @return slide_extend - 轮播图扩展字段
     */
    public String getSlideExtend() {
        return slideExtend;
    }

    /**
     * 设置轮播图扩展字段
     *
     * @param slideExtend 轮播图扩展字段
     */
    public void setSlideExtend(String slideExtend) {
        this.slideExtend = slideExtend;
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
}