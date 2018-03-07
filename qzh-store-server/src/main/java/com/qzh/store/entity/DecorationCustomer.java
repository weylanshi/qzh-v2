package com.qzh.store.entity;

import javax.persistence.*;

@Table(name = "decoration_customer")
public class DecorationCustomer {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 是否显示模块标题，1是，0否。
     */
    @Column(name = "is_show_title")
    private Integer isShowTitle;

    /**
     * 工作时间1；例如：周一，周五，9:00,21:00
     */
    @Column(name = "work_time1")
    private String workTime1;

    /**
     * 工作时间2；例如：周六，周日，0:00,24:00
     */
    @Column(name = "work_time2")
    private String workTime2;

    /**
     * 是否展示工作日期1，1是，0否
     */
    @Column(name = "is_show_time1")
    private Integer isShowTime1;

    /**
     * 是否展示工作日期2，1是，0否
     */
    @Column(name = "is_show_time2")
    private Integer isShowTime2;

    /**
     * 客服id，多个客服用逗号分隔
     */
    @Column(name = "customer_id")
    private String customerId;

    /**
     * 是否展示客户
     */
    @Column(name = "is_show_customer")
    private Integer isShowCustomer;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 联系手机
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 店铺ID
     */
    @Column(name = "store_id")
    private Integer storeId;

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
     * 获取模块标题
     *
     * @return title - 模块标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置模块标题
     *
     * @param title 模块标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取是否显示模块标题，1是，0否。
     *
     * @return is_show_title - 是否显示模块标题，1是，0否。
     */
    public Integer getIsShowTitle() {
        return isShowTitle;
    }

    /**
     * 设置是否显示模块标题，1是，0否。
     *
     * @param isShowTitle 是否显示模块标题，1是，0否。
     */
    public void setIsShowTitle(Integer isShowTitle) {
        this.isShowTitle = isShowTitle;
    }

    /**
     * 获取工作时间1；例如：周一，周五，9:00,21:00
     *
     * @return work_time1 - 工作时间1；例如：周一，周五，9:00,21:00
     */
    public String getWorkTime1() {
        return workTime1;
    }

    /**
     * 设置工作时间1；例如：周一，周五，9:00,21:00
     *
     * @param workTime1 工作时间1；例如：周一，周五，9:00,21:00
     */
    public void setWorkTime1(String workTime1) {
        this.workTime1 = workTime1;
    }

    /**
     * 获取工作时间2；例如：周六，周日，0:00,24:00
     *
     * @return work_time2 - 工作时间2；例如：周六，周日，0:00,24:00
     */
    public String getWorkTime2() {
        return workTime2;
    }

    /**
     * 设置工作时间2；例如：周六，周日，0:00,24:00
     *
     * @param workTime2 工作时间2；例如：周六，周日，0:00,24:00
     */
    public void setWorkTime2(String workTime2) {
        this.workTime2 = workTime2;
    }

    /**
     * 获取是否展示工作日期1，1是，0否
     *
     * @return is_show_time1 - 是否展示工作日期1，1是，0否
     */
    public Integer getIsShowTime1() {
        return isShowTime1;
    }

    /**
     * 设置是否展示工作日期1，1是，0否
     *
     * @param isShowTime1 是否展示工作日期1，1是，0否
     */
    public void setIsShowTime1(Integer isShowTime1) {
        this.isShowTime1 = isShowTime1;
    }

    /**
     * 获取是否展示工作日期2，1是，0否
     *
     * @return is_show_time2 - 是否展示工作日期2，1是，0否
     */
    public Integer getIsShowTime2() {
        return isShowTime2;
    }

    /**
     * 设置是否展示工作日期2，1是，0否
     *
     * @param isShowTime2 是否展示工作日期2，1是，0否
     */
    public void setIsShowTime2(Integer isShowTime2) {
        this.isShowTime2 = isShowTime2;
    }

    /**
     * 获取客服id，多个客服用逗号分隔
     *
     * @return customer_id - 客服id，多个客服用逗号分隔
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置客服id，多个客服用逗号分隔
     *
     * @param customerId 客服id，多个客服用逗号分隔
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取是否展示客户
     *
     * @return is_show_customer - 是否展示客户
     */
    public Integer getIsShowCustomer() {
        return isShowCustomer;
    }

    /**
     * 设置是否展示客户
     *
     * @param isShowCustomer 是否展示客户
     */
    public void setIsShowCustomer(Integer isShowCustomer) {
        this.isShowCustomer = isShowCustomer;
    }

    /**
     * 获取联系电话
     *
     * @return tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取联系手机
     *
     * @return phone_number - 联系手机
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置联系手机
     *
     * @param phoneNumber 联系手机
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取店铺ID
     *
     * @return store_id - 店铺ID
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置店铺ID
     *
     * @param storeId 店铺ID
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}