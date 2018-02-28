package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_spec_option_relation")
public class ProductSpecOptionRelation {
    /**
     * 商品 - 规格选项关系表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 规格属性ID(子规格id)
     */
    @Column(name = "spec_option_id")
    private Integer specOptionId;

    /**
     * 规格名称（父规格名称）
     */
    @Column(name = "spec_name")
    private String specName;

    /**
     * 规格属性名称（子规格名称）
     */
    @Column(name = "spec_option_name")
    private String specOptionName;

    /**
     * 获取商品 - 规格选项关系表
     *
     * @return id - 商品 - 规格选项关系表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品 - 规格选项关系表
     *
     * @param id 商品 - 规格选项关系表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取规格属性ID(子规格id)
     *
     * @return spec_option_id - 规格属性ID(子规格id)
     */
    public Integer getSpecOptionId() {
        return specOptionId;
    }

    /**
     * 设置规格属性ID(子规格id)
     *
     * @param specOptionId 规格属性ID(子规格id)
     */
    public void setSpecOptionId(Integer specOptionId) {
        this.specOptionId = specOptionId;
    }

    /**
     * 获取规格名称（父规格名称）
     *
     * @return spec_name - 规格名称（父规格名称）
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 设置规格名称（父规格名称）
     *
     * @param specName 规格名称（父规格名称）
     */
    public void setSpecName(String specName) {
        this.specName = specName;
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