package com.qzh.personalCenter.service;

import java.util.List;

public interface MyFootprintService {

    /**
     * 获取 会员 所有的记录  浏览商品的
     * @param accountId
     * @return
     */
    List listMyFootprint(Integer accountId);

    /**
     * 新增 浏览商品的记录 ： 每个会员最多12个
     * @param accountId
     * @param goodsId
     * @return
     */
    void addMyFootprint(Integer accountId,Integer goodsId);

    /**
     * 删除
     * @param ids  以逗号隔开
     */
    void deleteMyFootprint(String ids);

}
