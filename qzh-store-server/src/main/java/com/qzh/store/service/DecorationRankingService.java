package com.qzh.store.service;


import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.DecorationRanking;

public interface DecorationRankingService {

    /**
     * 保存宝贝排行榜数据
     * */
    Integer insertDecorationRanking(DecorationRanking decorationRanking);

    /**
     * 根据memberId 到store_information表中 获得store_id
     * */
    Integer getStoreId(Integer memberId);

    /**
     * 根据 store_id 查询 店铺宝贝排行榜信息
     * */
    DecorationRanking selectByStoreId(Integer storeId);
}
