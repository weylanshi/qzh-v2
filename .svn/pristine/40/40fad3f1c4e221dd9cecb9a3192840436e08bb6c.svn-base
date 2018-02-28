package com.qzh.personalCenter.service;

import com.huidong.qzh.util.common.util.QzhResult;

import javax.servlet.http.HttpServletRequest;

public interface CommonService {

    /**
     * 判断登陆
     * @param request
     * @return
     */
    QzhResult isLand(HttpServletRequest request);

    /**
     * 通过店铺ID 获取 店铺信息   包含商家ID
     * @param storeId
     * @return
     */
    QzhResult storeByStoreId(Integer storeId);


    /**
     * 通过 memberId 获取 商品
     * @param memberId
     * @return
     */
    QzhResult listProductByMemberId(Integer memberId,Integer pageNo,Integer pageSize);

    /**
     * 通过会员ID 获取 会员信息
     * @param id
     * @return
     */
    QzhResult getAccountsById(Integer id);

}
