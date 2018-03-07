package com.huidong.qzh.market.service.impl;


import com.huidong.qzh.market.entity.MarketClass;
import com.huidong.qzh.market.entity.MarketLable;
import com.huidong.qzh.market.mapper.MarketClassMapper;
import com.huidong.qzh.market.mapper.MarketLableMapper;
import com.huidong.qzh.market.service.MarketClassService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketClassServiceImpl implements MarketClassService {
    @Autowired
    private MarketClassMapper marketClassMapper;
    @Autowired
    private MarketLableMapper marketLableMapper;

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

    /**
     * 获取产业商圈首页上的分类   pc端
     * @return
     */
    @Override
    public QzhResult listMarketClass() {
        try {
            List<Map<String,Object>> list = new ArrayList<>();
            //一级分类
            Example example = new Example(MarketLable.class);
            example.setOrderByClause(" sort ASC");
            List<MarketLable> marketLables = marketLableMapper.selectByExample(example);
            //二级分类
            marketLables.forEach(marketLable -> {
                Example example1 = new Example(MarketClass.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("lableId",marketLable.getId());
                example1.setOrderByClause(" sort ASC,is_recommend DESC ");
                //example1.setOrderByClause(" is_recommend DESC ");
                List<MarketClass> marketClasses = marketClassMapper.selectByExample(example1);

                Map<String,Object> map = new HashMap<String,Object>();
                map.put("class1",marketLable);
                map.put("class2",marketClasses);
                list.add(map);
            });
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
}
