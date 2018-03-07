package com.qzh.store.service.Impl;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.DecorationRanking;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.mapper.DecorationRankingMapper;
import com.qzh.store.mapper.StoreInformationMapper;
import com.qzh.store.service.DecorationRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecorationRankingServiceImpl implements DecorationRankingService{
    @Autowired
    private DecorationRankingMapper decorationRankingMapper;
    @Autowired
    private StoreInformationMapper storeInformationMapper;

    /**
     * 根据storeId得到宝贝排行榜信息
     * */
    @Override
    public DecorationRanking selectByStoreId(Integer memberId) {
        Integer storeId=getStoreId(memberId);
        DecorationRanking decorationRanking=new DecorationRanking();
        decorationRanking.setStoreId(storeId);
        decorationRanking=decorationRankingMapper.selectOne(decorationRanking);
        System.out.println(decorationRanking);
        return decorationRanking;
    }

    /**
     * 根据memberId得到storedId
     * */
    @Override
    public Integer getStoreId(Integer memberId) {
        StoreInformation storeInformation=new StoreInformation();
        storeInformation.setMemberId(memberId);
        storeInformation = storeInformationMapper.selectOne(storeInformation);
        Integer storeId=null;
        if(storeInformation!=null){
             storeId=storeInformation.getId();
        }
        return storeId;
    }

    /**
     * 根据storedId判断宝贝排行榜信息是否存在 从而进行插入或者修改 信息
     * */
    @Override
    public Integer insertDecorationRanking(DecorationRanking decorationRanking) {
        Integer storeId=decorationRanking.getStoreId();
        DecorationRanking decorationRanking1=new DecorationRanking();
        decorationRanking1.setStoreId(storeId);
        decorationRanking1=decorationRankingMapper.selectOne(decorationRanking1);
        if(decorationRanking1!=null){
            Integer id=decorationRanking1.getId();
            decorationRanking.setId(id);
            return decorationRankingMapper.updateByPrimaryKey(decorationRanking);
        }
        return  decorationRankingMapper.insert(decorationRanking);
    }
}
