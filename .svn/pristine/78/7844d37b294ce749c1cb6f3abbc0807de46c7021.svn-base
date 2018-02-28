package com.qzh.store.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "store_information")
public class StoreInformation {
    /**
     * 店铺详情表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司id
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 店铺简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 店铺logo链接地址
     */
    @Column(name = "store_logo")
    private String storeLogo;

    /**
     * 店铺所在的省市区（存省市区的code）
     */
    @Column(name = "store_pca")
    private String storePca;

    /**
     * 店铺的详细地址
     */
    @Column(name = "store_address")
    private String storeAddress;

    /**
     * 店铺所属行业（存的是一级行业的code）
     */
    @Column(name = "store_industry")
    private String storeIndustry;

    /**
     * 经营类型(1、经销批发 2、商业服务 3、生产型 4、招商代理 5、政府组织/机构)
     */
    @Column(name = "management_types")
    private Integer managementTypes;

    /**
     * 关注店铺的数量
     */
    @Column(name = "attention_num")
    private Integer attentionNum;

    /**
     * 客服（如果有多个以逗号隔开）
     */
    @Column(name = "customer_service")
    private String customerService;

    /**
     * 店铺等级 
     */
    @Column(name = "member_level")
    private String memberLevel;

    /**
     * 物流好评率
     */
    @Column(name = "rate_logistics")
    private BigDecimal rateLogistics;

    /**
     * 服务好评率
     */
    @Column(name = "rate_service")
    private BigDecimal rateService;

    /**
     * 产品好评率
     */
    @Column(name = "rate_product")
    private BigDecimal rateProduct;

    /**
     * 总好评率
     */
    @Column(name = "rate_all")
    private BigDecimal rateAll;

    /**
     * 店铺简介
     */
    @Column(name = "store_remark")
    private String storeRemark;

    /**
     * 获取店铺详情表
     *
     * @return id - 店铺详情表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置店铺详情表
     *
     * @param id 店铺详情表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公司id
     *
     * @return member_id - 公司id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置公司id
     *
     * @param memberId 公司id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取店铺简称
     *
     * @return short_name - 店铺简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置店铺简称
     *
     * @param shortName 店铺简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取店铺logo链接地址
     *
     * @return store_logo - 店铺logo链接地址
     */
    public String getStoreLogo() {
        return storeLogo;
    }

    /**
     * 设置店铺logo链接地址
     *
     * @param storeLogo 店铺logo链接地址
     */
    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    /**
     * 获取店铺所在的省市区（存省市区的code）
     *
     * @return store_pca - 店铺所在的省市区（存省市区的code）
     */
    public String getStorePca() {
        return storePca;
    }

    /**
     * 设置店铺所在的省市区（存省市区的code）
     *
     * @param storePca 店铺所在的省市区（存省市区的code）
     */
    public void setStorePca(String storePca) {
        this.storePca = storePca;
    }

    /**
     * 获取店铺的详细地址
     *
     * @return store_address - 店铺的详细地址
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * 设置店铺的详细地址
     *
     * @param storeAddress 店铺的详细地址
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    /**
     * 获取店铺所属行业（存的是一级行业的code）
     *
     * @return store_industry - 店铺所属行业（存的是一级行业的code）
     */
    public String getStoreIndustry() {
        return storeIndustry;
    }

    /**
     * 设置店铺所属行业（存的是一级行业的code）
     *
     * @param storeIndustry 店铺所属行业（存的是一级行业的code）
     */
    public void setStoreIndustry(String storeIndustry) {
        this.storeIndustry = storeIndustry;
    }

    /**
     * 获取经营类型(1、经销批发 2、商业服务 3、生产型 4、招商代理 5、政府组织/机构)
     *
     * @return management_types - 经营类型(1、经销批发 2、商业服务 3、生产型 4、招商代理 5、政府组织/机构)
     */
    public Integer getManagementTypes() {
        return managementTypes;
    }

    /**
     * 设置经营类型(1、经销批发 2、商业服务 3、生产型 4、招商代理 5、政府组织/机构)
     *
     * @param managementTypes 经营类型(1、经销批发 2、商业服务 3、生产型 4、招商代理 5、政府组织/机构)
     */
    public void setManagementTypes(Integer managementTypes) {
        this.managementTypes = managementTypes;
    }

    /**
     * 获取关注店铺的数量
     *
     * @return attention_num - 关注店铺的数量
     */
    public Integer getAttentionNum() {
        return attentionNum;
    }

    /**
     * 设置关注店铺的数量
     *
     * @param attentionNum 关注店铺的数量
     */
    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    /**
     * 获取客服（如果有多个以逗号隔开）
     *
     * @return customer_service - 客服（如果有多个以逗号隔开）
     */
    public String getCustomerService() {
        return customerService;
    }

    /**
     * 设置客服（如果有多个以逗号隔开）
     *
     * @param customerService 客服（如果有多个以逗号隔开）
     */
    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    /**
     * 获取店铺等级 
     *
     * @return member_level - 店铺等级 
     */
    public String getMemberLevel() {
        return memberLevel;
    }

    /**
     * 设置店铺等级 
     *
     * @param memberLevel 店铺等级 
     */
    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    /**
     * 获取物流好评率
     *
     * @return rate_logistics - 物流好评率
     */
    public BigDecimal getRateLogistics() {
        return rateLogistics;
    }

    /**
     * 设置物流好评率
     *
     * @param rateLogistics 物流好评率
     */
    public void setRateLogistics(BigDecimal rateLogistics) {
        this.rateLogistics = rateLogistics;
    }

    /**
     * 获取服务好评率
     *
     * @return rate_service - 服务好评率
     */
    public BigDecimal getRateService() {
        return rateService;
    }

    /**
     * 设置服务好评率
     *
     * @param rateService 服务好评率
     */
    public void setRateService(BigDecimal rateService) {
        this.rateService = rateService;
    }

    /**
     * 获取产品好评率
     *
     * @return rate_product - 产品好评率
     */
    public BigDecimal getRateProduct() {
        return rateProduct;
    }

    /**
     * 设置产品好评率
     *
     * @param rateProduct 产品好评率
     */
    public void setRateProduct(BigDecimal rateProduct) {
        this.rateProduct = rateProduct;
    }

    /**
     * 获取总好评率
     *
     * @return rate_all - 总好评率
     */
    public BigDecimal getRateAll() {
        return rateAll;
    }

    /**
     * 设置总好评率
     *
     * @param rateAll 总好评率
     */
    public void setRateAll(BigDecimal rateAll) {
        this.rateAll = rateAll;
    }

    /**
     * 获取店铺简介
     *
     * @return store_remark - 店铺简介
     */
    public String getStoreRemark() {
        return storeRemark;
    }

    /**
     * 设置店铺简介
     *
     * @param storeRemark 店铺简介
     */
    public void setStoreRemark(String storeRemark) {
        this.storeRemark = storeRemark;
    }
}