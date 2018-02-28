package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_category")
public class  ProductCategory {
    /**
     * 分类表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 层次（最多只有四层）
     */
    private Integer level;

    /**
     * 分类状态（0：默认 ；1：是已删除）
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 获取分类表
     *
     * @return id - 分类表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置分类表
     *
     * @param id 分类表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父ID
     *
     * @return parent_id - 父ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父ID
     *
     * @param parentId 父ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取层次（最多只有四层）
     *
     * @return level - 层次（最多只有四层）
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置层次（最多只有四层）
     *
     * @param level 层次（最多只有四层）
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取分类状态（0：默认 ；1：是已删除）
     *
     * @return del_flag - 分类状态（0：默认 ；1：是已删除）
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置分类状态（0：默认 ；1：是已删除）
     *
     * @param delFlag 分类状态（0：默认 ；1：是已删除）
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}