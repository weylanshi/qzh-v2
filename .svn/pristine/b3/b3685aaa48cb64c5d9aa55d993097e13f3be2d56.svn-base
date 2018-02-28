package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.service.ProductCommentService;
import com.huidong.qzh.standard.util.MongoIDGenerator;
import com.huidong.qzh.util.common.util.QzhResult;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productComment")
public class ProductCommentContronller {

    @Autowired
    private ProductCommentService productCommentService;

    @RequestMapping("/getId")
    public QzhResult get_id(){
        //long id = productCommentService.getId();

        MongoIDGenerator mongoIDGenerator = new MongoIDGenerator();
        long id = mongoIDGenerator.generateId("product_comment");

        return QzhResult.ok(id);
    }

    /**
     * 评论列表
     * @param goodsId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/listComment")
    public QzhResult listProductComment(@RequestParam(required = true) Integer goodsId,
                                        @RequestParam(defaultValue = "1",required = true) Integer pageNo,
                                        @RequestParam(defaultValue = "1",required = true) Integer pageSize){
        try {
            Map<String, Object> map = productCommentService.listProductComment(goodsId, pageNo, pageSize);
            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
    
    
    
    
    
}
