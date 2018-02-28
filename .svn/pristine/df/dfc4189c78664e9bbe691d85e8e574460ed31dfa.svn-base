package com.huidong.qzh.nonstandard.controller;

import com.alibaba.fastjson.JSON;
import com.huidong.qzh.nonstandard.service.BusinessCardService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/businessCard")
public class BusinessCardController {
    @Autowired
    private BusinessCardService businessCardService;


    /**
     * 根据memberId、title、materialName、productNum、technic来获取名片的价格
     * @param memberId      公司id
     * @param title         自定义的分类名称
     * @param materialName  材料名称
     * @param productNum   产品数量
     * @param technic     加工工艺的种类
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/getBusinessCardPrices")
    public QzhResult getBusinessCardPrices(@RequestParam(required = false) Integer memberId,
                                     @RequestParam(required = false) String title,
                                     @RequestParam(required = false) String materialName,
                                     @RequestParam(required = false) int productNum,
                                     @RequestParam(required = false) String technic){
        Map map = new HashMap();
        if(StringUtils.isNotBlank(technic)){
            map = JSON.parseObject(technic);
        }
        try {
            return QzhResult.ok(businessCardService.getBusinessCardPrices(title, memberId, materialName,productNum, map));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 点击分类名称获取产品详情
     * @param title 自定义分类名称
     * @return
     */
    @RequestMapping("/getBusinessCard")
    public QzhResult getBusinessCard(@RequestParam( required = false) String title,
                                       @RequestParam( required = false) Integer memberId ){
        try {
            return QzhResult.ok(businessCardService.getBusinessCard(title,memberId));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 非标品新增产品
     * @param data
     * @return
     */
    @RequestMapping(path = "/insertBusinessCard")
    public QzhResult insertAttribute(@RequestParam(required = false)  String data){
        try {
            return QzhResult.ok(businessCardService.insertBusinessCard(data));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
}
