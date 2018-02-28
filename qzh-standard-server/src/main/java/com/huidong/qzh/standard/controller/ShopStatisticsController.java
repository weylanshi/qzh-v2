package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.entity.ShopStatistics;
import com.huidong.qzh.standard.service.ShopStatisticsService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/shopStatistics")
public class ShopStatisticsController {

    @Autowired
    private ShopStatisticsService shopStatisticsService;

    @RequestMapping("/shopStatistics")
    public QzhResult shopStatisticsByMemberId(@RequestParam(required = true) Integer memberId){
        try {
            Map<Object,Object> map = shopStatisticsService.shopStatisticsByMemberId(memberId);
            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }

}
