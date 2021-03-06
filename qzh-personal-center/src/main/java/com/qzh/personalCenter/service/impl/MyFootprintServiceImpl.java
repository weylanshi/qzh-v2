package com.qzh.personalCenter.service.impl;

import com.huidong.qzh.util.common.util.QzhResult;
import com.huidong.qzh.util.common.util.StringUtils;
import com.qzh.personalCenter.entity.MyFootprint;
import com.qzh.personalCenter.feign.StandardFeignClient;
import com.qzh.personalCenter.mapper.MyFootprintMapper;
import com.qzh.personalCenter.service.CommonService;
import com.qzh.personalCenter.service.MyFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyFootprintServiceImpl implements MyFootprintService{
    @Autowired
    private MyFootprintMapper myFootprintMapper;

    @Autowired
    private StandardFeignClient standardFeignClient;
    @Autowired
    RestTemplate restTemplate;


    /**
     * 获取 会员 所有的记录  浏览商品的
     * @param accountId
     * @return
     */
    @Override
    public List listMyFootprint(Integer accountId) {
        Example example = new Example(MyFootprint.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("accountId",accountId);
        example.setOrderByClause(" id DESC ");
        List<MyFootprint> myFootprints = myFootprintMapper.selectByExample(example);
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

        myFootprints.forEach(myFootprint -> {
            //QzhResult productGoodsById = standardFeignClient.getProductGoodsById(myFootprint.getGoodsId());
            String url = "http://QZH-STANDARD/productGoods/getProductGoodsById/{1}";

            ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity(url, QzhResult.class, myFootprint.getGoodsId());
            QzhResult productGoodsById = responseEntity.getBody();
            Object data = productGoodsById.getData();
            Integer status = productGoodsById.getStatus();
            if(status==200&&data!=null){
                Map<Object,Object> map = (Map<Object,Object>)data;
                map.put("myFootId",myFootprint.getId());
                list.add(map);
            }
        });

        return list;
    }

    /**
     * 新增 浏览商品的记录 ： 每个会员最多12个
     * 1.判断记录中是否有goodsId ,有删除后新增；没有新增
     * 2.判断总个数，把大于12的最早的删除
     * @param accountId
     * @param goodsId
     * @return
     */
    @Override
    public void addMyFootprint(Integer accountId, Integer goodsId) {
        MyFootprint footprint = new MyFootprint();
        footprint.setAccountId(accountId);
        footprint.setGoodsId(goodsId);
        MyFootprint footprint1 = myFootprintMapper.selectOne(footprint);
        if(footprint1!=null){
            myFootprintMapper.delete(footprint1);
        }
        myFootprintMapper.insert(footprint);

        Example example = new Example(MyFootprint.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("accountId",accountId);
        example.setOrderByClause(" id DESC ");
        List<MyFootprint> myFootprints = myFootprintMapper.selectByExample(example);
        int i = 0;
        for (MyFootprint myFootprint : myFootprints) {
            i++;
            if(i>12){
                myFootprintMapper.delete(myFootprint);
            }
        }

    }

    /**
     * 删除
     * @param ids  以逗号隔开
     */
    @Override
    public void deleteMyFootprint(String ids) {
        String[] idstr = ids.split(",");
        for(int i=0;i<idstr.length;i++){
            if(!StringUtils.equalsNull(idstr[i])){
                myFootprintMapper.deleteByPrimaryKey(Integer.parseInt(idstr[i]));
            }
        }
    }
}
