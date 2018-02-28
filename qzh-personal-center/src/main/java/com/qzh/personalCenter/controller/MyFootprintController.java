package com.qzh.personalCenter.controller;

import com.huidong.qzh.util.common.annotation.LoginRequired;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.personalCenter.service.CommonService;
import com.qzh.personalCenter.service.MyFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/myFootprint")
public class MyFootprintController {
    @Autowired
    private MyFootprintService myFootprintService;
    @Autowired
    private CommonService commonService;

    /**
     * 获取 会员 所有的记录  浏览商品的
     * @return
     */
    @PostMapping("/list")
    public QzhResult listMyFootprint(HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return  land;
            }
            Map<String,Object> land_map = (Map<String,Object>)land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());

            List list = myFootprintService.listMyFootprint(accountId);
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 新增 浏览商品的记录
     * @param goodsId
     * @return
     */
    @PostMapping("/add")
    public QzhResult addMyFootprint(HttpServletRequest request,
                                    @RequestParam(required = true) Integer goodsId){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return  land;
            }
            Map<String,Object> land_map = (Map<String,Object>)land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());

            myFootprintService.addMyFootprint(accountId,goodsId);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 删除
     * @param ids  以逗号隔开
     */
    @LoginRequired
    @RequestMapping("/delete")
    public QzhResult deleteMyFootprint(@RequestParam(required = true) String ids){
        try {
            myFootprintService.deleteMyFootprint(ids);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    @RequestMapping("/test")
    public  QzhResult getTest(@RequestParam(required = true) Integer productId){
        RestTemplate restTemplate = new RestTemplate();                             //:8100/standard
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://localhost:8850/product/price2StockById?productId={1}", QzhResult.class, productId);
        QzhResult body = responseEntity.getBody();
        return body;
    }

    @RequestMapping("/test2")
    public  QzhResult getTest2(@RequestParam(defaultValue = "1",required = false) Integer pageNo,
                               @RequestParam(defaultValue = "12",required = false) Integer pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        RestTemplate restTemplate = new RestTemplate();                             //:8100/standard
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://localhost:8850/productGoods/hotSell?pageNo={pageNo}&pageSize={pageSize}", QzhResult.class, map);
        QzhResult body = responseEntity.getBody();
        return body;
    }

}
