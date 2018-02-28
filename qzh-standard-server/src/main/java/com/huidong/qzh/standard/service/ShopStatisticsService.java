package com.huidong.qzh.standard.service;

import com.huidong.qzh.standard.entity.ShopStatistics;
import org.apache.commons.beanutils.BeanMap;

import java.util.Map;

public interface ShopStatisticsService {

    /**
     * 通过memberId 获取商家的店铺统计
     * @param memberId
     * @return
     */
    Map<Object,Object> shopStatisticsByMemberId(Integer memberId);

}
