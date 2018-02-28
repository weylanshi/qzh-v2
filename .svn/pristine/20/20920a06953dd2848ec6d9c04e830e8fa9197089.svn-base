package com.huidong.qzh.nonstandard.service;

import com.huidong.qzh.nonstandard.entity.Category;
import com.mongodb.DBObject;

import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AttributeService {
    public DBObject getAttributeByClassName(String className);
    public DBObject getProductDetail(String title) throws ScriptException;
    public BigDecimal getProductPrice(Integer memberId,String title, String pageSize, String weight,int isDouble,int amount,Map<String, Integer> selectedTech) throws Exception;

/*    public DBObject getPrice(String className);*/

    public String insertAttribute(String data);
    public List<Category> getCategory(Integer memberId);
}
