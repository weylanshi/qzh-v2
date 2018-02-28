package com.huidong.qzh.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huidong.qzh.market.entity.MarketAd;
import com.huidong.qzh.market.entity.MarketClass;
import com.huidong.qzh.market.mapper.MarketClassMapper;
import com.huidong.qzh.market.service.MarketClassService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MarketClassServiceImpl implements MarketClassService {
    @Autowired
    private MarketClassMapper marketClassMapper;

//    @Override
//    public QzhPageResult getMarketClass(Integer pageNo, Integer pageSize) {
//        Example example=new Example(MarketClass.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("isRecommend",1);
//        example.setOrderByClause(" sort ASC ");
//        PageHelper.startPage(pageNo,pageSize);
//        List<MarketClass> list = marketClassMapper.selectByExample(example);
//        PageInfo<MarketClass> pageInfo = new PageInfo<>(list);
//        return QzhPageResult.build(pageNo,pageSize,pageInfo.getTotal(),list);
//    }


    //获取分类图
    @Override
    public List<MarketClass> getMarketClass() {
        Example example=new Example(MarketClass.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isRecommend",1);
        example.setOrderByClause(" sort ASC ");
        List<MarketClass> list = marketClassMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<MarketClass> getMarketClassByLableId(Integer id) {
        Example example=new Example(MarketClass.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("lableId",id);
        List<MarketClass> listMarketClasses=marketClassMapper.selectByExample(example);
        return listMarketClasses;
    }
}
