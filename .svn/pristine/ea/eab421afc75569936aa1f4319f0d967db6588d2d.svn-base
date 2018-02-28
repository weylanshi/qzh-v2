package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.entity.ProductCategory;
import com.huidong.qzh.standard.service.ProductCategoryService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/productCategory")
    public QzhResult listProductCategory(@RequestParam(defaultValue = "0",required = false) Integer parentId){
        try {
            List<ProductCategory> list = productCategoryService.listProductCategoryByParentId(parentId);
            return QzhResult.build(200,list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }

    }

}
