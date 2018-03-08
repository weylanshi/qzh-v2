package com.qzh.store.service.Impl;

import com.qzh.store.entity.DecorationSignboard;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.mapper.DecorationSignboardMapper;
import com.qzh.store.mapper.StoreInformationMapper;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationRankingService;
import com.qzh.store.service.DecorationSignboardService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecorationSignboardServiceImpl implements DecorationSignboardService {
    @Autowired
    private DecorationSignboardMapper decorationSignboardMapper;
    @Autowired
    private StoreInformationMapper storeInformationMapper;


    /**
     * 根据 店铺 memberId  获得店铺招牌信息
     * */
    @Override
    public DecorationSignboard getDecorationSign(Integer memberId) {
        Integer storeId=this.getStoreId(memberId);
        DecorationSignboard decorationSignboard=new DecorationSignboard();
        decorationSignboard.setStoreId(storeId);
        decorationSignboard= decorationSignboardMapper.selectOne(decorationSignboard);
        return decorationSignboard;
    }

    /**
     * 保存店铺招牌信息
     * */
    @Override
    public Integer doSaveSignboardInfo(DecorationSignboard decorationSignboard) {
        Integer storeId=decorationSignboard.getStoreId();
        DecorationSignboard decorationSignboard1=new DecorationSignboard();
        decorationSignboard1.setStoreId(storeId);
        decorationSignboard1=decorationSignboardMapper.selectOne(decorationSignboard1);
        Integer num=null;
        if(decorationSignboard1!=null){
            Integer id=decorationSignboard1.getId();
            if(StringUtils.isNotBlank(decorationSignboard1.getSignboardPictureUrl())){
                decorationSignboard.setSignboardPictureUrl(decorationSignboard1.getSignboardPictureUrl());
            }
            if(decorationSignboard1.getDecorationId()!=null){
                decorationSignboard.setDecorationId(decorationSignboard1.getDecorationId());
            }
            if(StringUtils.isNotBlank(decorationSignboard1.getSignboradText())){
                decorationSignboard.setSignboradText(decorationSignboard1.getSignboradText());
            }
            decorationSignboard.setId(id);
            num=decorationSignboardMapper.updateByPrimaryKey(decorationSignboard);
        }else{
            num=decorationSignboardMapper.insert(decorationSignboard);
        }
        return num;
    }

    public Integer getStoreId(Integer memberId){
        StoreInformation information = new StoreInformation();
        information.setMemberId(memberId);
        information = storeInformationMapper.selectOne(information);
        Integer storeId = information.getId();
        return storeId;
    }
}
