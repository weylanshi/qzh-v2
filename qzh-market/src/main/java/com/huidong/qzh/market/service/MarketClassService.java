package com.huidong.qzh.market.service;

import com.huidong.qzh.market.entity.MarketClass;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhResult;

import java.util.List;

public interface MarketClassService {

    //根据分类标签表id得到分类信息
    List<MarketClass> getMarketClassByLableId(Integer id);

    //分页查询分类图
//    QzhPageResult getMarketClass(Integer pageNo,Integer pageSize);

    List<MarketClass> getMarketClass();

    /**
     * 获取产业商圈首页上的分类   pc端
     * @return
     */
    QzhResult listMarketClass();
}
