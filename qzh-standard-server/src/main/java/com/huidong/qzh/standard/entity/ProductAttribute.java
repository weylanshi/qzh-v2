package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_attribute")
public class ProductAttribute {
    /**
     * 属性表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父属性名称
     */
    @Column(name = "attribute_name")
    private String attributeName;

    /**
     * 获取属性表
     *
     * @return id - 属性表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置属性表
     *
     * @param id 属性表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父属性名称
     *
     * @return attribute_name - 父属性名称
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * 设置父属性名称
     *
     * @param attributeName 父属性名称
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}