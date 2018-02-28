package com.huidong.qzh.portal.controller;

import com.github.pagehelper.Page;
import com.huidong.qzh.portal.entity.Area;
import com.huidong.qzh.portal.entity.EipHomeAd;
import com.huidong.qzh.portal.entity.EipMember;
import com.huidong.qzh.portal.service.EipHomeAdService;
import com.huidong.qzh.portal.service.EipMemberService;
import com.huidong.qzh.portal.service.impl.EipHomeAdServiceImpl;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/myStore")
public class EipMemberController {

    @Autowired
    private EipMemberService memberService;

    /**
     * 获取公司列表
     * @param pca
     * @param enterpriseType
     * @param industryType
     * @param order
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/listMember")
    public QzhResult findEipMember(@RequestParam(required = false) String pca,
                                   @RequestParam(required = false)  String enterpriseType,
                                   @RequestParam(required = false) String industryType,
                                   @RequestParam(required = false) String order,
                                   @RequestParam(defaultValue = "1",required = false) Integer pageNo,
                                   @RequestParam(defaultValue = "8",required = false) Integer pageSize){
        try {
            Page<EipMember> memberPage = memberService.getEipMember(pca,enterpriseType,industryType,order,pageNo,pageSize);

            return  QzhResult.build(200, QzhPageResult.build(memberPage.getPageNum(),
                    memberPage.getPageSize(),memberPage.getTotal(),memberPage.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
            return  QzhResult.build(500,e.getMessage());
        }
    }

    /**
     * 获取公司详情
     * @param memberId
     * @return
     */
    @GetMapping("/companyIntroduce/{memberId}")
    public QzhResult companyIntroduce(@PathVariable("memberId") Integer memberId){
        try {
            HashMap<String, Object> resultMap = memberService.companyIntroduce(memberId);
            return QzhResult.build(200,resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

    /**
     * 省市区三级联动
     * @param pca
     * @return
     */
    @RequestMapping("/getPca")
    public QzhResult getPca(@RequestParam(required = false) String pca){
        try {
            List<Area> pcaList = memberService.getPca(pca);
            return QzhResult.build(200,pcaList);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }
}
