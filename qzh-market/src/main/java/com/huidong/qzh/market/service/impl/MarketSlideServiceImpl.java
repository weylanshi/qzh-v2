package com.huidong.qzh.market.service.impl;


import com.huidong.qzh.market.entity.MarketSlide;
import com.huidong.qzh.market.mapper.MarketSlideMapper;
import com.huidong.qzh.market.service.MarketSlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketSlideServiceImpl implements MarketSlideService {
    @Autowired
    private MarketSlideMapper marketSlideMapper;

    @Override
    public Map<String,List<MarketSlide>> getAllMarketSlide() {
        Example example = new Example(MarketSlide.class);
        List<MarketSlide> marketSlides = marketSlideMapper.selectByExample(example);
        List<MarketSlide> upSlide=new ArrayList<MarketSlide>();//产业商圈上面轮播图
        List<MarketSlide> downSlide=new ArrayList<MarketSlide>();//产业商圈下面轮播图
        if(marketSlides.size()>0){
            for(MarketSlide m:marketSlides){
                if(m.getSlideType()==1){
                    upSlide.add(m);
                }else{
                    downSlide.add(m);
                }
            }
        }
        Map<String,List<MarketSlide>> map=new HashMap<String,List<MarketSlide>>();
        map.put("upSlide",upSlide);
        map.put("downSlide",downSlide);
        return map;
    }

    /**
     * 产业商圈首页头部轮播图
     * @return
     */
    @Override
    public List listMarketSlide_head() {
        Example example = new Example(MarketSlide.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("slideType",1);

        List<MarketSlide> marketSlides = marketSlideMapper.selectByExample(example);
        return marketSlides;
    }

    /**
     * 产业商圈首页 今日推荐的轮播图
     * @return
     */
    @Override
    public List listMarketSlide_todayRecommend() {
        Example example = new Example(MarketSlide.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("slideType",2);

        List<MarketSlide> marketSlides = marketSlideMapper.selectByExample(example);
        return marketSlides;
    }


}
