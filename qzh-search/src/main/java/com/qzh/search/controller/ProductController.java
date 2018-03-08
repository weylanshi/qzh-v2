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

    @RequestMapping("/delIndex")
    public QzhResult delProductIndex() {
        boolean b = productService.delIndex();
        return QzhResult.ok(b);
    }

    /**
     * @param q        查询条件
     * @param pageNo   页码
     * @param pageSize 每页大小
     * @param order    排序字段  1: 综合排序,2:销量优先 3:价格递增排序 4: 价格递减排序 5: 是否新品
     * @param shopId   店铺id
     * @return QzhResult
     */
    @RequestMapping("/product")
    public QzhResult search(@RequestParam(required = false) String q,
                            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                            @RequestParam(required = false, defaultValue = "16") Integer pageSize,
                            @RequestParam(required = false, defaultValue = "1") Integer order,
                            @RequestParam(required = false) Integer shopId,
                            @RequestParam(required = false) String brand,
                            @RequestParam(required = false) String specOptionName,
                            @RequestParam(required = false) String customCategoryId) {
        QzhPageResult search = productService.search(q, pageNo, pageSize, order, shopId, brand, specOptionName, customCategoryId);
        return QzhResult.ok(search);
    }

}
