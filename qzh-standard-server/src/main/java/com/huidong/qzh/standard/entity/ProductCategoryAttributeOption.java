package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_category_attribute_option")
public class ProductCategoryAttributeOption {
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
     * 属性选项ID
     */
    @Column(name = "attribute_option_id")
    private Integer attributeOptionId;

    /**
     * 属性选项名称
     */
    @Column(name = "attribute_option_name")
    private String attributeOptionName;

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
     * 获取属性选项ID
     *
     * @return attribute_option_id - 属性选项ID
     */
    public Integer getAttributeOptionId() {
        return attributeOptionId;
    }

    /**
     * 设置属性选项ID
     *
     * @param attributeOptionId 属性选项ID
     */
    public void setAttributeOptionId(Integer attributeOptionId) {
        this.attributeOptionId = attributeOptionId;
    }

    /**
     * 获取属性选项名称
     *
     * @return attribute_option_name - 属性选项名称
     */
    public String getAttributeOptionName() {
        return attributeOptionName;
    }

    /**
     * 设置属性选项名称
     *
     * @param attributeOptionName 属性选项名称
     */
    public void setAttributeOptionName(String attributeOptionName) {
        this.attributeOptionName = attributeOptionName;
    }
}