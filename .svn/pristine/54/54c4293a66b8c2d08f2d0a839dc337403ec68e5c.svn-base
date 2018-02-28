package com.huidong.qzh.standard.service.Impl;

import com.huidong.qzh.standard.entity.EipMember;
import com.huidong.qzh.standard.entity.ShopStatistics;
import com.huidong.qzh.standard.mapper.EipMemberMapper;
import com.huidong.qzh.standard.mapper.ShopStatisticsMapper;
import com.huidong.qzh.standard.service.ShopStatisticsService;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShopStatisticsServiceImpl implements ShopStatisticsService{

    @Autowired
    private ShopStatisticsMapper shopStatisticsMapper;
    @Autowired
    private EipMemberMapper eipMemberMapper;

    /**
     * 通过memberId 获取商家的店铺统计
     * @param memberId
     * @return
     */
    @Override
    public Map<Object,Object> shopStatisticsByMemberId(Integer memberId) {
        ShopStatistics shopStatistics = new ShopStatistics();
        shopStatistics.setMemberId(memberId);
        ShopStatistics statistics = shopStatisticsMapper.selectOne(shopStatistics);
        BeanMap beanMap = new BeanMap(statistics);

        Map<Object,Object> map = new HashMap<Object,Object>();
        map.putAll(beanMap);
        map.remove("class");
        EipMember eipMember = eipMemberMapper.selectByPrimaryKey(memberId);
        String nickName = eipMember.getNickName();
        String logo = eipMember.getLogo();
        map.put("nickName",nickName);
        map.put("logo",logo);

        return map;
    }
}
