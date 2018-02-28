package com.huidong.qzh.standard.service;

import com.huidong.qzh.standard.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    /**
     *根据parentId 查询分类
     * @return
     */
    List<ProductCategory> listProductCategoryByParentId(Integer parentId);
}
