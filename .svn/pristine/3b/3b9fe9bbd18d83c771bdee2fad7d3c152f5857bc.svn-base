package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_category_attribute")
public class ProductCategoryAttribute {
    /**
     * 商品分类属性表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 属性ID
     */
    @Column(name = "attribute_id")
    private Integer attributeId;

    /**
     * 获取商品分类属性表
     *
     * @return id - 商品分类属性表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品分类属性表
     *
     * @param id 商品分类属性表
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
     * 获取属性ID
     *
     * @return attribute_id - 属性ID
     */
    public Integer getAttributeId() {
        return attributeId;
    }

    /**
     * 设置属性ID
     *
     * @param attributeId 属性ID
     */
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }
}