package com.qzh.store.service;

import com.huidong.qzh.util.common.util.QzhResult;

public interface StoreProductService {


    /**
     * 商品分类管理  通过 名称  价格  发布与否   分类与否 搜索商家商品
     * @param info
     * @return
     */
    QzhResult listGoodsCategory(String info, Integer pageNo, Integer PageSize,Integer memberId);

    /**
     * 店铺商品分类管理  修改/设置分类
     * @param goodsIds
     * @param categoryIds
     * @return
     */
    QzhResult updateGoodsCategory(String goodsIds,String categoryIds);


}
