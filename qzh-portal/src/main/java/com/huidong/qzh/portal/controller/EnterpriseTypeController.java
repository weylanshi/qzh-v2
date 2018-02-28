package com.huidong.qzh.portal.controller;


import com.huidong.qzh.portal.entity.EnterpriseType;
import com.huidong.qzh.portal.service.EnterpriseTypeService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseTypeController {

    @Autowired
    private EnterpriseTypeService enterpriseTypeService;

    @GetMapping("/listNames")
    public QzhResult listNames(){
        try {
            //获取企业类型
            List<EnterpriseType> enterpriseTypeList = enterpriseTypeService.listNames();
            return QzhResult.build(200,enterpriseTypeList);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }


}
