package com.huidong.qzh.nonstandard.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huidong.qzh.nonstandard.entity.Attribute;
import com.huidong.qzh.nonstandard.entity.Category;
import com.huidong.qzh.nonstandard.service.AttributeService;
import com.huidong.qzh.nonstandard.utils.PaperPriceUtil;
import com.huidong.qzh.util.common.util.QzhFunc;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public DBObject getAttributeByClassName(String className) {
        DBCollection collection = mongoTemplate.getCollection("attribute");
        BasicDBObject query = new BasicDBObject();
        query.put("className", className);

        DBObject dbObject = collection.findOne(query);
        return dbObject;
    }

    public DBObject getProductDetail(String title) throws ScriptException {
        DBCollection collection = mongoTemplate.getCollection("advertisingPage");
        BasicDBObject query = new BasicDBObject();

        query.put("title", title);
        DBObject dbObject = collection.findOne(query);
        BasicDBObject basicDBObject = (BasicDBObject) dbObject;
        return dbObject;
    }

    public BigDecimal getProductPrice(Integer memberId, String title, String pageSize, String weight, int isDouble, int amount, Map<String, Integer> selectedTech) throws Exception {
        DBCollection collection = mongoTemplate.getCollection("advertisingPage");
        BasicDBObject query = new BasicDBObject();
        query.put("memberId", memberId);
        query.put("title", title);
        DBObject dbObject = collection.findOne(query);
        if (dbObject == null) {
            throw new Exception("未查询到报价");
        }
        BasicDBObject basicDBObject = (BasicDBObject) dbObject;
        //获取材料的总价
        BigDecimal materialPrice = this.getMaterialPrice(basicDBObject, pageSize, weight, amount);
        System.out.println("材料总价:  " + materialPrice);
        //获取打印的总价
        BigDecimal printPrice = this.getPrintPrice(basicDBObject, pageSize, isDouble, amount);
        System.out.println("印刷总价:  " + printPrice);
        BigDecimal technicalPrice = this.getTechnicalPrice(basicDBObject, amount, selectedTech);
        System.out.println("工艺总价 : " + technicalPrice);
        return materialPrice.add(printPrice).add(technicalPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获取材料价格
     *
     * @param productDetail 材料MongoDb数据
     * @param pageSize      页面的大小
     * @param weight        页面的重量
     * @return 材料总价
     */
    private BigDecimal getMaterialPrice(BasicDBObject productDetail, String pageSize, String weight, int amount) throws ScriptException {
        String materials = productDetail.getString("material");
        JSONObject material = JSON.parseObject(materials);
        JSONArray kinds = material.getJSONArray("kind");
        BigDecimal priceBase = new BigDecimal(0);
        for (int i = 0; i < kinds.size(); i++) {
            JSONObject kind = kinds.getJSONObject(i);
            JSONArray prices = kind.getJSONArray("prices");
            for (int j = 0; j < prices.size(); j++) {
                JSONObject price = prices.getJSONObject(j);
                String dbWeight = price.getString("weight");
                if (StringUtils.equalsIgnoreCase(weight, dbWeight)) {
                    priceBase = price.getBigDecimal("price");
                    break;
                }
            }
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String expression = priceBase + "*" + weight + "*" + pageSize + "/(Math.pow(10,6)*Math.pow(10,6))*" + amount;
        System.out.println("材料公式:  " + expression);
        Object result = engine.eval(expression);
        return QzhFunc.strToBigDecimal(result + "");
    }

    private BigDecimal getPrintPrice(BasicDBObject productDetail, String pageSize, int isDouble, int amount) throws Exception {
        BigDecimal basePrice = new BigDecimal(0);
        int overLineAmount = 0;
        double overLineBase = 1;
        String printPriceStr = productDetail.getString("printPrice");
        JSONObject printPrices = JSONObject.parseObject(printPriceStr);
        JSONArray kind = printPrices.getJSONArray("kind");
        // JSONArray printPrices = JSON.parseArray(printPriceStr);
        for (int i = 0; i < kind.size(); i++) {
            JSONObject printPrice = kind.getJSONObject(i);
            Integer dbIsDouble = printPrice.getInteger("isDouble");
            if (dbIsDouble != null && isDouble == dbIsDouble) {
                JSONArray prices = printPrice.getJSONArray("prices");
                //获取基础价格
                basePrice = this.judgeBasePriceByAmount(prices, amount);
                //判断购买数量是否高于上限
                Integer lineAmount = printPrice.getInteger("lineAmount");
                if (amount > lineAmount) {
                    overLineAmount = amount - lineAmount;
                    overLineBase = printPrice.getDouble("linePrice");
                    break;
                }
            }
        }
        if (basePrice.equals(new BigDecimal(0))) {
            throw new Exception("印刷基础价格未找到!");
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        int open = PaperPriceUtil.getOpenBySize(pageSize);
        String expression;
        if (overLineAmount > 0) {
            int inLineAmount = amount - overLineAmount;
            expression = overLineAmount + "*" + overLineBase + "+" + basePrice + "*" + inLineAmount + "/" + open + "/" + 2 + "*" + amount;
        } else {
            expression = basePrice + "/" + (this.judgeAmount(amount)) + "/" + open + "/" + 2 + "*" + amount;
        }
        System.out.println("印刷公式:  " + expression);
        Object result = engine.eval(expression);
        return QzhFunc.strToBigDecimal(result + "");
    }

    private BigDecimal getTechnicalPrice(BasicDBObject productDetail, int amount, Map<String, Integer> selectedTech) {
        HashMap<String, BigDecimal> techPrices = new HashMap<>();
        String techStr = productDetail.getString("technic");
        JSONObject jsonObject = JSONObject.parseObject(techStr);
        JSONArray kind = jsonObject.getJSONArray("kind");
        //JSONArray techs = JSON.parseArray(techStr);
        for (int i = 0; i < kind.size(); i++) {
            JSONObject tech = kind.getJSONObject(i);
            String dbTechCode = tech.getString("code");
            selectedTech.forEach((techCode, num) -> {
                if (StringUtils.equalsIgnoreCase(dbTechCode, techCode)) {
                    if (num > 0) {
                        JSONArray prices = tech.getJSONArray("prices");
                        BigDecimal techPrice = this.judgeBasePriceByAmount(prices, amount);
                        if (num > 1) {//如压痕,有压两道痕,压一道痕
                            BigDecimal addOnePrice = tech.getBigDecimal("addOnePrice");
                            BigDecimal addPrice = addOnePrice.multiply(new BigDecimal(num - 1));
                            techPrices.put(techCode, techPrice.add(addPrice));
                        } else {
                            techPrices.put(techCode, techPrice);
                        }
                    }
                }
            });
        }
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<String, BigDecimal> entry : techPrices.entrySet()) {
            String code = entry.getKey();
            BigDecimal price = entry.getValue();
            BigDecimal oneTechPrice = price.multiply(new BigDecimal(amount));
            System.out.println(code + " 工艺计算公式  :   " + price + "*" + amount + "=    " + oneTechPrice);
            totalPrice = totalPrice.add(oneTechPrice);
        }
        return totalPrice;
    }

    private int judgeAmount(int amount) {
        int baseAmount = 5000;
        if (amount <= 500) {
            baseAmount = 500;
        } else if (amount <= 1000) {
            baseAmount = 1000;
        } else if (amount <= 2000) {
            baseAmount = 2000;
        } else if (amount <= 3000) {
            baseAmount = 3000;
        } else if (amount <= 5000) {
            baseAmount = 5000;
        }
        return baseAmount;
    }

    /**
     * 根据购买数量查询基础价格,购买数量超过设置的最大的数量,则按最大的数量计算
     *
     * @param prices
     * @param amount
     * @return
     */
    private BigDecimal judgeBasePriceByAmount(JSONArray prices, int amount) {
        int maxAmount = 0;
        BigDecimal maxBasePrice = new BigDecimal(0);
        BigDecimal basePrice = new BigDecimal(0);
        for (int j = 0; j < prices.size(); j++) {
            JSONObject price = prices.getJSONObject(j);
            Integer dbAmount = price.getInteger("amount");
            if (maxAmount < dbAmount) {
                maxAmount = dbAmount;
                maxBasePrice = price.getBigDecimal("price");
            }
            if (this.judgeAmount(amount) == dbAmount) {
                basePrice = price.getBigDecimal("price");
                break;
            }
        }
        if (basePrice.equals(new BigDecimal(0))) {
            return maxBasePrice;
        }
        return basePrice;
    }


    /**
     * 新增宣传单页的产品详情页
     * @param data
     * @return
     */
    public String insertAttribute(String data){
        DBCollection collection = mongoTemplate.getCollection("advertisingPage");
        JSONObject json = JSONObject.parseObject(data);
        BasicDBObject parse = BasicDBObject.parse(json.toString());
        collection.insert(parse);
        return "ok";
    }

    /**
     * 根据memberId拿到该公司所发布产品的分类
     * @param memberId
     * @return
     */
    public List<Category> getCategory(Integer memberId){
        //分类表
        DBCollection collection = mongoTemplate.getCollection("category");
        List<Category> categoryList = new ArrayList<>();
        List<Attribute> list = getCompanyCategory(memberId);
        DBObject object = null;
        BasicDBObject basicDBObject = null;
        if(list.size()>0&&null!=list){
            for (Attribute attribute : list) {
                Category category = new Category();
                String className = attribute.getClassName();
                BasicDBObject query = new BasicDBObject();
                //拿到分类名称查出parentId
                query.put("categoryName", className);
                object = collection.findOne(query);
                basicDBObject = (BasicDBObject) object;
                int parentId = basicDBObject.getInt("parentId");
                int id = basicDBObject.getInt("_id");
                //根据parentId查出父分类名称
                BasicDBObject query2 = new BasicDBObject();
                query2.put("_id", parentId);
                object =  collection.findOne(query2);
                basicDBObject = (BasicDBObject) object;
                String parentCategory = basicDBObject.getString("categoryName");
                //将数据放入实体类中
                String title = attribute.getTitle();
                if(StringUtils.isNotBlank(title)){
                    category.setChildCategory(title);
                }else{
                    category.setChildCategory(className);
                }
                category.setParentCategory(parentCategory);
                category.setId(id);
                categoryList.add(category);
            }
        }
        return categoryList;
    }

    public List<Attribute> getCompanyCategory(Integer memberId){
        //产品详情表
        DBCollection collection = mongoTemplate.getCollection("advertisingPage");
        //
        DBCollection collection2 = mongoTemplate.getCollection("businessCard");
        BasicDBObject query = new BasicDBObject();
        if(null!=memberId){
            query.put("memberId", memberId);
        }
        DBCursor dbCursor = collection.find(query);
        DBCursor objects = collection2.find(query);
        List<Attribute> list = new ArrayList<>();
        while(dbCursor.hasNext()){
            Attribute attribute = new Attribute();
            BasicDBObject dbObject = (BasicDBObject) dbCursor.next();
            //拿到指定的几个字段
            int memberId1 = dbObject.getInt("memberId");
            String className = dbObject.getString("className");
            String title = dbObject.getString("title");
            attribute.setMemberId(memberId1);
            attribute.setClassName(className);
            attribute.setTitle(title);
            list.add(attribute);
        }
        while (objects.hasNext()){
            Attribute attribute = new Attribute();
            BasicDBObject dbObject = (BasicDBObject) objects.next();
            //拿到指定的几个字段
            int memberId1 = dbObject.getInt("memberId");
            String className = dbObject.getString("className");
            String title = dbObject.getString("title");
            attribute.setMemberId(memberId1);
            attribute.setClassName(className);
            attribute.setTitle(title);
            list.add(attribute);
        }

        return list;
    }


}
