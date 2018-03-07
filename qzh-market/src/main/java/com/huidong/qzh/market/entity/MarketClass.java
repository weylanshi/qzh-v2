package com.huidong.qzh.market.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "market_class")
public class MarketClass {
    /**
     * 产业商圈分类表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类图片链接地址
     */
    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * 分类图创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 分类标签
     */
    @Column(name = "lable_id")
    private Integer lableId;

    /**
     * 是否推荐    1：推荐
     */
    @Column(name = "is_recommend")
    private Integer isRecommend;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取产业商圈分类表
     *
     * @return id - 产业商圈分类表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈分类表
     *
     * @param id 产业商圈分类表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品分类id
     *
     * @return category_id - 产品分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置产品分类id
     *
     * @param categoryId 产品分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分类图片链接地址
     *
     * @return picture_url - 分类图片链接地址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 设置分类图片链接地址
     *
     * @param pictureUrl 分类图片链接地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取分类图创建时间
     *
     * @return create_date - 分类图创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置分类图创建时间
     *
     * @param createDate 分类图创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取分类标签
     *
     * @return lable_id - 分类标签
     */
    public Integer getLableId() {
        return lableId;
    }

    /**
     * 设置分类标签
     *
     * @param lableId 分类标签
     */
    public void setLableId(Integer lableId) {
        this.lableId = lableId;
    }

    /**
     * 获取是否推荐    1：推荐
     *
     * @return is_recommend - 是否推荐    1：推荐
     */
    public Integer getIsRecommend() {
        return isRecommend;
    }

    /**
     * 设置是否推荐    1：推荐
     *
     * @param isRecommend 是否推荐    1：推荐
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "MarketClass{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", createDate=" + createDate +
                ", lableId=" + lableId +
                ", isRecommend=" + isRecommend +
                ", sort=" + sort +
                '}';
    }
}