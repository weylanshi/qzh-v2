package com.qzh.store.service;

import com.qzh.store.entity.DecorationRecommend;

public interface DecorationRecommendService {
    /**
     * 根据storeId得到宝贝推荐信息
     * */
    DecorationRecommend selectDecorationRecommend(Integer storeId);

    /**
     * 保存宝贝推荐信息
     * */
    Integer saveDecorationRecommendInfo(DecorationRecommend decorationRecommend);
}
