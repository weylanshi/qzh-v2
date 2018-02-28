package com.qzh.store.controller;

import com.huidong.qzh.util.common.annotation.LoginRequired;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/storeProduct")
public class StoreProductController {

    @Autowired
    private StoreProductService storeProductService;
    @Autowired
    private CommonService commonService;

    /**
     * 通过 名称  价格  发布与否   分类与否 搜索某商家商品
     * @param info
     * @param pageNo
     * @param pageSize
     * @param request
     * @return
     */
    @PostMapping("/listGoodsCategory")
    public QzhResult listGoodsCategory(@RequestParam(required = false) String info,
                                       @RequestParam(required = true,defaultValue = "1") Integer pageNo,
                                       @RequestParam(required = true,defaultValue = "10") Integer pageSize,
                                       HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> map = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(map.get("memberId").toString());
            return storeProductService.listGoodsCategory(info, pageNo, pageSize, memberId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 商品分类管理  修改/设置分类
     * @param goodsIds
     * @param categoryIds
     * @return
     */
    @PostMapping("/updateGoodsCategory")
    public QzhResult updateGoodsCategoryId(@RequestParam(required = true) String goodsIds,
                                           @RequestParam(required = true) String categoryIds,
                                           HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            return storeProductService.updateGoodsCategory(goodsIds, categoryIds);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

}
