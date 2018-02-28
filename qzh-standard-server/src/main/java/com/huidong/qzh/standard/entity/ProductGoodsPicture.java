package com.huidong.qzh.standard.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_goods_picture")
public class ProductGoodsPicture {
    /**
     * 货品图片表
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
     * 默认图片（最多五张）
     */
    @Column(name = "picture_path")
    private String picturePath;

    /**
     * 3D图片（最多8张）
     */
    @Column(name = "picture3D_path")
    private String picture3dPath;

    /**
     * 视频路径
     */
    @Column(name = "video_path")
    private String videoPath;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 获取货品图片表
     *
     * @return id - 货品图片表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置货品图片表
     *
     * @param id 货品图片表
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
     * 获取默认图片（最多五张）
     *
     * @return picture_path - 默认图片（最多五张）
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * 设置默认图片（最多五张）
     *
     * @param picturePath 默认图片（最多五张）
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    /**
     * 获取3D图片（最多8张）
     *
     * @return picture3D_path - 3D图片（最多8张）
     */
    public String getPicture3dPath() {
        return picture3dPath;
    }

    /**
     * 设置3D图片（最多8张）
     *
     * @param picture3dPath 3D图片（最多8张）
     */
    public void setPicture3dPath(String picture3dPath) {
        this.picture3dPath = picture3dPath;
    }

    /**
     * 获取视频路径
     *
     * @return video_path - 视频路径
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * 设置视频路径
     *
     * @param videoPath 视频路径
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
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
}