package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.eventcenter.InsertProductEvent;
import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 新增elasticsearch 产品数据测试接口
 */
@RestController
public class TestController {

    @Autowired
    private InsertProductEvent insertProductEvent;

    @RequestMapping("/test/insert")
    public QzhResult insertProduct() {
        ProductSearchDTO productSearchDTO = null;
        for (int i = 0; i < 10000; i++) {
            productSearchDTO = new ProductSearchDTO();
            productSearchDTO.setProductGoodsId(1 + i);
            productSearchDTO.setProductName("白卡纸");
            productSearchDTO.setOriginalPrice(new BigDecimal(10 + i));
            productSearchDTO.setPromotionPrice(new BigDecimal(9 + i));
            productSearchDTO.setSalesVolume(1000 + i);
            productSearchDTO.setPicturePath("https://m.sceo360.com/product/product_30/img/9590e0dd430c428ab9ace04bd68a7f64.jpg");
            productSearchDTO.setSelfSupport(1);
            productSearchDTO.setEipMemberId(1 + i);
            productSearchDTO.setEipMemberName("张三" + i + "的自营店");
            productSearchDTO.setClickVolume(i);
            productSearchDTO.setIsNew(0);
            productSearchDTO.setUpdateTime(new Date());
            productSearchDTO.setBrand("测试品牌" + i / 1000);
            productSearchDTO.setCategoryId(i / 1000 + 1);
            productSearchDTO.setSpecOptionName("平张,卷筒,汇东");
            productSearchDTO.setUnit("盒");
            productSearchDTO.setCustomCategoryId("123");
            try {
                insertProductEvent.sendInsertProductEvent(productSearchDTO);
            } catch (Exception e) {
                e.printStackTrace();
                return QzhResult.error(e.getMessage(), "");
            }
        }
        return QzhResult.ok();
    }
}
