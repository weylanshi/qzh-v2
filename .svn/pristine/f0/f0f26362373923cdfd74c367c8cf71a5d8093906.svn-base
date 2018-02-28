package com.qzh.personalCenter.entity;

import javax.persistence.*;

@Table(name = "my_footprint")
public class MyFootprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员ID
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 货品ID 
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取会员ID
     *
     * @return account_id - 会员ID
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置会员ID
     *
     * @param accountId 会员ID
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
}