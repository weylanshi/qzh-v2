package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_goods_details")
public class ProductGoodsDetails {
    /**
     * 商品详情介绍表
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
     * pc端的产品详情
     */
    @Column(name = "product_details_pc")
    private String productDetailsPc;

    /**
     * 手机端的产品详情
     */
    @Column(name = "product_details_app")
    private String productDetailsApp;

    /**
     * 获取商品详情介绍表
     *
     * @return id - 商品详情介绍表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品详情介绍表
     *
     * @param id 商品详情介绍表
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
     * 获取pc端的产品详情
     *
     * @return product_details_pc - pc端的产品详情
     */
    public String getProductDetailsPc() {
        return productDetailsPc;
    }

    /**
     * 设置pc端的产品详情
     *
     * @param productDetailsPc pc端的产品详情
     */
    public void setProductDetailsPc(String productDetailsPc) {
        this.productDetailsPc = productDetailsPc;
    }

    /**
     * 获取手机端的产品详情
     *
     * @return product_details_app - 手机端的产品详情
     */
    public String getProductDetailsApp() {
        return productDetailsApp;
    }

    /**
     * 设置手机端的产品详情
     *
     * @param productDetailsApp 手机端的产品详情
     */
    public void setProductDetailsApp(String productDetailsApp) {
        this.productDetailsApp = productDetailsApp;
    }
}