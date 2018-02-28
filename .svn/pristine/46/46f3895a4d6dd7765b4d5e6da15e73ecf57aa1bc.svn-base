package com.huidong.qzh.nonstandard.service.impl;

import com.huidong.qzh.nonstandard.entity.PrintingPrice;
import com.huidong.qzh.nonstandard.service.PrintingPriceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class PrintingPriceServiceImpl implements PrintingPriceService {
    @Autowired
    private MongoTemplate template;

    //非标品印刷价格计算
    public Double getPrintingPrice(String className, String isDouble, Integer productNum) {
        Query query = new Query();
        if (StringUtils.isNotBlank(className)) {
            query.addCriteria(Criteria.where("className").is(className));
        }
        if (StringUtils.isNotBlank(isDouble)) {
            query.addCriteria(Criteria.where("isDouble").is(isDouble));
        }
        if (null != productNum) {
            if (productNum > 5000) {
                query.addCriteria(Criteria.where("productNum").is(10000));
            } else {
                query.addCriteria(Criteria.where("productNum").is(productNum));
            }

        }
        List<PrintingPrice> printingPrices = template.find(query, PrintingPrice.class);
        double prices = 0.0;
        double totalPrice = 0.0;
        if (printingPrices.size() > 0) {
            PrintingPrice printingPrice = printingPrices.get(0);
            Integer price = printingPrice.getPrice();//价格
            Integer paperNum = printingPrice.getPaperNum();//开数
            Double singlePrice = printingPrice.getSinglePrice();//当产品数量超过5000就每张算单价

            //公式（总价/数量/开数）
            if (productNum > 5000) {
                //超过五千的算法
                Integer proNum = productNum - 5000;
                prices = singlePrice * proNum;
                //五千的算法
                prices += (double) price / 5000 / paperNum;
                totalPrice = new BigDecimal(prices).setScale(4, BigDecimal.ROUND_CEILING).doubleValue();
            } else {
                prices = (double) price / productNum / paperNum;
                totalPrice = new BigDecimal(prices).setScale(4, BigDecimal.ROUND_CEILING).doubleValue();
            }
        }

        return totalPrice;
    }

}
