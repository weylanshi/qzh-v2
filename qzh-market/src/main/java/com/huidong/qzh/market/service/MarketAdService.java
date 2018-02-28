package com.huidong.qzh.market.service;


import com.huidong.qzh.market.entity.MarketAd;
import com.huidong.qzh.util.common.util.QzhPageResult;

import java.util.List;


public interface MarketAdService {

    //获得今日推荐产品
    List<MarketAd> getRecommendMarketAd();

    //获得促销专区产品
    List<MarketAd> getPromotionMarketAd();
}
