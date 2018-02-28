package com.huidong.qzh.portal.service.impl;


import com.huidong.qzh.portal.entity.EnterpriseType;
import com.huidong.qzh.portal.service.EnterpriseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseTypeServiceImpl implements EnterpriseTypeService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<EnterpriseType> listNames() {
        Query query = new Query(Criteria.where("status").is("1"));
        return  mongoTemplate.find(query, EnterpriseType.class);
    }

}
