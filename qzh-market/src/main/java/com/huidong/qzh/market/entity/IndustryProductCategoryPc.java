package com.huidong.qzh.market.entity;

import javax.persistence.*;

@Table(name = "industry_product_category_pc")
public class IndustryProductCategoryPc {
    /**
     * 产业商圈首页 广告位上的 分类
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 一级分类的自定义分类的名称
     */
    @Column(name = "first_level")
    private String firstLevel;

    /**
     * 二级分类   id,名称;id,名称
     */
    @Column(name = "second_level")
    private String secondLevel;

    /**
     * 排序  小的优先
     */
    private Integer sort;

    /**
     * 获取产业商圈首页 广告位上的 分类
     *
     * @return id - 产业商圈首页 广告位上的 分类
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产业商圈首页 广告位上的 分类
     *
     * @param id 产业商圈首页 广告位上的 分类
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取一级分类的自定义分类的名称
     *
     * @return first_level - 一级分类的自定义分类的名称
     */
    public String getFirstLevel() {
        return firstLevel;
    }

    /**
     * 设置一级分类的自定义分类的名称
     *
     * @param firstLevel 一级分类的自定义分类的名称
     */
    public void setFirstLevel(String firstLevel) {
        this.firstLevel = firstLevel;
    }

    /**
     * 获取二级分类   id,名称;id,名称
     *
     * @return second_level - 二级分类   id,名称;id,名称
     */
    public String getSecondLevel() {
        return secondLevel;
    }

    /**
     * 设置二级分类   id,名称;id,名称
     *
     * @param secondLevel 二级分类   id,名称;id,名称
     */
    public void setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel;
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
}