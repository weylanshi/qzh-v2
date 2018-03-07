package com.qzh.store.entity;

import java.util.Date;
import javax.persistence.*;

public class Decoration {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 装修名称
     */
    private String name;

    /**
     * 是否发布（使用）0没有发布装修 ；1 是发布装修
     */
    @Column(name = "is_publish")
    private Integer isPublish;

    /**
     * 装修者的账号id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 店铺id
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 会员id
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 左边装修模块的顺序customer:客服中心;search:本店搜索;category:宝贝分类;ranking:宝贝排行榜。
     */
    @Column(name = "left_part_sort")
    private String leftPartSort;

    /**
     * 右边装修模块的顺序.banner:店铺轮播,recommend:宝贝推荐,recently:最新发布
     */
    @Column(name = "right_part_sort")
    private String rightPartSort;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取装修名称
     *
     * @return name - 装修名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置装修名称
     *
     * @param name 装修名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否发布（使用）0没有发布装修 ；1 是发布装修
     *
     * @return is_publish - 是否发布（使用）0没有发布装修 ；1 是发布装修
     */
    public Integer getIsPublish() {
        return isPublish;
    }

    /**
     * 设置是否发布（使用）0没有发布装修 ；1 是发布装修
     *
     * @param isPublish 是否发布（使用）0没有发布装修 ；1 是发布装修
     */
    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    /**
     * 获取装修者的账号id
     *
     * @return account_id - 装修者的账号id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置装修者的账号id
     *
     * @param accountId 装修者的账号id
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
     * 获取会员id
     *
     * @return member_id - 会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置会员id
     *
     * @param memberId 会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取左边装修模块的顺序customer:客服中心;search:本店搜索;category:宝贝分类;ranking:宝贝排行榜。
     *
     * @return left_part_sort - 左边装修模块的顺序customer:客服中心;search:本店搜索;category:宝贝分类;ranking:宝贝排行榜。
     */
    public String getLeftPartSort() {
        return leftPartSort;
    }

    /**
     * 设置左边装修模块的顺序customer:客服中心;search:本店搜索;category:宝贝分类;ranking:宝贝排行榜。
     *
     * @param leftPartSort 左边装修模块的顺序customer:客服中心;search:本店搜索;category:宝贝分类;ranking:宝贝排行榜。
     */
    public void setLeftPartSort(String leftPartSort) {
        this.leftPartSort = leftPartSort;
    }

    /**
     * 获取右边装修模块的顺序.banner:店铺轮播,recommend:宝贝推荐,recently:最新发布
     *
     * @return right_part_sort - 右边装修模块的顺序.banner:店铺轮播,recommend:宝贝推荐,recently:最新发布
     */
    public String getRightPartSort() {
        return rightPartSort;
    }

    /**
     * 设置右边装修模块的顺序.banner:店铺轮播,recommend:宝贝推荐,recently:最新发布
     *
     * @param rightPartSort 右边装修模块的顺序.banner:店铺轮播,recommend:宝贝推荐,recently:最新发布
     */
    public void setRightPartSort(String rightPartSort) {
        this.rightPartSort = rightPartSort;
    }
}