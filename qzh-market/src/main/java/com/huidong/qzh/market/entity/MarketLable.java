package com.huidong.qzh.market.entity;

import javax.persistence.*;

@Table(name = "market_lable")
public class MarketLable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类标签
     */
    @Column(name = "lable_name")
    private String lableName;

    /**
     * 分类图片链接地址
     */
    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * 分类排序,小的排前面
     */
    private Integer sort;

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
     * 获取分类标签
     *
     * @return lable_name - 分类标签
     */
    public String getLableName() {
        return lableName;
    }

    /**
     * 设置分类标签
     *
     * @param lableName 分类标签
     */
    public void setLableName(String lableName) {
        this.lableName = lableName;
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
     * 获取分类排序,小的排前面
     *
     * @return sort - 分类排序,小的排前面
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置分类排序,小的排前面
     *
     * @param sort 分类排序,小的排前面
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "MarketLable{" +
                "id=" + id +
                ", lableName='" + lableName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", sort=" + sort +
                '}';
    }
}