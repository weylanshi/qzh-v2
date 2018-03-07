package com.huidong.qzh.market.service.impl;


import com.huidong.qzh.market.entity.MarketClass;
import com.huidong.qzh.market.entity.MarketLable;
import com.huidong.qzh.market.mapper.MarketClassMapper;
import com.huidong.qzh.market.mapper.MarketLableMapper;
import com.huidong.qzh.market.service.MarketClassService;
import com.huidong.qzh.market.service.MarketLableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketLableServiceImpl implements MarketLableService {
    @Autowired
    private MarketLableMapper marketLableMapper;


    @Override
    public List<MarketLable> getAllMarketLable() {
        Example example=new Example(MarketLable.class);
        example.setOrderByClause("sort asc");
        List<MarketLable> listLable= marketLableMapper.selectByExample(example);
        return listLable;
    }






}
