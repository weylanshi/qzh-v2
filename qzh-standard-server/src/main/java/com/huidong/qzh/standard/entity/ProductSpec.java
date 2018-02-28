package com.huidong.qzh.standard.entity;

import javax.persistence.*;

@Table(name = "product_spec")
public class ProductSpec {
    /**
     * 规格表        规格id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父规格名称
     */
    @Column(name = "spec_name")
    private String specName;

    /**
     * 获取规格表        规格id
     *
     * @return id - 规格表        规格id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置规格表        规格id
     *
     * @param id 规格表        规格id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父规格名称
     *
     * @return spec_name - 父规格名称
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 设置父规格名称
     *
     * @param specName 父规格名称
     */
    public void setSpecName(String specName) {
        this.specName = specName;
    }
}