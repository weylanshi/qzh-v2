package com.qzh.personalCenter.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "attention_store")
public class AttentionStore {
    /**
     * 关注店铺表
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
     * 店铺id
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 收藏时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 获取关注店铺表
     *
     * @return id - 关注店铺表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置关注店铺表
     *
     * @param id 关注店铺表
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
     * 获取店铺id
     *
     * @return store_id - 店铺id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置店铺id
     *
     * @param storeId 店铺id
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取收藏时间
     *
     * @return create_date - 收藏时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置收藏时间
     *
     * @param createDate 收藏时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}