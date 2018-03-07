package com.qzh.store.service.Impl;

import com.huidong.qzh.util.common.util.StringUtils;
import com.qzh.store.entity.Decoration;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.mapper.DecorationMapper;
import com.qzh.store.mapper.StoreInformationMapper;
import com.qzh.store.service.DecorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class DecorationServiceImpl implements DecorationService{

    @Autowired
    private StoreInformationMapper storeInformationMapper;
    @Autowired
    private DecorationMapper  decorationMapper;

    /**
     * 备份店铺模板
     * @param accountId    装修者ID
     * @param memberId     装修者公司Id
     * @param leftSort     左边装修模块的顺序     例如 'customer,search,category,ranking'
     * @param rightSort    右边装修模块的顺序
     */
    public String  insertDecoration(Integer accountId,Integer memberId,String leftSort,String rightSort,Integer decorationId){
        Decoration  decoration = new Decoration();
        //根据memberId获取店铺id
        StoreInformation information = new StoreInformation();

        if(decorationId!=null&&decorationId!=0){
            decoration = decorationMapper.selectByPrimaryKey(decorationId);
        }

        information.setMemberId(memberId);
        information = storeInformationMapper.selectOne(information);
        Integer storeId = information.getId();

        //java8 获取当前时间
        LocalDate now = LocalDate.now();
        //将LocalDate转换成Date
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());

        if(!StringUtils.equalsNull(leftSort)){
            decoration.setLeftPartSort(leftSort);
        }else {
            return "请传左边装修模块的顺序";
        }
        if(!StringUtils.equalsNull(rightSort)){
            decoration.setRightPartSort(rightSort);
        }else {
            return "请传右边装修模块的顺序";
        }
        decoration.setStoreId(storeId);
        decoration.setAccountId(accountId);
        decoration.setMemberId(memberId);
        decoration.setCreateDate(date);
        if(decorationId!=null&&decorationId!=0){
            decorationMapper.updateByPrimaryKey(decoration);
        }else {
            decorationMapper.insert(decoration);
        }
        return "success";
    }

    /**
     * 发布店铺模板
     * @param isPublish  是否发布
     * @param decorationId 店铺装修表的id
     */
    public void updateDecoration(Integer isPublish,Integer decorationId){
        Decoration decoration = new Decoration();
        decoration = decorationMapper.selectByPrimaryKey(decorationId);
        decoration.setIsPublish(isPublish);
        decorationMapper.updateByPrimaryKey(decoration);
    }




}
