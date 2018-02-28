package com.qzh.personalCenter.service;

import com.huidong.qzh.util.common.util.QzhResult;

import java.util.Map;

public interface AttentionStoreService {
    /**
     * 关注店铺
     * @param accountId  用户id
     * @param goodsId    货品id
     */
    void insertAttentionStore(Integer accountId, Integer goodsId);
    /**
     * 根据accountId 、pageNo、pageSize 分页获取数据
     * @param accountId  用户id
     * @param pageNo
     * @param pageSize
     * @return
     */
    QzhResult listAttentionStore(Integer accountId, Integer pageNo, Integer pageSize);
    /**
     * ids:是关注店铺表的id，删除多个id时，以逗号隔开
     * @param ids  （1，2，3）
     */
    void deletAttentionStore(String ids);

    /**
     * 判断是否关注店铺
     * @param accountId
     * @param storeId
     * @return
     */
    Integer isAttentionStore(Integer accountId,Integer storeId);


}
