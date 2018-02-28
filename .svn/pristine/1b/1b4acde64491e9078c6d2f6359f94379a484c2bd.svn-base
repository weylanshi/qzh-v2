package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_attribute_option_relation")
public class ProductAttributeOptionRelation {
    /**
     * 商品--属性规格关系表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货品ID
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 属性选项id (子属性id)
     */
    @Column(name = "attribute_option_id")
    private Integer attributeOptionId;

    /**
     * 属性名称 （父属性名称）
     */
    @Column(name = "attribute_name")
    private String attributeName;

    /**
     * 属性选项名称 （子属性名称）
     */
    @Column(name = "attribute_option_name")
    private String attributeOptionName;

    /**
     * 获取商品--属性规格关系表
     *
     * @return id - 商品--属性规格关系表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品--属性规格关系表
     *
     * @param id 商品--属性规格关系表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取货品ID
     *
     * @return goods_id - 货品ID
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品ID
     *
     * @param goodsId 货品ID
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取属性选项id (子属性id)
     *
     * @return attribute_option_id - 属性选项id (子属性id)
     */
    public Integer getAttributeOptionId() {
        return attributeOptionId;
    }

    /**
     * 设置属性选项id (子属性id)
     *
     * @param attributeOptionId 属性选项id (子属性id)
     */
    public void setAttributeOptionId(Integer attributeOptionId) {
        this.attributeOptionId = attributeOptionId;
    }

    /**
     * 获取属性名称 （父属性名称）
     *
     * @return attribute_name - 属性名称 （父属性名称）
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * 设置属性名称 （父属性名称）
     *
     * @param attributeName 属性名称 （父属性名称）
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * 获取属性选项名称 （子属性名称）
     *
     * @return attribute_option_name - 属性选项名称 （子属性名称）
     */
    public String getAttributeOptionName() {
        return attributeOptionName;
    }

    /**
     * 设置属性选项名称 （子属性名称）
     *
     * @param attributeOptionName 属性选项名称 （子属性名称）
     */
    public void setAttributeOptionName(String attributeOptionName) {
        this.attributeOptionName = attributeOptionName;
    }
}