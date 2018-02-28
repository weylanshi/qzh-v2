package com.huidong.qzh.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huidong.qzh.market.entity.MarketAd;
import com.huidong.qzh.market.mapper.MarketAdMapper;
import com.huidong.qzh.market.service.MarketAdService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.List;


@Service
public class MarketAdServiceImpl implements MarketAdService {
    @Autowired
     private MarketAdMapper marketAdMapper;


    //今日推荐 固定个数
    @Override
    public List<MarketAd> getRecommendMarketAd() {
        Example example = new Example(MarketAd.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productSellType",1);
        PageHelper.startPage(1,5);
        List<MarketAd> list = marketAdMapper.selectByExample(example);
        return list;


    }

    //促销产品
    @Override
    public List<MarketAd> getPromotionMarketAd() {
        Example example = new Example(MarketAd.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productSellType",2);
        List<MarketAd> list = marketAdMapper.selectByExample(example);
        return list;

    }













//    public QzhPageResult commomCode(Integer type){
//        Example example = new Example(MarketAd.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("productSellType",type);
//        PageHelper.startPage(pageNo,pageSize);
//        List<MarketAd> list = marketAdMapper.selectByExample(example);
//        PageInfo<MarketAd> pageInfo = new PageInfo<>(list);
//        return QzhPageResult.build(pageNo,pageSize,pageInfo.getTotal(),list);
//    }
}
