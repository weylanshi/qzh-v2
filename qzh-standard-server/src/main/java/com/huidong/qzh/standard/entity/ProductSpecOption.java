package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_spec_option")
public class ProductSpecOption {
    /**
     * 规格属性表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父规格id
     */
    @Column(name = "spec_id")
    private Integer specId;

    /**
     * 规格属性名称（子规格名称）
     */
    @Column(name = "spec_option_name")
    private String specOptionName;

    /**
     * 获取规格属性表
     *
     * @return id - 规格属性表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置规格属性表
     *
     * @param id 规格属性表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父规格id
     *
     * @return spec_id - 父规格id
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * 设置父规格id
     *
     * @param specId 父规格id
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    /**
     * 获取规格属性名称（子规格名称）
     *
     * @return spec_option_name - 规格属性名称（子规格名称）
     */
    public String getSpecOptionName() {
        return specOptionName;
    }

    /**
     * 设置规格属性名称（子规格名称）
     *
     * @param specOptionName 规格属性名称（子规格名称）
     */
    public void setSpecOptionName(String specOptionName) {
        this.specOptionName = specOptionName;
    }
}