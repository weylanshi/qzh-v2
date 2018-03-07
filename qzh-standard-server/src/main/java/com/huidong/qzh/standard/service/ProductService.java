package com.huidong.qzh.standard.service;

import com.huidong.qzh.util.common.util.QzhResult;

import java.util.Map;

public interface ProductService {
    /**
     * 通过productID获取价格 库存
     * @param productId
     * @return
     */
    Map<Object,Object> price2StockByProductId(Integer productId);

    /**
     * 新增产品
     * @param info
     */
    String insertProductPublishInfo(String info,Integer memberId);

    /**
     * 通过 产品ID 获取 产品信息   包含  产品名称 价格
     * @param id
     * @return
     */
    QzhResult getProductById(Integer id);

}
