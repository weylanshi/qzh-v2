package com.huidong.qzh.portal.controller;

import com.huidong.qzh.portal.entity.IndustryType;
import com.huidong.qzh.portal.service.IndustryTypeService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/industry")
public class IndustryTypeController {

    @Autowired
    private IndustryTypeService industryTypeService;

    @GetMapping("/listFirstLv")
    public QzhResult listFirstLvIndustry(){
        try {
            List<IndustryType> firstLv = industryTypeService.listFirstLv();
            return QzhResult.build(200,firstLv);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

    @GetMapping("/listSecondLv/{firstLv}")
    public QzhResult listSecondLvIndustry(@PathVariable String firstLv){
        try {
            List<IndustryType> secondLv = industryTypeService.listSecondLv(firstLv);
            return QzhResult.build(200,secondLv);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

}
