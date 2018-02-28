package com.huidong.qzh.nonstandard.service.impl;

import com.huidong.qzh.nonstandard.entity.TechnicPrice;
import com.huidong.qzh.nonstandard.service.TechnicPriceService;
import com.huidong.qzh.nonstandard.utils.PaperPriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TechnicPriceServiceImpl implements TechnicPriceService {

    @Autowired
    private MongoTemplate template;

    @Override
    public Double getTechnicPrice(String className, String withAndLen, String technicName, Double amount, Integer repeat) {
        Query query = new Query();
        query.addCriteria(Criteria.where("className").is(className));
        query.addCriteria(Criteria.where("technicName").is(technicName));
        Map<String, Double> wl = PaperPriceUtil.getWithAndLenByStr(withAndLen);
        if (wl != null) {
            query.addCriteria(Criteria.where("width").is(wl.get("w")));
            query.addCriteria(Criteria.where("len").is(wl.get("l")));
        }
        TechnicPrice technicPrice = template.findOne(query, TechnicPrice.class);
        return technicPrice.getBasePrice();
    }
}
