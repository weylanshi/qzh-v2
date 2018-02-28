package com.huidong.qzh.portal.service.impl;

import com.huidong.qzh.portal.entity.EipHomeAd;
import com.huidong.qzh.portal.mapper.EipHomeAdMapper;
import com.huidong.qzh.portal.service.EipHomeAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EipHomeAdServiceImpl implements EipHomeAdService {


    @Autowired
    private EipHomeAdMapper homeAdMapper;

    @Override
    public Map<String,List<EipHomeAd>> findAllAd(){
        Date now = new Date();
        Example example = new Example(EipHomeAd.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThanOrEqualTo("adEndTime",now);
        criteria.andLessThanOrEqualTo("adStartTime",now);
        criteria.andEqualTo("status",1);
        List<EipHomeAd> adList = homeAdMapper.selectByExample(example);
        Map<String, List<EipHomeAd>> groupedAds =
                adList.stream().collect(Collectors.groupingBy(EipHomeAd::getAdType));
        return groupedAds;
    }



}
