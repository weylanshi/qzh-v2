package com.huidong.qzh.market.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "industry_hot_recommend_pc")
public class IndustryHotRecommendPc {
    /**
     * 产业商圈首页 热卖专区 及 新品推荐 的广告位
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
     * 货品的ID 用于进入详情页
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 是否显示   1显示   0不显示
     */
    @Column(name = "is_display")
    private Integer isDisplay;

    /**
     * 广告位类型  1 热卖专区  2 新品推荐
     */
    @Column(name = "ad_types")
    private Integer adTypes;

    /**
     * 图片的类型   1 大图   2小图
     */
    @Column(name = "picture_types")
    private Integer pictureTypes;

    /**
     * 图片排序  大排大  小排小
     */
    @Column(name = "picture_sort")
    private Integer pictureSort;

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
     * 获取产业商圈首页 热卖专区 及 新品推荐 的广告位
     *
     * @return id - 产业商圈首页 热卖专区 及 新品推荐 的广告位
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈首页 热卖专区 及 新品推荐 的广告位
     *
     * @param id 产业商圈首页 热卖专区 及 新品推荐 的广告位
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
     * 获取货品的ID 用于进入详情页
     *
     * @return goods_id - 货品的ID 用于进入详情页
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品的ID 用于进入详情页
     *
     * @param goodsId 货品的ID 用于进入详情页
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取是否显示   1显示   0不显示
     *
     * @return is_display - 是否显示   1显示   0不显示
     */
    public Integer getIsDisplay() {
        return isDisplay;
    }

    /**
     * 设置是否显示   1显示   0不显示
     *
     * @param isDisplay 是否显示   1显示   0不显示
     */
    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 获取广告位类型  1 热卖专区  2 新品推荐
     *
     * @return ad_types - 广告位类型  1 热卖专区  2 新品推荐
     */
    public Integer getAdTypes() {
        return adTypes;
    }

    /**
     * 设置广告位类型  1 热卖专区  2 新品推荐
     *
     * @param adTypes 广告位类型  1 热卖专区  2 新品推荐
     */
    public void setAdTypes(Integer adTypes) {
        this.adTypes = adTypes;
    }

    /**
     * 获取图片的类型   1 大图   2小图
     *
     * @return picture_types - 图片的类型   1 大图   2小图
     */
    public Integer getPictureTypes() {
        return pictureTypes;
    }

    /**
     * 设置图片的类型   1 大图   2小图
     *
     * @param pictureTypes 图片的类型   1 大图   2小图
     */
    public void setPictureTypes(Integer pictureTypes) {
        this.pictureTypes = pictureTypes;
    }

    /**
     * 获取图片排序  大排大  小排小
     *
     * @return picture_sort - 图片排序  大排大  小排小
     */
    public Integer getPictureSort() {
        return pictureSort;
    }

    /**
     * 设置图片排序  大排大  小排小
     *
     * @param pictureSort 图片排序  大排大  小排小
     */
    public void setPictureSort(Integer pictureSort) {
        this.pictureSort = pictureSort;
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