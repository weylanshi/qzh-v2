package com.huidong.qzh.sso.entity;

import javax.persistence.*;

@Table(name = "eip_member")
public class EipMember {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 联系人
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 公司logo
     */
    private String logo;

    /**
     * 行业(存行业的code)
     */
    @Column(name = "industry_type")
    private String industryType;

    /**
     * 省市区({键值对的方式存储：六位数字})
     */
    private String pca;

    /**
     * 公司具体地址
     */
    private String address;

    /**
     * 企业类型
     */
    @Column(name = "enterprise_type")
    private String enterpriseType;

    /**
     * 主营产品
     */
    @Column(name = "main_product")
    private String mainProduct;

    /**
     * 主购产品
     */
    @Column(name = "purchasing_product")
    private String purchasingProduct;

    /**
     * 公司类型（商家、厂家、经销商、创客、自营）认证用
     */
    @Column(name = "company_type")
    private Integer companyType;

    /**
     * 会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配  -3 :假数据）默认为-1
     */
    private Integer flag;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系人
     *
     * @return nick_name - 联系人
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置联系人
     *
     * @param nickName 联系人
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取公司logo
     *
     * @return logo - 公司logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置公司logo
     *
     * @param logo 公司logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取行业(存行业的code)
     *
     * @return industry_type - 行业(存行业的code)
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * 设置行业(存行业的code)
     *
     * @param industryType 行业(存行业的code)
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    /**
     * 获取省市区({键值对的方式存储：六位数字})
     *
     * @return pca - 省市区({键值对的方式存储：六位数字})
     */
    public String getPca() {
        return pca;
    }

    /**
     * 设置省市区({键值对的方式存储：六位数字})
     *
     * @param pca 省市区({键值对的方式存储：六位数字})
     */
    public void setPca(String pca) {
        this.pca = pca;
    }

    /**
     * 获取公司具体地址
     *
     * @return address - 公司具体地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置公司具体地址
     *
     * @param address 公司具体地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取企业类型
     *
     * @return enterprise_type - 企业类型
     */
    public String getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * 设置企业类型
     *
     * @param enterpriseType 企业类型
     */
    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    /**
     * 获取主营产品
     *
     * @return main_product - 主营产品
     */
    public String getMainProduct() {
        return mainProduct;
    }

    /**
     * 设置主营产品
     *
     * @param mainProduct 主营产品
     */
    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    /**
     * 获取主购产品
     *
     * @return purchasing_product - 主购产品
     */
    public String getPurchasingProduct() {
        return purchasingProduct;
    }

    /**
     * 设置主购产品
     *
     * @param purchasingProduct 主购产品
     */
    public void setPurchasingProduct(String purchasingProduct) {
        this.purchasingProduct = purchasingProduct;
    }

    /**
     * 获取公司类型（商家、厂家、经销商、创客、自营）认证用
     *
     * @return company_type - 公司类型（商家、厂家、经销商、创客、自营）认证用
     */
    public Integer getCompanyType() {
        return companyType;
    }

    /**
     * 设置公司类型（商家、厂家、经销商、创客、自营）认证用
     *
     * @param companyType 公司类型（商家、厂家、经销商、创客、自营）认证用
     */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    /**
     * 获取会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配  -3 :假数据）默认为-1
     *
     * @return flag - 会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配  -3 :假数据）默认为-1
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配  -3 :假数据）默认为-1
     *
     * @param flag 会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配  -3 :假数据）默认为-1
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}