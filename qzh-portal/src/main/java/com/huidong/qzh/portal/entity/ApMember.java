package com.huidong.qzh.portal.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ap_member")
public class ApMember {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 门店编号
     */
    private String shopno;

    /**
     * 商户简称
     */
    private String nickname;

    /**
     * 会员级别,默认为1, 2为加盟店，5位终极供应商（圈主的供应商）
     */
    private Integer usertype;

    /**
     * 会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配）默认为-1
     */
    private Integer flag;

    /**
     * 会员级别（1：个人 2：企业）
     */
    private Integer usercategory;

    /**
     * QQ号
     */
    @Column(name = "QQ")
    private String qq;

    /**
     * 企业营业制造复印件
     */
    @Column(name = "p_zz")
    private String pZz;

    /**
     * 组织机构代码证复印件
     */
    @Column(name = "p_jgdm")
    private String pJgdm;

    /**
     * 企业授权书复印件
     */
    @Column(name = "p_sqs")
    private String pSqs;

    /**
     * 身份证复印件
     */
    @Column(name = "p_sfz")
    private String pSfz;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 会员logo
     */
    private String logo;

    /**
     * 门店服务等级
     */
    private String shoprank;

    private Integer syncflag;

    /**
     * 默认门店标志 1默认
     */
    private Integer mflag;

    /**
     * 注册来源 0：方可注册 1：数据中心
     */
    @Column(name = "Source")
    private Integer source;

    /**
     * 企业介绍（企业描述）
     */
    @Column(name = "Remark")
    private String remark;

    @Column(name = "Sys_MemberRole_Main")
    private String sysMemberroleMain;

    @Column(name = "CreateDate")
    private Date createdate;

    @Column(name = "UserDate")
    private Date userdate;

    @Column(name = "OneDate")
    private Date onedate;

    /**
     * 门店地址
     */
    @Column(name = "ShopAddress")
    private String shopaddress;

    @Column(name = "ITheme")
    private String itheme;

    @Column(name = "CRMID")
    private String crmid;

    @Column(name = "Userid")
    private Integer userid;

    private String businesslogo;

    private String shopimgs;

    /**
     * 商圈会员类型目前有【供应商】【经销商】【数码印刷】【图文设计】【办公楼】
     */
    @Column(name = "sqName")
    private String sqname;

    @Column(name = "picUrl")
    private String picurl;

    @Column(name = "display_type")
    private Integer displayType;

