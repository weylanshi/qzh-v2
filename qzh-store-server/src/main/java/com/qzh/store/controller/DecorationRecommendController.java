package com.qzh.store.controller;


import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.DecorationRanking;
import com.qzh.store.entity.DecorationRecommend;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationRankingService;
import com.qzh.store.service.DecorationRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/DecorationRecommend")
public class DecorationRecommendController {
    @Autowired
    private DecorationRecommendService decorationRecommendService;
    @Autowired
    private DecorationRankingService decorationRankingService;
    @Autowired
    private CommonService commonService;

    @RequestMapping("/getDecorationRecommendInfo")
    public QzhResult getDecorationRecommendInfo(HttpServletRequest request){
        try{
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            Integer storeId=decorationRankingService.getStoreId(memberId);
            DecorationRecommend decorationRecommend=decorationRecommendService.selectDecorationRecommend(storeId);
            return QzhResult.ok(decorationRecommend);
        }catch (Exception e){
            return QzhResult.error(e.getMessage());
        }

    }

    /**
     * @param title 模块标题
     * @param isShowTitle 是否展示模块标题，1是，0否
     * @param recommendType 推荐方式，1代表自动推荐，2代表手工推荐
     * @param sortType 自动推荐排序，1人气指数，2热卖宝贝在前，3热门收藏在前，4最新发布在前，5价格最低在前，6价格最低在后
     * @param categoryId 产品分类，0代表全部
     * @param keyWords 关键字
     * @param priceRegion 价格范围,例如20.00,1000.05
     * @param pageSize 显示数量
     * @param displayType 展示方式，1.一行展示4个产品2.一行展示3产品3.一行无缝展示3个产品
     * */
    @RequestMapping("/doSaveDecorationRecommentInfo")
    public QzhResult doSaveDecorationRecommentInfo(HttpServletRequest request,DecorationRecommend decorationRecommend){
        try{
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            Integer storeId=decorationRankingService.getStoreId(memberId);
            decorationRecommend.setStoreId(storeId);
            Integer num=decorationRecommendService.saveDecorationRecommendInfo(decorationRecommend);
            if(num>0){
                return QzhResult.ok("保存成功！");
            }
        }catch (Exception e){
            return QzhResult.error(e.getMessage());
        }
        return QzhResult.ok("保存失败！");
    }
}
