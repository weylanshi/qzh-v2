package com.huidong.qzh.portal.controller;

import com.huidong.qzh.portal.entity.EipHomeAd;
import com.huidong.qzh.portal.service.EipHomeAdService;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/homeAd")
public class EipHomeAdController {

    @Autowired
    private EipHomeAdService homeAdService;

    /**
     * 获取所有首页广告
     * @return
     */
    @RequestMapping
    public QzhResult findAllAd(){
        try {
            Map<String, List<EipHomeAd>> homeAds = homeAdService.findAllAd();
            return QzhResult.build(200,homeAds);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }
}
