package com.huidong.qzh.market.controller;

import com.huidong.qzh.market.service.MarketClassService;
import com.huidong.qzh.market.service.MarketPcService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketClass")
public class MarketClassController {
    @Autowired
    private MarketClassService marketClassService;

    /**
     * 获取产业商圈首页上的分类   pc端
     * @return
     */
    @RequestMapping("/list")
    public QzhResult listMarketClass(){
        try {
            QzhResult qzhResult = marketClassService.listMarketClass();
            return qzhResult;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }




}
