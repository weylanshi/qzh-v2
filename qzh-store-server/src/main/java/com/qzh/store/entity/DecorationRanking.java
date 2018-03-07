package com.qzh.store.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "decoration_ranking")
public class DecorationRanking implements Serializable{
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
     * 是否显示模块标题，1是，0否
     */
    @Column(name = "is_show_title")
    private Integer isShowTitle;

    /**
     * 自定义分类id，0代表全部分类
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
     * 默认显示，1代表本月热销排行，2代表收藏排行
     */
    @Column(name = "default_de")
    private Integer defaultDe;

    /**
     * 是否显示最近30天销量数据，1是，0否。
     */
    @Column(name = "is_show_month")
    private Integer isShowMonth;

    /**
     * 店铺ID
     */
    @Column(name = "store_id")
    private Integer storeId;

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
     * 获取是否显示模块标题，1是，0否
     *
     * @return is_show_title - 是否显示模块标题，1是，0否
     */
    public Integer getIsShowTitle() {
        return isShowTitle;
    }

    /**
     * 设置是否显示模块标题，1是，0否
     *
     * @param isShowTitle 是否显示模块标题，1是，0否
     */
    public void setIsShowTitle(Integer isShowTitle) {
        this.isShowTitle = isShowTitle;
    }

    /**
     * 获取自定义分类id，0代表全部分类
     *
     * @return category_id - 自定义分类id，0代表全部分类
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置自定义分类id，0代表全部分类
     *
     * @param categoryId 自定义分类id，0代表全部分类
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
     * 获取默认显示，1代表本月热销排行，2代表收藏排行
     *
     * @return default_de - 默认显示，1代表本月热销排行，2代表收藏排行
     */
    public Integer getDefaultDe() {
        return defaultDe;
    }

    /**
     * 设置默认显示，1代表本月热销排行，2代表收藏排行
     *
     * @param defaultDe 默认显示，1代表本月热销排行，2代表收藏排行
     */
    public void setDefaultDe(Integer defaultDe) {
        this.defaultDe = defaultDe;
    }

    /**
     * 获取是否显示最近30天销量数据，1是，0否。
     *
     * @return is_show_month - 是否显示最近30天销量数据，1是，0否。
     */
    public Integer getIsShowMonth() {
        return isShowMonth;
    }

    /**
     * 设置是否显示最近30天销量数据，1是，0否。
     *
     * @param isShowMonth 是否显示最近30天销量数据，1是，0否。
     */
    public void setIsShowMonth(Integer isShowMonth) {
        this.isShowMonth = isShowMonth;
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

    @Override
    public String toString() {
        return "DecorationRanking{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isShowTitle=" + isShowTitle +
                ", categoryId=" + categoryId +
                ", keyWords='" + keyWords + '\'' +
                ", priceRegion='" + priceRegion + '\'' +
                ", pageSize=" + pageSize +
                ", defaultDe=" + defaultDe +
                ", isShowMonth=" + isShowMonth +
                ", storeId=" + storeId +
                '}';
    }
}