package com.huidong.qzh.nonstandard.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huidong.qzh.nonstandard.service.BusinessCardService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


@Service
public class BusinessCardServiceImpl implements BusinessCardService {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 新增名片的产品详情页
     * @param data
     * @return
     */
    public String insertBusinessCard(String data){
        DBCollection collection = mongoTemplate.getCollection("businessCard");
        JSONObject json = JSONObject.parseObject(data);
        BasicDBObject parse = BasicDBObject.parse(json.toString());
        collection.insert(parse);
        return "ok";
    }

    /**
     *
     * @param materialName  材料名称
     * @param productNum    产品数量
     * @param selectedTech    所选择的所有工艺类型 {"at":1,"ty":0}
     * @param memberId      公司Id
     * @param title        公司自定义分类名称
     * @return
     */
    public BigDecimal getBusinessCardPrices(String title,Integer memberId,String materialName,Integer productNum,Map<String, Integer> selectedTech) {
        BigDecimal businessCardPrices = new BigDecimal(0.0);
        DBCollection collection = mongoTemplate.getCollection("businessCard");

        BasicDBObject query = new BasicDBObject();
        query.put("memberId", memberId);
        query.put("title",title);
        DBObject object = collection.findOne(query);
        if (object == null) {
            try {
                throw new Exception("未查询到报价");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BasicDBObject basicDBObject = (BasicDBObject) object;


        //根据材料名称拿到该产品的单价
        BigDecimal materialPrices = this.getMaterialPrices(basicDBObject, materialName,productNum);

        BigDecimal technicPrice = this.getTechnicPrice(basicDBObject, selectedTech, productNum);

        businessCardPrices = technicPrice.add(materialPrices);
        System.out.println("名片的价格："+businessCardPrices);
        return businessCardPrices;
    }

    /**
     * 根据材料名称拿到该产品的单价
     * @param basicDBObject  获取的详情
     * @param materialName   材料名称
     */
    public BigDecimal getMaterialPrices(BasicDBObject basicDBObject,String materialName,Integer productNum){
        String material = basicDBObject.getString("material");
        JSONObject materials = JSON.parseObject(material);
        JSONArray kinds = materials.getJSONArray("kind");
        BigDecimal prices = new BigDecimal(0);
        for (int i = 0; i < kinds.size(); i++) {
            JSONObject jsonObject = kinds.getJSONObject(i);
            String materialName1 = jsonObject.getString("materialName");
            if(materialName1.equals(materialName)){
                prices = jsonObject.getBigDecimal("prices");
            }
        }
        //材料的单价跟数量已经相乘
       BigDecimal produtNumber = new BigDecimal(productNum);
       BigDecimal multiply = produtNumber.multiply(prices);
        System.out.println("产品数量："+produtNumber+" 材料价格："+prices+" 总的材料价格："+multiply);
        return  multiply;
    }

    /**
     *
     * @param basicDBObject  获取的详情
     * @param selectedTech  选择的工艺种类 例如{"at":0,"ty":1 }
     * @param productNum  产品数量
     * @return
     */
    public BigDecimal getTechnicPrice(BasicDBObject basicDBObject,Map<String, Integer> selectedTech,Integer productNum){

        String technic = basicDBObject.getString("technic");
        JSONObject jsonObject = JSONObject.parseObject(technic);
        JSONArray kind = jsonObject.getJSONArray("kind");
        BigDecimal platePrice = new BigDecimal(0);//是否带铜板的价格
        BigDecimal technicPrice = new BigDecimal(0);//加工工艺的单价
        BigDecimal productNums = new BigDecimal(productNum); //产品数量

        for (int i = 0; i < kind.size(); i++) {
            JSONObject object = kind.getJSONObject(i);
            String dbTechCode = object.getString("code");
            Set entries = selectedTech.entrySet();
            Iterator iterator = entries.iterator();
            while(iterator.hasNext()){
                Map.Entry  mapentry = (Map.Entry)   iterator.next();
                String techCode = mapentry.getKey().toString();
                Integer isPlates =(Integer) mapentry.getValue();
                if (StringUtils.equalsIgnoreCase(dbTechCode, techCode)) {

                    if(StringUtils.equals(techCode,"at")){
                        JSONArray kindPrices = object.getJSONArray("kindPrices");
                        for (int j = 0; j < kindPrices.size(); j++) {
                            JSONObject pricesJSONObject = kindPrices.getJSONObject(j);
                            Integer isPlate = pricesJSONObject.getInteger("isPlate");
                            if(isPlate==isPlates){
                                platePrice = pricesJSONObject.getBigDecimal("price").add(platePrice);
                            }
                        }
                    }else if(StringUtils.equals(techCode,"ty")){
                        JSONArray kindPrices = object.getJSONArray("kindPrices");
                        for (int j = 0; j < kindPrices.size(); j++) {
                            JSONObject pricesJSONObject = kindPrices.getJSONObject(j);
                            Integer isPlate = pricesJSONObject.getInteger("isPlate");
                            if(isPlate==isPlates){
                                platePrice = pricesJSONObject.getBigDecimal("price").add(platePrice);
                            }
                        }
                    }
                        technicPrice = object.getBigDecimal("prices").add(technicPrice);


                    System.out.println("technicPrice:"+technicPrice);
                    System.out.println("platePrice:"+platePrice);
                }
            }

        }
        BigDecimal bigDecimal = technicPrice.multiply(productNums).add(platePrice);

        System.out.println("产品数量："+productNums+" 加工工艺价格："+platePrice+" 总的加工工艺价格："+bigDecimal);
        return bigDecimal;
    }

    public DBObject getBusinessCard(String title,Integer memberId) {
        DBCollection collection = mongoTemplate.getCollection("businessCard");
        BasicDBObject query = new BasicDBObject();

        query.put("title", title);
        query.put("memberId",memberId);
        DBObject dbObject = collection.findOne(query);
       // BasicDBObject basicDBObject = (BasicDBObject) dbObject;
        return dbObject;
    }


}
