package com.qzh.store.service;

import com.huidong.qzh.util.common.util.QzhResult;

import java.util.Map;

public interface StoreInformationService {
    /**
     * 根据storeId 获取店铺信息
     * @param storeId
     * @return
     */
    Map<Object, Object> getStoreInformation(Integer storeId);
    /**
     * 随收藏店铺实时增减数量
     * @param storeId  店铺id
     * @param status   状态：add :关注店铺数量就增加一，del:就减一
     */
    void addDelAttentionNum(Integer storeId,String status);

    /**
     * 通过商家ID 获取 店铺信息
     * @param memberId
     * @return
     */
    QzhResult getStoreByMemberId(Integer memberId);

}
