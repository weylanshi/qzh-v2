package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.DecorationRanking;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/decorationRanking")
public class DecorationRankingController {
    @Autowired
    private DecorationRankingService decorationRankingService;
    @Autowired
    private CommonService commonService;

    /**
     * 打开宝贝排行榜设置页面
     * */
    @RequestMapping(value = "/getDecorationRanking")
    public QzhResult getDecorationRanking(HttpServletRequest request){
        try{
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            DecorationRanking decorationRanking=decorationRankingService.selectByStoreId(memberId);
            return QzhResult.ok(decorationRanking);
        }catch (Exception e){
            return QzhResult.error(e.getMessage());
        }
    }
    /**
     * @param title   标题
     * @param isShowTitle  是否显示标题
     * @param categoryId  分类列表id
     * @param keyWords  关键字
     * @param priceRegion 价格范围  （范围中间用逗号隔开）
     * @param pageSize  显示数量
     * @param defaultDe  默认显示
     * @param isShowMonth  是否显示30天销量数据
     *
     *  保存店铺宝贝排行榜信息
     *
     * */
    @RequestMapping(value="/insertDecorationRanking")
    public QzhResult insertDecorationRanking(
                                            HttpServletRequest request,
                                            @RequestParam(required = false) String title,
                                            @RequestParam(required = false) Integer isShowTitle,
                                            @RequestParam(required = false) Integer categoryId,
                                            @RequestParam(required = false) String keyWords,
                                            @RequestParam(required = false) String priceRegion,
                                            @RequestParam(required = false) Integer pageSize,
                                            @RequestParam(required = false) Integer defaultDe,
                                            @RequestParam(required = false) Integer isShowMonth
                                            ){
        try{
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            Integer storeId=decorationRankingService.getStoreId(memberId);
            Integer integer=null;
            if(storeId!=null){
                DecorationRanking decorationRanking=new DecorationRanking();
                if(title!=null){
                    decorationRanking.setTitle(title);
                }
                if(isShowTitle!=null){
                    decorationRanking.setIsShowTitle(isShowTitle);
                }
                if(categoryId!=null){
                    decorationRanking.setCategoryId(categoryId);
                }
                if(keyWords!=null){
                    decorationRanking.setKeyWords(keyWords);
                }
                if(priceRegion!=null){
                    decorationRanking.setPriceRegion(priceRegion);
                }
                if(pageSize!=null){
                    decorationRanking.setPageSize(pageSize);
                }
                if(defaultDe!=null){
                    decorationRanking.setDefaultDe(defaultDe);
                }
                if(isShowMonth!=null){
                    decorationRanking.setIsShowMonth(isShowMonth);
                }
                if(storeId!=null){
                    decorationRanking.setStoreId(storeId);
                }
                integer=decorationRankingService.insertDecorationRanking(decorationRanking);
            }
            if(integer>0){
                return QzhResult.ok("保存成功！");
            }

        }catch(Exception e){
            return QzhResult.error(e.getMessage());
        }
       return QzhResult.ok("保存失败！");
    }
}
