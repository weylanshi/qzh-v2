package com.qzh.store.entity;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "decoration_recommend")
public class DecorationRecommend implements Serializable{
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
     * 是否展示模块标题，1是，0否
     */
    @Column(name = "is_show_title")
    private Integer isShowTitle;

    /**
     * 推荐方式，1代表自动推荐，2代表手工推荐
     */
    @Column(name = "recommend_type")
    private Integer recommendType;

    /**
     * 自动推荐排序，1人气指数，2热卖宝贝在前，3热门收藏在前，4最新发布在前，5价格最低在前，6价格最低在后
     */
    @Column(name = "sort_type")
    private Integer sortType;

    /**
     * 产品分类，0代表全部
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 关键字
     */
    @Column(name = "key_words")
    private String keyWords;

    /**
     * 价格范围,例如20.00,1000.05
     */
    @Column(name = "price_region")
    private String priceRegion;

    /**
     * 显示数量
     */
    @Column(name = "page_size")
    private Integer pageSize;

    /**
     * 展示方式，1.一行展示4个产品2.一行展示3产品3.一行无缝展示3个产品
     */
    @Column(name = "display_type")
    private Integer displayType;

    /**
     * 店铺ID
     */
    @Column(name = "store_id")
    private Integer storeId;

    public DecorationRecommend() {
    }

    public DecorationRecommend(String title,
                               Integer isShowTitle,
                               Integer recommendType,
                               Integer sortType,
                               Integer categoryId,
                               String keyWords,
                               String priceRegion,
                               Integer pageSize,
                               Integer displayType,
                               Integer storeId) {
        this.title = title;
        this.isShowTitle = isShowTitle;
        this.recommendType = recommendType;
        this.sortType = sortType;
        this.categoryId = categoryId;
        this.keyWords = keyWords;
        this.priceRegion = priceRegion;
        this.pageSize = pageSize;
        this.displayType = displayType;
        this.storeId = storeId;
    }

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
     * 获取是否展示模块标题，1是，0否
     *
     * @return is_show_title - 是否展示模块标题，1是，0否
     */
    public Integer getIsShowTitle() {
        return isShowTitle;
    }

    /**
     * 设置是否展示模块标题，1是，0否
     *
     * @param isShowTitle 是否展示模块标题，1是，0否
     */
    public void setIsShowTitle(Integer isShowTitle) {
        this.isShowTitle = isShowTitle;
    }

    /**
     * 获取推荐方式，1代表自动推荐，2代表手工推荐
     *
     * @return recommend_type - 推荐方式，1代表自动推荐，2代表手工推荐
     */
    public Integer getRecommendType() {
        return recommendType;
    }

    /**
     * 设置推荐方式，1代表自动推荐，2代表手工推荐
     *
     * @param recommendType 推荐方式，1代表自动推荐，2代表手工推荐
     */
    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType;
    }

    /**
     * 获取自动推荐排序，1人气指数，2热卖宝贝在前，3热门收藏在前，4最新发布在前，5价格最低在前，6价格最低在后
     *
     * @return sort_type - 自动推荐排序，1人气指数，2热卖宝贝在前，3热门收藏在前，4最新发布在前，5价格最低在前，6价格最低在后
     */
    public Integer getSortType() {
        return sortType;
    }

    /**
     * 设置自动推荐排序，1人气指数，2热卖宝贝在前，3热门收藏在前，4最新发布在前，5价格最低在前，6价格最低在后
     *
     * @param sortType 自动推荐排序，1人气指数，2热卖宝贝在前，3热门收藏在前，4最新发布在前，5价格最低在前，6价格最低在后
     */
    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    /**
     * 获取产品分类，0代表全部
     *
     * @return category_id - 产品分类，0代表全部
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置产品分类，0代表全部
     *
     * @param categoryId 产品分类，0代表全部
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取关键字
     *
     * @return key_words - 关键字
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * 设置关键字
     *
     * @param keyWords 关键字
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * 获取价格范围,例如20.00,1000.05
     *
     * @return price_region - 价格范围,例如20.00,1000.05
     */
    public String getPriceRegion() {
        return priceRegion;
    }

    /**
     * 设置价格范围,例如20.00,1000.05
     *
     * @param priceRegion 价格范围,例如20.00,1000.05
     */
    public void setPriceRegion(String priceRegion) {
        this.priceRegion = priceRegion;
    }

    /**
     * 获取显示数量
     *
     * @return page_size - 显示数量
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置显示数量
     *
     * @param pageSize 显示数量
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取展示方式，1.一行展示4个产品2.一行展示3产品3.一行无缝展示3个产品
     *
     * @return display_type - 展示方式，1.一行展示4个产品2.一行展示3产品3.一行无缝展示3个产品
     */
    public Integer getDisplayType() {
        return displayType;
    }

    /**
     * 设置展示方式，1.一行展示4个产品2.一行展示3产品3.一行无缝展示3个产品
     *
     * @param displayType 展示方式，1.一行展示4个产品2.一行展示3产品3.一行无缝展示3个产品
     */
    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
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