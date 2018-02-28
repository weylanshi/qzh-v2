package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_goods_spec_relation")
public class ProductGoodsSpecRelation {
    /**
     * 货品-规格关系表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 规格id
     */
    @Column(name = "spec_id")
    private Integer specId;

    /**
     * 获取货品-规格关系表
     *
     * @return id - 货品-规格关系表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置货品-规格关系表
     *
     * @param id 货品-规格关系表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取货品id
     *
     * @return goods_id - 货品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置货品id
     *
     * @param goodsId 货品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取规格id
     *
     * @return spec_id - 规格id
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * 设置规格id
     *
     * @param specId 规格id
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }
}