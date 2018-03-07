package com.huidong.qzh.market.controller;

import com.huidong.qzh.market.service.MarketPcService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 产业商圈首页   PC端
 */
@RestController
@RequestMapping("/industryHome")
public class MarketPcController {

    @Autowired
    private MarketPcService marketPcService;

    /**
     *  产业商圈首页 pc端  轮播广告  右侧广告
     * @return
     */
    @RequestMapping("/industryAd")
    public QzhResult listIndustryAdPc(){
        try {
            QzhResult qzhResult = marketPcService.listIndustryAdPc();
            return qzhResult;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     *  产业商圈首页 pc端  促销专区
     * @return
     */
    @RequestMapping("/industryPromotion")
    public QzhResult listIndustryPromotionPc(@RequestParam(defaultValue = "1") Integer pageNo,
                                             @RequestParam(defaultValue = "5") Integer pageSize){
        try {
            QzhResult qzhResult = marketPcService.listIndustryPromotionPc(pageNo, pageSize);
            return qzhResult;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     * 产业商圈首页  pc端   热卖专区  新品推荐
     * @return
     */
    @RequestMapping("/hotRecommend")
    public QzhResult listIndustryHotRecommendPc(){
        try {
            QzhResult qzhResult = marketPcService.listIndustryHotRecommendPc();
            return qzhResult;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 产品商圈首页  pc端  产品分类 及 图片
     * @return
     */
    @RequestMapping("/category")
    public QzhResult listIndustryProductCategoryPc(){
        try {
            QzhResult qzhResult = marketPcService.listIndustryProductCategoryPc();
            return qzhResult;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
}
