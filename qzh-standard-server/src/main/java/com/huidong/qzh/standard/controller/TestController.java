package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.eventcenter.InsertProductEvent;
import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 新增elasticsearch 产品数据测试接口
 */
@RestController
public class TestController {

    @Autowired
    private InsertProductEvent insertProductEvent;

    @RequestMapping("/test/insert")
    public QzhResult insertProduct(){
        ProductSearchDTO productSearchDTO = null;
        for (int i = 0; i < 10000; i++) {
            productSearchDTO = new ProductSearchDTO();
            productSearchDTO.setProductGoodsId(1 + i);
            productSearchDTO.setProductName("白卡纸");
            productSearchDTO.setOriginalPrice(new BigDecimal(10 + i));
            productSearchDTO.setPromotionPrice(new BigDecimal(9 + i));
            productSearchDTO.setSalesVolume(1000 + i);
            productSearchDTO.setPicturePath("http://m.sceo360.com/product/product_30/img/9590e0dd430c428ab9ace04bd68a7f64.jpg");
            productSearchDTO.setSelfSupport(1);
            productSearchDTO.setEipMemberId(1 + i);
            productSearchDTO.setEipMemberName("张三" + i + "的自营店");
            try {
                insertProductEvent.sendInsertProductEvent(productSearchDTO);
            } catch (Exception e) {
                e.printStackTrace();
                return QzhResult.error(e.getMessage(),"");
            }
        }
        return QzhResult.ok();
    }
}
