package com.qzh.personalCenter.service;

import com.huidong.qzh.util.common.util.QzhResult;

import java.util.List;
import java.util.Map;

public interface CollectProductService {
    /**
     * 收藏产品
     * @param accountId  用户id
     * @param goodsId    货品id
     */
    void insertCollectProduct(Integer accountId,Integer goodsId);
    /**
     * 根据accountId 、pageNo、pageSize 分页获取数据
     * @param accountId  用户id
     * @param pageNo
     * @param pageSize
     * @return
     */
    QzhResult listCollectProduct(Integer accountId, Integer pageNo, Integer pageSize);
    /**
     * ids:是收藏商品表的id，删除多个id时，以逗号隔开
     * @param ids  （1，2，3）
     */
    void deletCollectProduct(String ids);

    /**
     *判断是否收藏商品
     * @return
     */
    Integer isCollectProduct(Integer accountId, Integer goodsId);

}
