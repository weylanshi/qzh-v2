package com.qzh.store.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.util.JSON;
import com.qzh.store.entity.DecorationBanner;
import com.qzh.store.entity.DecorationCustomer;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.mapper.DecorationBannerMapper;
import com.qzh.store.mapper.StoreInformationMapper;
import com.qzh.store.service.DecorationBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DecorationBannerServiceImpl implements DecorationBannerService{
  @Autowired
    private StoreInformationMapper storeInformationMapper;
  @Autowired
    private DecorationBannerMapper decorationBannerMapper;
    /**
     *插入轮播图片的内容
     * @param memberId     公司id
     * @param pictrueInfo 图片信息
     */
    public String  insertBanner(Integer memberId,String pictrueInfo,Integer decorationBannerId){
        DecorationBanner decorationBanner = new DecorationBanner();
        if(decorationBannerId!=null){
            decorationBanner = decorationBannerMapper.selectByPrimaryKey(decorationBannerId);
        }
        //获取店铺id
        Integer storeId = this.getStoreId(memberId);
        //拿到图片信息
        JSONObject jsonObject = JSONObject.parseObject(pictrueInfo);
        JSONArray objectMap = jsonObject.getJSONArray("pictrueInfo");
        //只有图片数据大于等于1，小于等于5，才能存入数据
        if(objectMap.size()<=5&&objectMap.size()>=1){
                decorationBanner.setStoreId(storeId);
                decorationBanner.setPicture(pictrueInfo);
            if(decorationBannerId!=null){
                decorationBannerMapper.updateByPrimaryKey(decorationBanner);
            }else{
                decorationBannerMapper.insert(decorationBanner);
            }
            return "保存成功";
        }else if(objectMap.size()>5){
            return "轮播图片不能超过五张";
        }else{
            return "轮播图片不能低于一张";
        }

    }

    /**
     * 根据店铺id查询数据
     * @param storeId  店铺id
     * @return
     */
    public List<DecorationBanner> bannerList(Integer storeId){
        List<DecorationBanner> list = new ArrayList<>();
        if(storeId!=null){
            Example example = new Example(DecorationBanner.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("storeId",storeId);
            list = decorationBannerMapper.selectByExample(example);
        }
        return list;
    }

    /**
     *
     * @param memberId           公司id
     * @param title              轮播名称
     * @param isShowTitle        是否展示名称
     * @param effect              切换效果，1上下滚动，2渐变滚动
     * @param decorationBannerId  店铺导航栏id
     * @return
     */
    public String insertDisplay(Integer memberId,String title,Integer isShowTitle,Integer effect,Integer decorationBannerId){

        DecorationBanner decorationBanner = new DecorationBanner();
        if(decorationBannerId!=null){
            decorationBanner = decorationBannerMapper.selectByPrimaryKey(decorationBannerId);
        }
        //获取店铺id
        Integer storeId = this.getStoreId(memberId);
        if(null!=title&&""!=title){
            decorationBanner.setTitle(title);
        }
        if(isShowTitle!=null){
            decorationBanner.setIsShowTitle(isShowTitle);
        }
        if(effect!=null){
            decorationBanner.setEffect(effect);
        }
        if(storeId!=null){
            decorationBanner.setStoreId(storeId);
        }

        if(decorationBannerId!=null){
            decorationBannerMapper.updateByPrimaryKey(decorationBanner);
        }else{
            decorationBannerMapper.insert(decorationBanner);
        }
        return "保存成功";
    }

    public Integer getStoreId(Integer memberId){
        StoreInformation information = new StoreInformation();
        information.setMemberId(memberId);
        information = storeInformationMapper.selectOne(information);
        Integer storeId = information.getId();
        return storeId;
    }
}
