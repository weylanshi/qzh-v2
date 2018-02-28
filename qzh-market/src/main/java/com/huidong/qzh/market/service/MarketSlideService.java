package com.huidong.qzh.market.service;

import com.huidong.qzh.market.entity.MarketSlide;

import java.util.List;
import java.util.Map;

public interface MarketSlideService {
    Map<String,List<MarketSlide>> getAllMarketSlide();


    /**
     * 产业商圈首页头部轮播图
     * @return
     */
    List listMarketSlide_head();

    /**
     * 产业商圈首页 今日推荐的轮播图
     * @return
     */
    List listMarketSlide_todayRecommend();

}
