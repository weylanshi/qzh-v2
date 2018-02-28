package com.huidong.qzh.nonstandard.service.impl;

import com.huidong.qzh.nonstandard.entity.MaterialPrice;
import com.huidong.qzh.nonstandard.service.MaterialPriceService;
import com.huidong.qzh.nonstandard.utils.PaperPriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class MaterialPriceServiceImpl implements MaterialPriceService {

    @Autowired
    private MongoTemplate template;

    public  Double getMaterialUnitPrice(String className ,String paperName,Integer paperNum){
        MaterialPrice materialPrice = null;
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("className").is(className));
            query.addCriteria(Criteria.where("paperName").is(paperName));
            materialPrice = template.findOne(query, MaterialPrice.class);
            return PaperPriceUtil.getPaperPrice(materialPrice.getPrice(),paperName,paperNum);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