    /**
     * 二级域名
     */
    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "shopName")
    private String shopname;

    /**
     * 行业
     */
    private Integer hangye;

    /**
     * 类型细分
     */
    private Integer leixinxifen;

    /**
     * 类型细分二级
     */
    private Integer leixinxifen1;

    /**
     * 同步描述
     */
    @Column(name = "SysNC_DeS")
    private String sysncDes;

    /**
     * 上次接待单时间
     */
    @Column(name = "PrivateTalkDate")
    private String privatetalkdate;

    /**
     * 1，无变化，2，更新同步 3不许同步
     */
    @Column(name = "SysNCStatus")
    private Integer sysncstatus;

    /**
     * 0有用数据，1错号，2空号，3公司无效，4无人接听，5关机，6停机，7直接挂断，8非本行业，9意向采购，10明确采购，11不需要，12重复数据
     */
    @Column(name = "Status")
    private Integer status;

    @Column(name = "iCount")
    private Integer icount;

    @Column(name = "CRM_createdate")
    private String crmCreatedate;

    private Integer hangye2;

    /**
     * 检测时间
     */
    @Column(name = "Detection_time")
    private Date detectionTime;

    /**
     * 0 手机号码有效，1 手机已关机，2 手机已停机，3 手机忙线中，4 手机不在服务区，5 手机号码是空号，6 手机号码错误，7 经过多种方式清洗，无法获知手机状态，8 手机号码被限制呼入，9 其他错误，10 不能接通，11 忙音
     */
    @Column(name = "Check_result")
    private String checkResult;

    /**
     * 是否检测   0 未检测   ，1 已检测
     */
    @Column(name = "Detection_status")
    private Integer detectionStatus;

    /**
     * 关联的上海银行编号（二级商户号）
     */
    @Column(name = "bankRelated")
    private String bankrelated;

    @Column(name = "IsOutsideCircleLook")
    private Integer isoutsidecirclelook;

    @Column(name = "IsOutsideCircleBuy")
    private Integer isoutsidecirclebuy;

    @Column(name = "IsWithinCircleLook")
    private Integer iswithincirclelook;

    @Column(name = "IsWithinCircleBuy")
    private Integer iswithincirclebuy;

    /**
     * 是否OA已经同步 0代表未同步
     */
    @Column(name = "isOA")
    private Integer isoa;

    /**
     * 店铺的颜色样式
     */
    private String shopcss;

    /**
     * 从属业务员ID
     */
    @Column(name = "mangerRoleID")
    private Integer mangerroleid;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 组织架构图片
     */
    @Column(name = "structureImg")
    private String structureimg;

    /**
     * 所属行业分割符为“,”号
     */
    @Column(name = "hangyeStr")
    private String hangyestr;

    /**
     *  1.意向客户，2.二次拨打，3.拒绝，4.空号，5.错号，6.停机
     */
    @Column(name = "gd_callStatus")
    private Integer gdCallstatus;

    /**
     * 指向父公司
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 是否将客服QQ展示到店铺（1，表示展示到店铺，-1表示不展示到店铺）
     */
    @Column(name = "isQQ")
    private Integer isqq;

    /**
     * 是否快速配置
     */
    @Column(name = "isDisposed")
    private Integer isdisposed;

    /**
     * 经营期限自
     */
    @Column(name = "operatingPeriodFrom")
    private Date operatingperiodfrom;

    /**
     * 公司成立日期
     */
    @Column(name = "establishmentDate")
    private Date establishmentdate;

    /**
     * 核准日期
     */
    @Column(name = "approvalDate")
    private Date approvaldate;

    /**
     * 员工人数
     */
    @Column(name = "staffNumber")
    private Integer staffnumber;

    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    @Column(name = "LOGIN_TIMES")
    private Integer loginTimes;

    /**
     * 从表dataBak(梳理的数据)中导入或更新member表时对应的dataBak的ID
     */
    @Column(name = "dataBakID")
    private Integer databakid;

    private String zone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 企业名称
     */
    private String company;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 企业类型
     */
    private String ctype;

    /**
     * 注册号
     */
    private String cregno;

    /**
     * 注册地址
     */
    private String caddress;

    /**
     * 法人
     */
    private String legalperson;

    /**
     * 所在省
     */
    private String province;

    /**
     * 所在市
     */
    private String city;

    /**
     * 所在地区
     */
    private String area;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 联系人姓名
     */
    private String cperson;

    /**
     * 门店介绍
     */
    private String shopbrief;

    /**
     * 主营产品
     */
    @Column(name = "mainProduct")
    private String mainproduct;

    /**
     * 主购产品
     */
    private String purchasing;

    @Column(name = "apDesc")
    private String apdesc;

    @Column(name = "ZYPP")
    private String zypp;

    private String busscope;

    @Column(name = "shopRightImgs")
    private String shoprightimgs;

    /**
     * 店铺门面 图片
     */
    @Column(name = "facadeImg")
    private String facadeimg;

    private String fax;

    /**
     * 店铺客服QQ(可能有多个QQ，用逗号隔开)
     */
    @Column(name = "serviceQQ")
    private String serviceqq;

    /**
     * 企业类型
     */
    @Column(name = "enterpriseType")
    private String enterprisetype;

    /**
     * 统一社会信用代码（营业执照中的）
     */
    @Column(name = "unifiedSocialCreditCode")
    private String unifiedsocialcreditcode;

    /**
     * 注册资本
     */
    @Column(name = "registeredCapital")
    private String registeredcapital;

    /**
     * 经营期限至
     */
    @Column(name = "durationOfOperationTo")
    private String durationofoperationto;

    /**
     * 登记机关
     */
    @Column(name = "registrationAuthority")
    private String registrationauthority;

    /**
     * 登记状态
     */
    @Column(name = "registrationStatus")
    private String registrationstatus;

    /**
     * 经营模式
     */
    @Column(name = "managementModel")
    private String managementmodel;

    /**
     * 年营业额
     */
    @Column(name = "annualSalesVolume")
    private String annualsalesvolume;

    /**
     * 网址
     */
    private String web;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取门店编号
     *
     * @return shopno - 门店编号
     */
    public String getShopno() {
        return shopno;
    }

    /**
     * 设置门店编号
     *
     * @param shopno 门店编号
     */
    public void setShopno(String shopno) {
        this.shopno = shopno;
    }

    /**
     * 获取商户简称
     *
     * @return nickname - 商户简称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置商户简称
     *
     * @param nickname 商户简称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取会员级别,默认为1, 2为加盟店，5位终极供应商（圈主的供应商）
     *
     * @return usertype - 会员级别,默认为1, 2为加盟店，5位终极供应商（圈主的供应商）
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * 设置会员级别,默认为1, 2为加盟店，5位终极供应商（圈主的供应商）
     *
     * @param usertype 会员级别,默认为1, 2为加盟店，5位终极供应商（圈主的供应商）
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * 获取会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配）默认为-1
     *
     * @return flag - 会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配）默认为-1
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配）默认为-1
     *
     * @param flag 会员状态（1：正常 0：冻结 -1：未激活 -2：无法检索分配）默认为-1
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取会员级别（1：个人 2：企业）
     *
     * @return usercategory - 会员级别（1：个人 2：企业）
     */
    public Integer getUsercategory() {
        return usercategory;
    }

    /**
     * 设置会员级别（1：个人 2：企业）
     *
     * @param usercategory 会员级别（1：个人 2：企业）
     */
    public void setUsercategory(Integer usercategory) {
        this.usercategory = usercategory;
    }

    /**
     * 获取QQ号
     *
     * @return QQ - QQ号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ号
     *
     * @param qq QQ号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取企业营业制造复印件
     *
     * @return p_zz - 企业营业制造复印件
     */
    public String getpZz() {
        return pZz;
    }

    /**
     * 设置企业营业制造复印件
     *
     * @param pZz 企业营业制造复印件
     */
    public void setpZz(String pZz) {
        this.pZz = pZz;
    }

    /**
     * 获取组织机构代码证复印件
     *
     * @return p_jgdm - 组织机构代码证复印件
     */
    public String getpJgdm() {
        return pJgdm;
    }

    /**
     * 设置组织机构代码证复印件
     *
     * @param pJgdm 组织机构代码证复印件
     */
    public void setpJgdm(String pJgdm) {
        this.pJgdm = pJgdm;
    }

    /**
     * 获取企业授权书复印件
     *
     * @return p_sqs - 企业授权书复印件
     */
    public String getpSqs() {
        return pSqs;
    }

    /**
     * 设置企业授权书复印件
     *
     * @param pSqs 企业授权书复印件
     */
    public void setpSqs(String pSqs) {
        this.pSqs = pSqs;
    }

    /**
     * 获取身份证复印件
     *
     * @return p_sfz - 身份证复印件
     */
    public String getpSfz() {
        return pSfz;
    }

    /**
     * 设置身份证复印件
     *
     * @param pSfz 身份证复印件
     */
    public void setpSfz(String pSfz) {
        this.pSfz = pSfz;
    }

    /**
     * 获取身份证号
     *
     * @return idcard - 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号
     *
     * @param idcard 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取会员logo
     *
     * @return logo - 会员logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置会员logo
     *
     * @param logo 会员logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取门店服务等级
     *
     * @return shoprank - 门店服务等级
     */
    public String getShoprank() {
        return shoprank;
    }

    /**
     * 设置门店服务等级
     *
     * @param shoprank 门店服务等级
     */
    public void setShoprank(String shoprank) {
        this.shoprank = shoprank;
    }

    /**
     * @return syncflag
     */
    public Integer getSyncflag() {
        return syncflag;
    }

    /**
     * @param syncflag
     */
    public void setSyncflag(Integer syncflag) {
        this.syncflag = syncflag;
    }

    /**
     * 获取默认门店标志 1默认
     *
     * @return mflag - 默认门店标志 1默认
     */
    public Integer getMflag() {
        return mflag;
    }

    /**
     * 设置默认门店标志 1默认
     *
     * @param mflag 默认门店标志 1默认
     */
    public void setMflag(Integer mflag) {
        this.mflag = mflag;
    }

    /**
     * 获取注册来源 0：方可注册 1：数据中心
     *
     * @return Source - 注册来源 0：方可注册 1：数据中心
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置注册来源 0：方可注册 1：数据中心
     *
     * @param source 注册来源 0：方可注册 1：数据中心
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取企业介绍（企业描述）
     *
     * @return Remark - 企业介绍（企业描述）
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置企业介绍（企业描述）
     *
     * @param remark 企业介绍（企业描述）
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return Sys_MemberRole_Main
     */
    public String getSysMemberroleMain() {
        return sysMemberroleMain;
    }

    /**
     * @param sysMemberroleMain
     */
    public void setSysMemberroleMain(String sysMemberroleMain) {
        this.sysMemberroleMain = sysMemberroleMain;
    }

    /**
     * @return CreateDate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return UserDate
     */
    public Date getUserdate() {
        return userdate;
    }

    /**
     * @param userdate
     */
    public void setUserdate(Date userdate) {
        this.userdate = userdate;
    }

    /**
     * @return OneDate
     */
    public Date getOnedate() {
        return onedate;
    }

    /**
     * @param onedate
     */
    public void setOnedate(Date onedate) {
        this.onedate = onedate;
    }

    /**
     * 获取门店地址
     *
     * @return ShopAddress - 门店地址
     */
    public String getShopaddress() {
        return shopaddress;
    }

    /**
     * 设置门店地址
     *
     * @param shopaddress 门店地址
     */
    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    /**
     * @return ITheme
     */
    public String getItheme() {
        return itheme;
    }

    /**
     * @param itheme
     */
    public void setItheme(String itheme) {
        this.itheme = itheme;
    }

    /**
     * @return CRMID
     */
    public String getCrmid() {
        return crmid;
    }

    /**
     * @param crmid
     */
    public void setCrmid(String crmid) {
        this.crmid = crmid;
    }

    /**
     * @return Userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return businesslogo
     */
    public String getBusinesslogo() {
        return businesslogo;
    }

    /**
     * @param businesslogo
     */
    public void setBusinesslogo(String businesslogo) {
        this.businesslogo = businesslogo;
    }

    /**
     * @return shopimgs
     */
    public String getShopimgs() {
        return shopimgs;
    }

    /**
     * @param shopimgs
     */
    public void setShopimgs(String shopimgs) {
        this.shopimgs = shopimgs;
    }

    /**
     * 获取商圈会员类型目前有【供应商】【经销商】【数码印刷】【图文设计】【办公楼】
     *
     * @return sqName - 商圈会员类型目前有【供应商】【经销商】【数码印刷】【图文设计】【办公楼】
     */
    public String getSqname() {
        return sqname;
    }

    /**
     * 设置商圈会员类型目前有【供应商】【经销商】【数码印刷】【图文设计】【办公楼】
     *
     * @param sqname 商圈会员类型目前有【供应商】【经销商】【数码印刷】【图文设计】【办公楼】
     */
    public void setSqname(String sqname) {
        this.sqname = sqname;
    }

    /**
     * @return picUrl
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * @param picurl
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * @return display_type
     */
    public Integer getDisplayType() {
        return displayType;
    }

    /**
     * @param displayType
     */
    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    /**
     * 获取二级域名
     *
     * @return domain_name - 二级域名
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * 设置二级域名
     *
     * @param domainName 二级域名
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * @return shopName
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * @param shopname
     */
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    /**
     * 获取行业
     *
     * @return hangye - 行业
     */
    public Integer getHangye() {
        return hangye;
    }

    /**
     * 设置行业
     *
     * @param hangye 行业
     */
    public void setHangye(Integer hangye) {
        this.hangye = hangye;
    }

    /**
     * 获取类型细分
     *
     * @return leixinxifen - 类型细分
     */
    public Integer getLeixinxifen() {
        return leixinxifen;
    }

    /**
     * 设置类型细分
     *
     * @param leixinxifen 类型细分
     */
    public void setLeixinxifen(Integer leixinxifen) {
        this.leixinxifen = leixinxifen;
    }

    /**
     * 获取类型细分二级
     *
     * @return leixinxifen1 - 类型细分二级
     */
    public Integer getLeixinxifen1() {
        return leixinxifen1;
    }

    /**
     * 设置类型细分二级
     *
     * @param leixinxifen1 类型细分二级
     */
    public void setLeixinxifen1(Integer leixinxifen1) {
        this.leixinxifen1 = leixinxifen1;
    }

    /**
     * 获取同步描述
     *
     * @return SysNC_DeS - 同步描述
     */
    public String getSysncDes() {
        return sysncDes;
    }

    /**
     * 设置同步描述
     *
     * @param sysncDes 同步描述
     */
    public void setSysncDes(String sysncDes) {
        this.sysncDes = sysncDes;
    }

    /**
     * 获取上次接待单时间
     *
     * @return PrivateTalkDate - 上次接待单时间
     */
    public String getPrivatetalkdate() {
        return privatetalkdate;
    }

    /**
     * 设置上次接待单时间
     *
     * @param privatetalkdate 上次接待单时间
     */
    public void setPrivatetalkdate(String privatetalkdate) {
        this.privatetalkdate = privatetalkdate;
    }

    /**
     * 获取1，无变化，2，更新同步 3不许同步
     *
     * @return SysNCStatus - 1，无变化，2，更新同步 3不许同步
     */
    public Integer getSysncstatus() {
        return sysncstatus;
    }

    /**
     * 设置1，无变化，2，更新同步 3不许同步
     *
     * @param sysncstatus 1，无变化，2，更新同步 3不许同步
     */
    public void setSysncstatus(Integer sysncstatus) {
        this.sysncstatus = sysncstatus;
    }

    /**
     * 获取0有用数据，1错号，2空号，3公司无效，4无人接听，5关机，6停机，7直接挂断，8非本行业，9意向采购，10明确采购，11不需要，12重复数据
     *
     * @return Status - 0有用数据，1错号，2空号，3公司无效，4无人接听，5关机，6停机，7直接挂断，8非本行业，9意向采购，10明确采购，11不需要，12重复数据
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0有用数据，1错号，2空号，3公司无效，4无人接听，5关机，6停机，7直接挂断，8非本行业，9意向采购，10明确采购，11不需要，12重复数据
     *
     * @param status 0有用数据，1错号，2空号，3公司无效，4无人接听，5关机，6停机，7直接挂断，8非本行业，9意向采购，10明确采购，11不需要，12重复数据
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return iCount
     */
    public Integer getIcount() {
        return icount;
    }

    /**
     * @param icount
     */
    public void setIcount(Integer icount) {
        this.icount = icount;
    }

    /**
     * @return CRM_createdate
     */
    public String getCrmCreatedate() {
        return crmCreatedate;
    }

    /**
     * @param crmCreatedate
     */
    public void setCrmCreatedate(String crmCreatedate) {
        this.crmCreatedate = crmCreatedate;
    }

    /**
     * @return hangye2
     */
    public Integer getHangye2() {
        return hangye2;
    }

    /**
     * @param hangye2
     */
    public void setHangye2(Integer hangye2) {
        this.hangye2 = hangye2;
    }

    /**
     * 获取检测时间
     *
     * @return Detection_time - 检测时间
     */
    public Date getDetectionTime() {
        return detectionTime;
    }

    /**
     * 设置检测时间
     *
     * @param detectionTime 检测时间
     */
    public void setDetectionTime(Date detectionTime) {
        this.detectionTime = detectionTime;
    }

    /**
     * 获取0 手机号码有效，1 手机已关机，2 手机已停机，3 手机忙线中，4 手机不在服务区，5 手机号码是空号，6 手机号码错误，7 经过多种方式清洗，无法获知手机状态，8 手机号码被限制呼入，9 其他错误，10 不能接通，11 忙音
     *
     * @return Check_result - 0 手机号码有效，1 手机已关机，2 手机已停机，3 手机忙线中，4 手机不在服务区，5 手机号码是空号，6 手机号码错误，7 经过多种方式清洗，无法获知手机状态，8 手机号码被限制呼入，9 其他错误，10 不能接通，11 忙音
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置0 手机号码有效，1 手机已关机，2 手机已停机，3 手机忙线中，4 手机不在服务区，5 手机号码是空号，6 手机号码错误，7 经过多种方式清洗，无法获知手机状态，8 手机号码被限制呼入，9 其他错误，10 不能接通，11 忙音
     *
     * @param checkResult 0 手机号码有效，1 手机已关机，2 手机已停机，3 手机忙线中，4 手机不在服务区，5 手机号码是空号，6 手机号码错误，7 经过多种方式清洗，无法获知手机状态，8 手机号码被限制呼入，9 其他错误，10 不能接通，11 忙音
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    /**
     * 获取是否检测   0 未检测   ，1 已检测
     *
     * @return Detection_status - 是否检测   0 未检测   ，1 已检测
     */
    public Integer getDetectionStatus() {
        return detectionStatus;
    }

    /**
     * 设置是否检测   0 未检测   ，1 已检测
     *
     * @param detectionStatus 是否检测   0 未检测   ，1 已检测
     */
    public void setDetectionStatus(Integer detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    /**
     * 获取关联的上海银行编号（二级商户号）
     *
     * @return bankRelated - 关联的上海银行编号（二级商户号）
     */
    public String getBankrelated() {
        return bankrelated;
    }

    /**
     * 设置关联的上海银行编号（二级商户号）
     *
     * @param bankrelated 关联的上海银行编号（二级商户号）
     */
    public void setBankrelated(String bankrelated) {
        this.bankrelated = bankrelated;
    }

    /**
     * @return IsOutsideCircleLook
     */
    public Integer getIsoutsidecirclelook() {
        return isoutsidecirclelook;
    }

    /**
     * @param isoutsidecirclelook
     */
    public void setIsoutsidecirclelook(Integer isoutsidecirclelook) {
        this.isoutsidecirclelook = isoutsidecirclelook;
    }

    /**
     * @return IsOutsideCircleBuy
     */
    public Integer getIsoutsidecirclebuy() {
        return isoutsidecirclebuy;
    }

    /**
     * @param isoutsidecirclebuy
     */
    public void setIsoutsidecirclebuy(Integer isoutsidecirclebuy) {
        this.isoutsidecirclebuy = isoutsidecirclebuy;
    }

    /**
     * @return IsWithinCircleLook
     */
    public Integer getIswithincirclelook() {
        return iswithincirclelook;
    }

    /**
     * @param iswithincirclelook
     */
    public void setIswithincirclelook(Integer iswithincirclelook) {
        this.iswithincirclelook = iswithincirclelook;
    }

    /**
     * @return IsWithinCircleBuy
     */
    public Integer getIswithincirclebuy() {
        return iswithincirclebuy;
    }

    /**
     * @param iswithincirclebuy
     */
    public void setIswithincirclebuy(Integer iswithincirclebuy) {
        this.iswithincirclebuy = iswithincirclebuy;
    }

    /**
     * 获取是否OA已经同步 0代表未同步
     *
     * @return isOA - 是否OA已经同步 0代表未同步
     */
    public Integer getIsoa() {
        return isoa;
    }

    /**
     * 设置是否OA已经同步 0代表未同步
     *
     * @param isoa 是否OA已经同步 0代表未同步
     */
    public void setIsoa(Integer isoa) {
        this.isoa = isoa;
    }

    /**
     * 获取店铺的颜色样式
     *
     * @return shopcss - 店铺的颜色样式
     */
    public String getShopcss() {
        return shopcss;
    }

    /**
     * 设置店铺的颜色样式
     *
     * @param shopcss 店铺的颜色样式
     */
    public void setShopcss(String shopcss) {
        this.shopcss = shopcss;
    }

    /**
     * 获取从属业务员ID
     *
     * @return mangerRoleID - 从属业务员ID
     */
    public Integer getMangerroleid() {
        return mangerroleid;
    }

    /**
     * 设置从属业务员ID
     *
     * @param mangerroleid 从属业务员ID
     */
    public void setMangerroleid(Integer mangerroleid) {
        this.mangerroleid = mangerroleid;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取组织架构图片
     *
     * @return structureImg - 组织架构图片
     */
    public String getStructureimg() {
        return structureimg;
    }

    /**
     * 设置组织架构图片
     *
     * @param structureimg 组织架构图片
     */
    public void setStructureimg(String structureimg) {
        this.structureimg = structureimg;
    }

    /**
     * 获取所属行业分割符为“,”号
     *
     * @return hangyeStr - 所属行业分割符为“,”号
     */
    public String getHangyestr() {
        return hangyestr;
    }

    /**
     * 设置所属行业分割符为“,”号
     *
     * @param hangyestr 所属行业分割符为“,”号
     */
    public void setHangyestr(String hangyestr) {
        this.hangyestr = hangyestr;
    }

    /**
     * 获取 1.意向客户，2.二次拨打，3.拒绝，4.空号，5.错号，6.停机
     *
     * @return gd_callStatus -  1.意向客户，2.二次拨打，3.拒绝，4.空号，5.错号，6.停机
     */
    public Integer getGdCallstatus() {
        return gdCallstatus;
    }

    /**
     * 设置 1.意向客户，2.二次拨打，3.拒绝，4.空号，5.错号，6.停机
     *
     * @param gdCallstatus  1.意向客户，2.二次拨打，3.拒绝，4.空号，5.错号，6.停机
     */
    public void setGdCallstatus(Integer gdCallstatus) {
        this.gdCallstatus = gdCallstatus;
    }

    /**
     * 获取指向父公司
     *
     * @return parentId - 指向父公司
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置指向父公司
     *
     * @param parentid 指向父公司
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取是否将客服QQ展示到店铺（1，表示展示到店铺，-1表示不展示到店铺）
     *
     * @return isQQ - 是否将客服QQ展示到店铺（1，表示展示到店铺，-1表示不展示到店铺）
     */
    public Integer getIsqq() {
        return isqq;
    }

    /**
     * 设置是否将客服QQ展示到店铺（1，表示展示到店铺，-1表示不展示到店铺）
     *
     * @param isqq 是否将客服QQ展示到店铺（1，表示展示到店铺，-1表示不展示到店铺）
     */
    public void setIsqq(Integer isqq) {
        this.isqq = isqq;
    }

    /**
     * 获取是否快速配置
     *
     * @return isDisposed - 是否快速配置
     */
    public Integer getIsdisposed() {
        return isdisposed;
    }

    /**
     * 设置是否快速配置
     *
     * @param isdisposed 是否快速配置
     */
    public void setIsdisposed(Integer isdisposed) {
        this.isdisposed = isdisposed;
    }

    /**
     * 获取经营期限自
     *
     * @return operatingPeriodFrom - 经营期限自
     */
    public Date getOperatingperiodfrom() {
        return operatingperiodfrom;
    }

    /**
     * 设置经营期限自
     *
     * @param operatingperiodfrom 经营期限自
     */
    public void setOperatingperiodfrom(Date operatingperiodfrom) {
        this.operatingperiodfrom = operatingperiodfrom;
    }

    /**
     * 获取公司成立日期
     *
     * @return establishmentDate - 公司成立日期
     */
    public Date getEstablishmentdate() {
        return establishmentdate;
    }

    /**
     * 设置公司成立日期
     *
     * @param establishmentdate 公司成立日期
     */
    public void setEstablishmentdate(Date establishmentdate) {
        this.establishmentdate = establishmentdate;
    }

    /**
     * 获取核准日期
     *
     * @return approvalDate - 核准日期
     */
    public Date getApprovaldate() {
        return approvaldate;
    }

    /**
     * 设置核准日期
     *
     * @param approvaldate 核准日期
     */
    public void setApprovaldate(Date approvaldate) {
        this.approvaldate = approvaldate;
    }

    /**
     * 获取员工人数
     *
     * @return staffNumber - 员工人数
     */
    public Integer getStaffnumber() {
        return staffnumber;
    }

    /**
     * 设置员工人数
     *
     * @param staffnumber 员工人数
     */
    public void setStaffnumber(Integer staffnumber) {
        this.staffnumber = staffnumber;
    }

    /**
     * @return LAST_LOGIN_TIME
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return LOGIN_TIMES
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }

    /**
     * @param loginTimes
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * 获取从表dataBak(梳理的数据)中导入或更新member表时对应的dataBak的ID
     *
     * @return dataBakID - 从表dataBak(梳理的数据)中导入或更新member表时对应的dataBak的ID
     */
    public Integer getDatabakid() {
        return databakid;
    }

    /**
     * 设置从表dataBak(梳理的数据)中导入或更新member表时对应的dataBak的ID
     *
     * @param databakid 从表dataBak(梳理的数据)中导入或更新member表时对应的dataBak的ID
     */
    public void setDatabakid(Integer databakid) {
        this.databakid = databakid;
    }

    /**
     * @return zone
     */
    public String getZone() {
        return zone;
    }

    /**
     * @param zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取企业名称
     *
     * @return company - 企业名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置企业名称
     *
     * @param company 企业名称
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取企业类型
     *
     * @return ctype - 企业类型
     */
    public String getCtype() {
        return ctype;
    }

    /**
     * 设置企业类型
     *
     * @param ctype 企业类型
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    /**
     * 获取注册号
     *
     * @return cregno - 注册号
     */
    public String getCregno() {
        return cregno;
    }

    /**
     * 设置注册号
     *
     * @param cregno 注册号
     */
    public void setCregno(String cregno) {
        this.cregno = cregno;
    }

    /**
     * 获取注册地址
     *
     * @return caddress - 注册地址
     */
    public String getCaddress() {
        return caddress;
    }

    /**
     * 设置注册地址
     *
     * @param caddress 注册地址
     */
    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    /**
     * 获取法人
     *
     * @return legalperson - 法人
     */
    public String getLegalperson() {
        return legalperson;
    }

    /**
     * 设置法人
     *
     * @param legalperson 法人
     */
    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    /**
     * 获取所在省
     *
     * @return province - 所在省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省
     *
     * @param province 所在省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所在市
     *
     * @return city - 所在市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在市
     *
     * @param city 所在市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所在地区
     *
     * @return area - 所在地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在地区
     *
     * @param area 所在地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取邮编
     *
     * @return zipcode - 邮编
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 设置邮编
     *
     * @param zipcode 邮编
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * 获取联系人姓名
     *
     * @return cperson - 联系人姓名
     */
    public String getCperson() {
        return cperson;
    }

    /**
     * 设置联系人姓名
     *
     * @param cperson 联系人姓名
     */
    public void setCperson(String cperson) {
        this.cperson = cperson;
    }

    /**
     * 获取门店介绍
     *
     * @return shopbrief - 门店介绍
     */
    public String getShopbrief() {
        return shopbrief;
    }

    /**
     * 设置门店介绍
     *
     * @param shopbrief 门店介绍
     */
    public void setShopbrief(String shopbrief) {
        this.shopbrief = shopbrief;
    }

    /**
     * 获取主营产品
     *
     * @return mainProduct - 主营产品
     */
    public String getMainproduct() {
        return mainproduct;
    }

    /**
     * 设置主营产品
     *
     * @param mainproduct 主营产品
     */
    public void setMainproduct(String mainproduct) {
        this.mainproduct = mainproduct;
    }

    /**
     * 获取主购产品
     *
     * @return purchasing - 主购产品
     */
    public String getPurchasing() {
        return purchasing;
    }

    /**
     * 设置主购产品
     *
     * @param purchasing 主购产品
     */
    public void setPurchasing(String purchasing) {
        this.purchasing = purchasing;
    }

    /**
     * @return apDesc
     */
    public String getApdesc() {
        return apdesc;
    }

    /**
     * @param apdesc
     */
    public void setApdesc(String apdesc) {
        this.apdesc = apdesc;
    }

    /**
     * @return ZYPP
     */
    public String getZypp() {
        return zypp;
    }

    /**
     * @param zypp
     */
    public void setZypp(String zypp) {
        this.zypp = zypp;
    }

    /**
     * @return busscope
     */
    public String getBusscope() {
        return busscope;
    }

    /**
     * @param busscope
     */
    public void setBusscope(String busscope) {
        this.busscope = busscope;
    }

    /**
     * @return shopRightImgs
     */
    public String getShoprightimgs() {
        return shoprightimgs;
    }

    /**
     * @param shoprightimgs
     */
    public void setShoprightimgs(String shoprightimgs) {
        this.shoprightimgs = shoprightimgs;
    }

    /**
     * 获取店铺门面 图片
     *
     * @return facadeImg - 店铺门面 图片
     */
    public String getFacadeimg() {
        return facadeimg;
    }

    /**
     * 设置店铺门面 图片
     *
     * @param facadeimg 店铺门面 图片
     */
    public void setFacadeimg(String facadeimg) {
        this.facadeimg = facadeimg;
    }

    /**
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取店铺客服QQ(可能有多个QQ，用逗号隔开)
     *
     * @return serviceQQ - 店铺客服QQ(可能有多个QQ，用逗号隔开)
     */
    public String getServiceqq() {
        return serviceqq;
    }

    /**
     * 设置店铺客服QQ(可能有多个QQ，用逗号隔开)
     *
     * @param serviceqq 店铺客服QQ(可能有多个QQ，用逗号隔开)
     */
    public void setServiceqq(String serviceqq) {
        this.serviceqq = serviceqq;
    }

    /**
     * 获取企业类型
     *
     * @return enterpriseType - 企业类型
     */
    public String getEnterprisetype() {
        return enterprisetype;
    }

    /**
     * 设置企业类型
     *
     * @param enterprisetype 企业类型
     */
    public void setEnterprisetype(String enterprisetype) {
        this.enterprisetype = enterprisetype;
    }

    /**
     * 获取统一社会信用代码（营业执照中的）
     *
     * @return unifiedSocialCreditCode - 统一社会信用代码（营业执照中的）
     */
    public String getUnifiedsocialcreditcode() {
        return unifiedsocialcreditcode;
    }

    /**
     * 设置统一社会信用代码（营业执照中的）
     *
     * @param unifiedsocialcreditcode 统一社会信用代码（营业执照中的）
     */
    public void setUnifiedsocialcreditcode(String unifiedsocialcreditcode) {
        this.unifiedsocialcreditcode = unifiedsocialcreditcode;
    }

    /**
     * 获取注册资本
     *
     * @return registeredCapital - 注册资本
     */
    public String getRegisteredcapital() {
        return registeredcapital;
    }

    /**
     * 设置注册资本
     *
     * @param registeredcapital 注册资本
     */
    public void setRegisteredcapital(String registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    /**
     * 获取经营期限至
     *
     * @return durationOfOperationTo - 经营期限至
     */
    public String getDurationofoperationto() {
        return durationofoperationto;
    }

    /**
     * 设置经营期限至
     *
     * @param durationofoperationto 经营期限至
     */
    public void setDurationofoperationto(String durationofoperationto) {
        this.durationofoperationto = durationofoperationto;
    }

    /**
     * 获取登记机关
     *
     * @return registrationAuthority - 登记机关
     */
    public String getRegistrationauthority() {
        return registrationauthority;
    }

    /**
     * 设置登记机关
     *
     * @param registrationauthority 登记机关
     */
    public void setRegistrationauthority(String registrationauthority) {
        this.registrationauthority = registrationauthority;
    }

    /**
     * 获取登记状态
     *
     * @return registrationStatus - 登记状态
     */
    public String getRegistrationstatus() {
        return registrationstatus;
    }

    /**
     * 设置登记状态
     *
     * @param registrationstatus 登记状态
     */
    public void setRegistrationstatus(String registrationstatus) {
        this.registrationstatus = registrationstatus;
    }

    /**
     * 获取经营模式
     *
     * @return managementModel - 经营模式
     */
    public String getManagementmodel() {
        return managementmodel;
    }

    /**
     * 设置经营模式
     *
     * @param managementmodel 经营模式
     */
    public void setManagementmodel(String managementmodel) {
        this.managementmodel = managementmodel;
    }

    /**
     * 获取年营业额
     *
     * @return annualSalesVolume - 年营业额
     */
    public String getAnnualsalesvolume() {
        return annualsalesvolume;
    }

    /**
     * 设置年营业额
     *
     * @param annualsalesvolume 年营业额
     */
    public void setAnnualsalesvolume(String annualsalesvolume) {
        this.annualsalesvolume = annualsalesvolume;
    }

    /**
     * 获取网址
     *
     * @return web - 网址
     */
    public String getWeb() {
        return web;
    }

    /**
     * 设置网址
     *
     * @param web 网址
     */
    public void setWeb(String web) {
        this.web = web;
    }
}