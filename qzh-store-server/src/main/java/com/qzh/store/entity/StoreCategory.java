package com.qzh.store.entity;

import javax.persistence.*;

@Table(name = "store_category")
public class StoreCategory {
    /**
     * 店铺分类（主键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 店铺id
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 分类图片链接地址
     */
    @Column(name = "category_pic")
    private String categoryPic;

    private Integer sort;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 获取店铺分类（主键）
     *
     * @return id - 店铺分类（主键）
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置店铺分类（主键）
     *
     * @param id 店铺分类（主键）
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取父id
     *
     * @return parent_id - 父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取分类图片链接地址
     *
     * @return category_pic - 分类图片链接地址
     */
    public String getCategoryPic() {
        return categoryPic;
    }

    /**
     * 设置分类图片链接地址
     *
     * @param categoryPic 分类图片链接地址
     */
    public void setCategoryPic(String categoryPic) {
        this.categoryPic = categoryPic;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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