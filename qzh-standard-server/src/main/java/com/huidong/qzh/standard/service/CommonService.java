package com.huidong.qzh.standard.service;

import com.huidong.qzh.util.common.util.QzhResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CommonService {

    /**
     * 获取 所有的计量单位
     * @return
     */
    List listUnit();

    /**
     * 判断登陆
     * @param request
     * @return
     */
    QzhResult isLand(HttpServletRequest request);

    /**
     * 判断是否关注店铺
     * @param accountId
     * @param storeId
     * @return
     */
    QzhResult isAttentionStore(Integer accountId,Integer storeId);

    /**
     * 判断是否收藏商品
     * @param accountId
     * @param goodsId
     * @return
     */
    QzhResult isCollectProduct(Integer accountId,Integer goodsId);

    /**
     *通过商家ID 获取 店铺ID
     * @param memberId
     * @return
     */
    QzhResult getStoreByMemberId(Integer memberId);

}
