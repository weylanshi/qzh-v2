package com.huidong.qzh.market.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huidong.qzh.market.entity.*;
import com.huidong.qzh.market.mapper.*;
import com.huidong.qzh.market.service.MarketPcService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhResult;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class MarketPcServiceImpl implements MarketPcService{
    @Autowired
    private IndustryAdPcMapper industryAdPcMapper;
    @Autowired
    private IndustryPromotionPcMapper industryPromotionPcMapper;
    @Autowired
    private IndustryHotRecommendPcMapper industryHotRecommendPcMapper;
    @Autowired
    private IndustryProductCategoryPcMapper industryProductCategoryPcMapper;
    @Autowired
    private IndustryProductCategroryAdPcMapper industryProductCategroryAdPcMapper;


    /**
     * 产业商圈首页 pc端  轮播广告  右侧广告
     * @return
     */
    @Override
    public QzhResult listIndustryAdPc() {

        try {
            Date date = new Date();
            Example example = new Example(IndustryAdPc.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("adTypes",1);//广告类型   轮播
            criteria.andEqualTo("isDisplay",1);//显示
            criteria.andLessThanOrEqualTo("starttime",date);
            criteria.andGreaterThanOrEqualTo("endtime",date);
            example.setOrderByClause("ad_sort ASC ");
            PageHelper.startPage(1,4);

            List<IndustryAdPc> industryAdPcs = industryAdPcMapper.selectByExample(example);

            //右侧广告位
            Example example2 = new Example(IndustryAdPc.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("adTypes",2);//广告类型   右侧
            criteria2.andEqualTo("isDisplay",1);//显示
            criteria2.andLessThanOrEqualTo("starttime",date);
            criteria2.andGreaterThanOrEqualTo("endtime",date);
            example2.setOrderByClause("ad_sort ASC ");
            PageHelper.startPage(1,2);

            List<IndustryAdPc> industryAdPcs2 = industryAdPcMapper.selectByExample(example2);

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("carousel",industryAdPcs);
            map.put("rightPic",industryAdPcs2);
            return QzhResult.ok(map);

        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());

        }
    }

    /**
     * 产业商圈首页 pc端  促销专区
     * @return
     */
    @Override
    public QzhResult listIndustryPromotionPc(Integer pageNo,Integer pageSize) {
        try {
            Date date = new Date();
            Example example = new Example(IndustryPromotionPc.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("isDisplay",1);//显示
            criteria.andLessThanOrEqualTo("starttime",date);
            criteria.andGreaterThanOrEqualTo("endtime",date);//
            example.setOrderByClause(" sort ASC ");
            PageHelper.startPage(pageNo,pageSize);
            Page<IndustryPromotionPc> industryPromotionPcs = (Page<IndustryPromotionPc>)industryPromotionPcMapper.selectByExample(example);
            return QzhResult.build(200,"请求成功",
                    QzhPageResult.build(industryPromotionPcs.getPageNum(),industryPromotionPcs.getPageSize(),industryPromotionPcs.getTotal(),industryPromotionPcs.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }

    /**
     * 产业商圈首页  pc端   热卖专区  新品推荐
     * @return
     */
    @Override
    public QzhResult listIndustryHotRecommendPc() {
        try {
            Date date = new Date();
            //热卖 大图
            Example example = new Example(IndustryHotRecommendPc.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("isDisplay",1);//显示
            criteria.andEqualTo("adTypes",1);//热卖
            criteria.andEqualTo("pictureTypes",1);
            criteria.andLessThanOrEqualTo("starttime",date);
            criteria.andGreaterThanOrEqualTo("endtime",date);
            example.setOrderByClause(" picture_sort ASC ");
            PageHelper.startPage(1,1);
            List<IndustryHotRecommendPc> industryHotRecommendPcs1 = industryHotRecommendPcMapper.selectByExample(example);

            //热卖  小图
            Example example2 = new Example(IndustryHotRecommendPc.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("isDisplay",1);//显示
            criteria2.andEqualTo("adTypes",1);//热卖
            criteria2.andEqualTo("pictureTypes",2);
            criteria2.andLessThanOrEqualTo("starttime",date);
            criteria2.andGreaterThanOrEqualTo("endtime",date);
            example2.setOrderByClause(" picture_sort ASC ");
            PageHelper.startPage(1,4);
            List<IndustryHotRecommendPc> industryHotRecommendPcs2 = industryHotRecommendPcMapper.selectByExample(example2);

            //推荐  大图
            Example example3 = new Example(IndustryHotRecommendPc.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andEqualTo("isDisplay",1);//显示
            criteria3.andEqualTo("adTypes",2);//新品推荐
            criteria3.andEqualTo("pictureTypes",1);
            criteria3.andLessThanOrEqualTo("starttime",date);
            criteria3.andGreaterThanOrEqualTo("endtime",date);
            example3.setOrderByClause(" picture_sort ASC ");
            PageHelper.startPage(1,1);
            List<IndustryHotRecommendPc> industryHotRecommendPcs3 = industryHotRecommendPcMapper.selectByExample(example3);

            //推荐  小图
            Example example4 = new Example(IndustryHotRecommendPc.class);
            Example.Criteria criteria4 = example4.createCriteria();
            criteria4.andEqualTo("isDisplay",1);//显示
            criteria4.andEqualTo("adTypes",2);//新品推荐
            criteria4.andEqualTo("pictureTypes",2);
            criteria4.andLessThanOrEqualTo("starttime",date);
            criteria4.andGreaterThanOrEqualTo("endtime",date);
            example4.setOrderByClause(" picture_sort ASC ");
            PageHelper.startPage(1,1);
            List<IndustryHotRecommendPc> industryHotRecommendPcs4 = industryHotRecommendPcMapper.selectByExample(example4);

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("hot1",industryHotRecommendPcs1);
            map.put("hot2",industryHotRecommendPcs2);
            map.put("recommend1",industryHotRecommendPcs3);
            map.put("recommend2",industryHotRecommendPcs4);

            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }

    /**
     * 产品商圈首页  pc端  产品分类 及 图片
     * @return
     */
    @Override
    public QzhResult listIndustryProductCategoryPc() {
        try {
            Date date = new Date();
            List<Map<String,Object>> list = new ArrayList<>();
            //分类名称
            Example example = new Example(IndustryProductCategoryPc.class);
            example.setOrderByClause(" sort ASC ");
            List<IndustryProductCategoryPc> industryProductCategoryPcs = industryProductCategoryPcMapper.selectByExample(example);
            //图片
            industryProductCategoryPcs.forEach(industryProductCategoryPc -> {
                //大图
                Example example1 = new Example(IndustryProductCategroryAdPc.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("categoryId",industryProductCategoryPc.getId());
                criteria1.andEqualTo("pictureTypes",1);
                criteria1.andLessThanOrEqualTo("starttime",date);//小于等于
                criteria1.andGreaterThanOrEqualTo("endtime",date);//大于等于
                example1.setOrderByClause(" sort ASC ");
                PageHelper.startPage(1,1);
                List<IndustryProductCategroryAdPc> industryProductCategroryAdPcs1 = industryProductCategroryAdPcMapper.selectByExample(example1);
                //小图
                Example example2 = new Example(IndustryProductCategroryAdPc.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("categoryId",industryProductCategoryPc.getId());
                criteria2.andEqualTo("pictureTypes",2);
                criteria2.andLessThanOrEqualTo("starttime",date);//小于等于
                criteria2.andGreaterThanOrEqualTo("endtime",date);//大于等于
                example2.setOrderByClause(" sort ASC ");
                PageHelper.startPage(1,4);
                List<IndustryProductCategroryAdPc> industryProductCategroryAdPcs2 = industryProductCategroryAdPcMapper.selectByExample(example2);

                Map<String,Object> map = new HashMap<String,Object>();
                map.put("category",industryProductCategoryPc);
                map.put("pic1",industryProductCategroryAdPcs1);
                map.put("pic2",industryProductCategroryAdPcs2);
                list.add(map);
            });
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
}
