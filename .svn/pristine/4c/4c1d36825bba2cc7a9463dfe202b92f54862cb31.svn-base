package com.huidong.qzh.standard.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_goods_comment")
public class ProductGoodsComment {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 被回复的那条记录的ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 订单子表ID
     */
    @Column(name = "order_sub_id")
    private Integer orderSubId;

    /**
     * 货品ID
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 评论者的ID
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 图片路径
     */
    @Column(name = "picture_path")
    private String picturePath;

    /**
     * 评论创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 1,2,3,4,5；数字代表星的数目
     */
    @Column(name = "product_star")
    private Integer productStar;

    /**
     * 1,2,3,4,5；数字代表星的数目
     */
    @Column(name = "server_star")
    private Integer serverStar;

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
     * 获取被回复的那条记录的ID
     *
     * @return parent_id - 被回复的那条记录的ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置被回复的那条记录的ID
     *
     * @param parentId 被回复的那条记录的ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取订单子表ID
     *
     * @return order_sub_id - 订单子表ID
     */
    public Integer getOrderSubId() {
        return orderSubId;
    }

    /**
     * 设置订单子表ID
     *
     * @param orderSubId 订单子表ID
     */
    public void setOrderSubId(Integer orderSubId) {
        this.orderSubId = orderSubId;
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
     * 获取评论者的ID
     *
     * @return account_id - 评论者的ID
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置评论者的ID
     *
     * @param accountId 评论者的ID
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取图片路径
     *
     * @return picture_path - 图片路径
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * 设置图片路径
     *
     * @param picturePath 图片路径
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    /**
     * 获取评论创建时间
     *
     * @return create_date - 评论创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置评论创建时间
     *
     * @param createDate 评论创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取1,2,3,4,5；数字代表星的数目
     *
     * @return product_star - 1,2,3,4,5；数字代表星的数目
     */
    public Integer getProductStar() {
        return productStar;
    }

    /**
     * 设置1,2,3,4,5；数字代表星的数目
     *
     * @param productStar 1,2,3,4,5；数字代表星的数目
     */
    public void setProductStar(Integer productStar) {
        this.productStar = productStar;
    }

    /**
     * 获取1,2,3,4,5；数字代表星的数目
     *
     * @return server_star - 1,2,3,4,5；数字代表星的数目
     */
    public Integer getServerStar() {
        return serverStar;
    }

    /**
     * 设置1,2,3,4,5；数字代表星的数目
     *
     * @param serverStar 1,2,3,4,5；数字代表星的数目
     */
    public void setServerStar(Integer serverStar) {
        this.serverStar = serverStar;
    }

    /**
     * 商品ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}