package com.huidong.qzh.standard.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "shop_statistics")
public class ShopStatistics {
    /**
     * 店铺统计表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商家ID
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 全部商品数量
     */
    @Column(name = "goods_num")
    private Integer goodsNum;

    /**
     * 月销量
     */
    @Column(name = "month_sales")
    private Integer monthSales;

    /**
     * 收藏人数
     */
    @Column(name = "collection_num")
    private Integer collectionNum;

    /**
     * 服务评价
     */
    @Column(name = "service_evaluation")
    private BigDecimal serviceEvaluation;

    /**
     * 商品评价
     */
    @Column(name = "goods_evaluation")
    private BigDecimal goodsEvaluation;

    /**
     * 获取店铺统计表
     *
     * @return id - 店铺统计表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置店铺统计表
     *
     * @param id 店铺统计表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return member_id - 商家ID
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置商家ID
     *
     * @param memberId 商家ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取全部商品数量
     *
     * @return goods_num - 全部商品数量
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 设置全部商品数量
     *
     * @param goodsNum 全部商品数量
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 获取月销量
     *
     * @return month_sales - 月销量
     */
    public Integer getMonthSales() {
        return monthSales;
    }

    /**
     * 设置月销量
     *
     * @param monthSales 月销量
     */
    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    /**
     * 获取收藏人数
     *
     * @return collection_num - 收藏人数
     */
    public Integer getCollectionNum() {
        return collectionNum;
    }

    /**
     * 设置收藏人数
     *
     * @param collectionNum 收藏人数
     */
    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    /**
     * 获取服务评价
     *
     * @return service_evaluation - 服务评价
     */
    public BigDecimal getServiceEvaluation() {
        return serviceEvaluation;
    }

    /**
     * 设置服务评价
     *
     * @param serviceEvaluation 服务评价
     */
    public void setServiceEvaluation(BigDecimal serviceEvaluation) {
        this.serviceEvaluation = serviceEvaluation;
    }

    /**
     * 获取商品评价
     *
     * @return goods_evaluation - 商品评价
     */
    public BigDecimal getGoodsEvaluation() {
        return goodsEvaluation;
    }

    /**
     * 设置商品评价
     *
     * @param goodsEvaluation 商品评价
     */
    public void setGoodsEvaluation(BigDecimal goodsEvaluation) {
        this.goodsEvaluation = goodsEvaluation;
    }
}