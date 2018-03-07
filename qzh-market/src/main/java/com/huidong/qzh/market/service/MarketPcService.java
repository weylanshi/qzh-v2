package com.huidong.qzh.market.service;

import com.huidong.qzh.util.common.util.QzhResult;

public interface MarketPcService {
    /**
     * 产业商圈首页 pc端  轮播广告  右侧广告
     * @return
     */
    QzhResult listIndustryAdPc();

    /**
     * 产业商圈首页 pc端  促销专区
     * @return
     */
    QzhResult listIndustryPromotionPc(Integer pageNo,Integer pageSize);

    /**
     * 产业商圈首页  pc端   热卖专区  新品推荐
     * @return
     */
    QzhResult listIndustryHotRecommendPc();

    /**
     * 产品商圈首页  pc端  产品分类 及 图片
     * @return
     */
    QzhResult listIndustryProductCategoryPc();



}
