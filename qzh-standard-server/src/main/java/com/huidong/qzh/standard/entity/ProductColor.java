package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_color")
public class ProductColor {
    /**
     * 产品颜色表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 颜色名称
     */
    @Column(name = "color_name")
    private String colorName;

    /**
     * 颜色编码
     */
    @Column(name = "color_code")
    private String colorCode;

    /**
     * 颜色的父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 产品属性选项id
     */
    @Column(name = "option_id")
    private Integer optionId;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 获取产品颜色表
     *
     * @return id - 产品颜色表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品颜色表
     *
     * @param id 产品颜色表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取颜色名称
     *
     * @return color_name - 颜色名称
     */
    public String getColorName() {
        return colorName;
    }

    /**
     * 设置颜色名称
     *
     * @param colorName 颜色名称
     */
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    /**
     * 获取颜色编码
     *
     * @return color_code - 颜色编码
     */
    public String getColorCode() {
        return colorCode;
    }

    /**
     * 设置颜色编码
     *
     * @param colorCode 颜色编码
     */
    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    /**
     * 获取颜色的父id
     *
     * @return parent_id - 颜色的父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置颜色的父id
     *
     * @param parentId 颜色的父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取产品属性选项id
     *
     * @return option_id - 产品属性选项id
     */
    public Integer getOptionId() {
        return optionId;
    }

    /**
     * 设置产品属性选项id
     *
     * @param optionId 产品属性选项id
     */
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    /**
     * 获取等级
     *
     * @return level - 等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level 等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}