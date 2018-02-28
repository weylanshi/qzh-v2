package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "sys_unit")
public class SysUnit {
    /**
     * 单位表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 名称
     */
    @Column(name = "unitName")
    private String unitname;

    /**
     * 获取单位表
     *
     * @return id - 单位表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置单位表
     *
     * @param id 单位表
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取名称
     *
     * @return unitName - 名称
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     * 设置名称
     *
     * @param unitname 名称
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }
}