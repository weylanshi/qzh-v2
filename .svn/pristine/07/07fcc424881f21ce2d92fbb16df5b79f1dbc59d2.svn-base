package com.huidong.qzh.portal.service.impl;

import com.huidong.qzh.portal.entity.IndustryType;
import com.huidong.qzh.portal.service.IndustryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryTypeServiceImpl  implements IndustryTypeService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<IndustryType> listFirstLv() {
        Query query = new Query(Criteria.where("superKey").is("0"));
        return  mongoTemplate.find(query, IndustryType.class);
    }

    @Override
    public List<IndustryType> listSecondLv(String firstLv) {
        Query query = new Query(Criteria.where("superKey").is(firstLv));
        return  mongoTemplate.find(query, IndustryType.class);
    }
}
