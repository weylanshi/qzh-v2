package com.qzh.search.controller;

import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.search.eventcenter.InsertProductEvent;
import com.qzh.search.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProductController {

    @Autowired
    private InsertProductEvent insertProductEvent;

    @Autowired
    private ProductService productService;

    @RequestMapping("/insert")
    public QzhResult insertProduct() {
        ProductSearchDTO productSearchDTO = null;
        for (int i = 0; i < 10; i++) {
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
                return QzhResult.error(e.getMessage(), "");
            }
        }
        return QzhResult.ok();
    }

    @RequestMapping("/delIndex")
    public QzhResult delProductIndex() {
        boolean b = productService.delIndex();
        return QzhResult.ok(b);
    }

    @RequestMapping("/Search")
    public QzhResult search(@RequestParam String q,
                            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                            @RequestParam(required = false, defaultValue = "16") Integer pageSize) {
        QzhPageResult search = productService.search(q, pageNo, pageSize);
        return QzhResult.ok(search);
    }

}
