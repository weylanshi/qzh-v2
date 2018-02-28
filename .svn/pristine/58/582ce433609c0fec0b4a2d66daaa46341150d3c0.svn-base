package com.qzh.store.service.Impl;


import com.alibaba.druid.util.StringUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.mapper.StoreInformationMapper;
import com.qzh.store.service.StoreInformationService;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.HashMap;
import java.util.Map;

@Service
public class StoreInformationServiceImpl implements StoreInformationService {

    @Autowired
    private StoreInformationMapper storeInformationMapper;

    /**
     *根据storeId 获取店铺信息
     * @param storeId  店铺的id
     * @return
     */
    public Map<Object, Object> getStoreInformation(Integer storeId){
        Map<Object,Object> map = new HashMap<Object,Object>();
        //根据店铺id获取店铺信息
        StoreInformation storeInfo = storeInformationMapper.selectByPrimaryKey(storeId);
        BeanMap beanMap = new BeanMap(storeInfo);
        map.putAll(beanMap);
        return  map;
    }

    /**
     * 随收藏店铺实时增减数量
     * @param storeId  店铺id
     * @param status   状态：add :关注店铺数量就增加一，del:就减一
     */
    public void addDelAttentionNum(Integer storeId,String status){
        StoreInformation storeInfo = storeInformationMapper.selectByPrimaryKey(storeId);
        Integer attentionNum = storeInfo.getAttentionNum();
        if(null==attentionNum){
            attentionNum = 0;
        }
        if(StringUtils.equals(status,"add")){//状态是新增关注店铺时，关注店铺数量+1
            attentionNum+=1;
        }else if(StringUtils.equals(status,"del")){//状态是删除关注店铺时，关注店铺数量-1
            attentionNum-=1;
        }
        //根据goodsId修改该店铺的收藏数量
        Example example = new Example(StoreInformation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",storeId);
        StoreInformation storeInfo1 = new StoreInformation();
        storeInfo1.setAttentionNum(attentionNum);
        storeInformationMapper.updateByExampleSelective(storeInfo1,example);
    }

    /**
     * 通过商家ID 获取 店铺信息
     * @param memberId
     * @return
     */
    @Override
    public QzhResult getStoreByMemberId(Integer memberId) {
        StoreInformation information = new StoreInformation();
        information.setMemberId(memberId);
        information = storeInformationMapper.selectOne(information);
        if(information!=null){
            return QzhResult.ok(information);
        }
        return QzhResult.error("");
    }
}
