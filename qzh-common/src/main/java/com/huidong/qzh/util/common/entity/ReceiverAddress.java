package com.huidong.qzh.util.common.entity;

import java.io.Serializable;

public class ReceiverAddress implements Serializable{
    /**
     * 收货地址表
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer accountId;

    /**
     * 联系人
     */
    private String personName;

    /**
     * 手机
     */
    private String phone;

    /**
     * 所在地区（存的是省市区的code）
     */
    private String area;
    /**
     * 地区信息
     */
    private String areaInfo;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 是否设为默认地址（0否；1是）
     */
    private Integer isDefault;

    /**
     * 获取收货地址表
     *
     * @return id - 收货地址表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置收货地址表
     *
     * @param id 收货地址表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return account_Id - 用户id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置用户id
     *
     * @param accountId 用户id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取联系人
     *
     * @return person_name - 联系人
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * 设置联系人
     *
     * @param personName 联系人
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取所在地区（存的是省市区的code）
     *
     * @return area - 所在地区（存的是省市区的code）
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在地区（存的是省市区的code）
     *
     * @param area 所在地区（存的是省市区的code）
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取详细地址
     *
     * @return detailed_address - 详细地址
     */
    public String getDetailedAddress() {
        return detailedAddress;
    }

    /**
     * 设置详细地址
     *
     * @param detailedAddress 详细地址
     */
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    /**
     * 获取是否设为默认地址（0否；1是）
     *
     * @return is_default - 是否设为默认地址（0否；1是）
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否设为默认地址（0否；1是）
     *
     * @param isDefault 是否设为默认地址（0否；1是）
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }
}