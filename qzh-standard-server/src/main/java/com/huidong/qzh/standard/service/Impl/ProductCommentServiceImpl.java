package com.huidong.qzh.standard.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huidong.qzh.standard.entity.EipAccounts;
import com.huidong.qzh.standard.entity.ProductGoodsComment;
import com.huidong.qzh.standard.mapper.EipAccountsMapper;
import com.huidong.qzh.standard.mapper.ProductGoodsCommentMapper;
import com.huidong.qzh.standard.service.ProductCommentService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 评论列表
     * @param goodsId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> listProductComment(Integer goodsId,Integer pageNo,Integer pageSize) {
        DBCollection dbCollection = mongoTemplate.getCollection("product_comment");
        BasicDBObject query = new BasicDBObject();
        query.put("goodsId", goodsId);
        DBCursor cursor = dbCollection.find(query).sort(new BasicDBObject("createTime", -1)).skip((pageNo-1)*pageSize).limit(pageSize);
        List<DBObject> list = new ArrayList<DBObject>();
        while (cursor.hasNext()){
            DBObject next = cursor.next();
            next.put("_id",next.get("_id").toString());
            list.add(next);
        }
        int count = dbCollection.find(query).count();

        Map<String,Object> map = new HashMap<String,Object>();
//        int a = (count%pageSize==0)?0:1;
        map.put("totalNum",count);
        map.put("data",list);

        return map;
    }

//    @Override
//    public long getId() {
//        String collectionName = "product_comment";
//        DBCollection dbCollection = mongoTemplate.getCollection(collectionName);
//        dbCollection.save(new BasicDBObject().append("_id", collectionName).append("id", 1));
//        DBObject dbObj = dbCollection.findAndModify(new BasicDBObject("_id", collectionName), new BasicDBObject("$inc",
//                new BasicDBObject("id", 1)));
//        String ids = dbObj.get("id").toString();
//        return Long.parseLong(dbObj.get("id").toString());
//    }
}
