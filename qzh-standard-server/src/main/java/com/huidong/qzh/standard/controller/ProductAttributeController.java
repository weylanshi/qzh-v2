package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.service.ProductAttributeService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productAttribute")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    /**
     * 产品属性
     * @return
     */
    @RequestMapping("/productGoodsAttributeOption")
    public QzhResult listProductAttributeOption(@RequestParam(required = true) Integer goodsId){
        try {
            List list = productAttributeService.listProductAttribute(goodsId);
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 通过分类ID 获取所有品牌的属性选项
     * @param categoryId
     * @return
     */
    @RequestMapping("/categoryBrand")
    public QzhResult listBrandAttribute(@RequestParam(required = true) Integer categoryId){
        try {

            List list =  productAttributeService.listBrandAttribute(categoryId);
            if(null==list||list.size()==0){
                List list2 = new ArrayList();
                return QzhResult.ok(list2);
            }else{
                return QzhResult.ok(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     * 获取这个分类下的所有属性 及 属性选项
     * @param categoryId
     * @return
     */
    @RequestMapping("/listAttOption")
    public QzhResult listAttributeOption(@RequestParam(required = true) Integer categoryId){
        try {
            List list = productAttributeService.listAttributeOption(categoryId);
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


}
