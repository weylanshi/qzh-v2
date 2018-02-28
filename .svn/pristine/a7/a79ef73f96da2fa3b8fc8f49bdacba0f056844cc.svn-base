package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_category_spec")
public class ProductCategorySpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 规格ID
     */
    @Column(name = "spec_id")
    private Integer specId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取规格ID
     *
     * @return spec_id - 规格ID
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * 设置规格ID
     *
     * @param specId 规格ID
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }
}