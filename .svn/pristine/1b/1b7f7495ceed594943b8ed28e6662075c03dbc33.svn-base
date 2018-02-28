package com.qzh.personalCenter.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "collect_product")
public class CollectProduct {
    /**
     * 收藏产品表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 货品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 收藏产品的时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 获取收藏产品表
     *
     * @return id - 收藏产品表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置收藏产品表
     *
     * @param id 收藏产品表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return account_id - 用户id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置用户id
     *
     * @param accountId 用户id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
     * 获取收藏产品的时间
     *
     * @return create_date - 收藏产品的时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置收藏产品的时间
     *
     * @param createDate 收藏产品的时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}