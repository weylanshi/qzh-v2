package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.entity.ProductSpecOptionRelation;
import com.huidong.qzh.standard.service.ProductGoodsService;
import com.huidong.qzh.standard.service.ProductSpecService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productSpec")
public class ProductSpecController {
    @Autowired
    private ProductSpecService productSpecService;

    /**
     * 产品规格
     * @return
     */
    @RequestMapping("/productGoodsSpecOption")
    public QzhResult listProductSpecOption(@RequestParam(required = true) Integer goodsId){
        try {
            List<Map<String,Object>> stringObjectMap = productSpecService.listProductSpecOption(goodsId);
            return QzhResult.ok(stringObjectMap);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     * 获取分类下的 规格 及 规格选项
     * @param categoryId
     * @return
     */
    @RequestMapping("/listSpecOption")
    public QzhResult listSpecOption(@RequestParam(required = true) Integer categoryId){
        try {
            List list = productSpecService.listSpecOption(categoryId);
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }






}
