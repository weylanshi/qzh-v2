package com.huidong.qzh.nonstandard.controller;

import com.alibaba.fastjson.JSON;
import com.huidong.qzh.nonstandard.service.AttributeService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    /**
     * 根据分类名称获取分类下的属性值
     * @param className
     * @return
     */
    @RequestMapping("/getAttributeByClassName")
    public QzhResult getAttributeByClassName(@RequestParam(required = false)  String className){
        try {
            return QzhResult.ok(attributeService.getAttributeByClassName(className));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 点击分类名称获取产品详情
     * @param title
     * @return
     */
    @RequestMapping("/getProductDetail")

    public QzhResult getProductDetail(@RequestParam(required = false)  String title){
        try {
            return QzhResult.ok(attributeService.getProductDetail(title));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 根据公司id、分类名称、页面大小、克重、单双面、数量和加工工艺来获取价格
     * @param memberId
     * @param title
     * @param pageSize
     * @param weight
     * @param isDouble
     * @param amount
     * @param technic
     * @return
     */
    /*@SuppressWarnings("unchecked")*/
    @RequestMapping("/getProductPrice")

    public QzhResult getProductPrice(@RequestParam(required = false) Integer memberId,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) String pageSize,
                                      @RequestParam(required = false) String weight,
                                      @RequestParam(required = false) int isDouble,
                                      @RequestParam(required = false) int amount,
                                      @RequestParam(required = false) String technic){
        Map map = new HashMap();
        if(StringUtils.isNotBlank(technic)){
            map = JSON.parseObject(technic);
        }
        try {
            return QzhResult.ok(attributeService.getProductPrice(memberId,title,pageSize,weight,isDouble,amount,map));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


/*    @RequestMapping("/getPrice/{className}")
    public QzhResult getPrice(@PathVariable  String className){
        try {
            return QzhResult.ok(attributeService.getPrice(className));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }*/

    /**
     * 非标品新增产品
     * @param data
     * @return
     */
    @RequestMapping(path = "/insertAttribute")
    public QzhResult insertAttribute(@RequestParam(required = false)  String data){
        try {
            return QzhResult.ok(attributeService.insertAttribute(data));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 根据memberId获取产品分类
     * @param memberId
     * @return
     */
    @RequestMapping("/getCategory/{memberId}")
    public QzhResult getCategory(@PathVariable(value = "memberId") Integer memberId){
        try {
            return QzhResult.ok(attributeService.getCategory(memberId));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }

}
