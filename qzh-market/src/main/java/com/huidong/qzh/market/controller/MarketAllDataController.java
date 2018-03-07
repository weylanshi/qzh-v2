package com.huidong.qzh.market.controller;

import com.huidong.qzh.market.entity.MarketAd;
import com.huidong.qzh.market.entity.MarketClass;
import com.huidong.qzh.market.entity.MarketLable;
import com.huidong.qzh.market.entity.MarketSlide;
import com.huidong.qzh.market.service.MarketAdService;
import com.huidong.qzh.market.service.MarketClassService;
import com.huidong.qzh.market.service.MarketLableService;
import com.huidong.qzh.market.service.MarketSlideService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/MarketData")
public class MarketAllDataController {

    @Autowired
    private MarketAdService marketAdService;

    @Autowired
    private MarketClassService marketClassService;

    @Autowired
    private MarketLableService marketLableService;

    @Autowired
    private MarketSlideService marketSlideService;

    @RequestMapping("/getMarketData")
    public QzhResult getMarketData() {
        try {
            //促销产品
            List<MarketAd> PromotionMarketAd = marketAdService.getPromotionMarketAd();
            //今日推荐产品
            List<MarketAd> RecommendMarketAd = marketAdService.getRecommendMarketAd();
            //分类图
            List<MarketClass> MarketClass = marketClassService.getMarketClass();
            //头部轮播图
            List<MarketSlide> headSlideService = marketSlideService.listMarketSlide_head();
            //今日推荐轮播图
            List<MarketSlide> todayRecommendSlideService = marketSlideService.listMarketSlide_todayRecommend();
            Map<String, Object> map = new HashMap<>();
            map.put("PromotionMarketAd", PromotionMarketAd);
            map.put("RecommendMarketAd", RecommendMarketAd);
            map.put("MarketClass", MarketClass);
            map.put("headSlideService", headSlideService);
            map.put("todayRecommendSlideService", todayRecommendSlideService);
            return QzhResult.ok(map);
        } catch (Exception e) {
            return QzhResult.error(e.getMessage());
        }
    }

    @GetMapping("/getMarketLable")
    public QzhResult getMarketLable(){
        try{
            List<MarketLable> list=marketLableService.getAllMarketLable();
            return QzhResult.ok(list);
        }catch(Exception e){
            return QzhResult.error(e.getMessage());
        }
    }

    @RequestMapping("/getMarketClass")
    public  QzhResult getMarketClass(@RequestParam Integer id){
        try{
            List<MarketClass> list= marketClassService.getMarketClassByLableId(id);
            return QzhResult.ok(list);
        }catch(Exception e){
            return QzhResult.error(e.getMessage());
        }
    }

}
