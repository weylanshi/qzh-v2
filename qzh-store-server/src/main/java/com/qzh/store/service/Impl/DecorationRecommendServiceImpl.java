package com.qzh.store.service.Impl;

import com.qzh.store.entity.DecorationRanking;
import com.qzh.store.entity.DecorationRecommend;
import com.qzh.store.mapper.DecorationRecommendMapper;
import com.qzh.store.service.DecorationRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecorationRecommendServiceImpl implements DecorationRecommendService{

    @Autowired
    private DecorationRecommendMapper decorationRecommendMapper;

    @Override
    public Integer saveDecorationRecommendInfo(DecorationRecommend decorationRecommend) {
        Integer storeId=decorationRecommend.getStoreId();
        DecorationRecommend decorationRecommend1=new DecorationRecommend();
        decorationRecommend1.setStoreId(storeId);
        DecorationRecommend de= decorationRecommendMapper.selectOne(decorationRecommend1);
        Integer num=null;
       if(de!=null){
           Integer decorationRecommendId=de.getId();
           decorationRecommend.setId(decorationRecommendId);
           num=decorationRecommendMapper.updateByPrimaryKey(decorationRecommend);
           return num;
       }
       num=decorationRecommendMapper.insert(decorationRecommend);
        return num;
    }

    @Override
    public DecorationRecommend selectDecorationRecommend(Integer storeId) {
        DecorationRecommend decorationRecommend=new DecorationRecommend();
        decorationRecommend.setStoreId(storeId);
        decorationRecommend=decorationRecommendMapper.selectOne(decorationRecommend);
            return decorationRecommend;
    }
}
