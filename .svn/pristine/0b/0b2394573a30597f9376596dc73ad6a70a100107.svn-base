package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_attribute_option")
public class ProductAttributeOption {
    /**
     * 属性规格表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父属性id
     */
    @Column(name = "attribute_id")
    private Integer attributeId;

    /**
     * 子属性名称
     */
    @Column(name = "option_name")
    private String optionName;

    /**
     * 获取属性规格表
     *
     * @return id - 属性规格表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置属性规格表
     *
     * @param id 属性规格表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父属性id
     *
     * @return attribute_id - 父属性id
     */
    public Integer getAttributeId() {
        return attributeId;
    }

    /**
     * 设置父属性id
     *
     * @param attributeId 父属性id
     */
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * 获取子属性名称
     *
     * @return option_name - 子属性名称
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 设置子属性名称
     *
     * @param optionName 子属性名称
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}