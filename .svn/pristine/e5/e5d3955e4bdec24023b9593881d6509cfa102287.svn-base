package com.huidong.qzh.portal.controller;/*
 * @Author: xingyibiao
 * @Date:    2017/12/22 14:42
 * @Last Modified by:   weylan
 * @Last Modified time:  2017/12/22 14:42
 */

import com.huidong.qzh.portal.entity.ApMember;
import com.huidong.qzh.portal.service.ApAlbumService;
import com.huidong.qzh.portal.service.ApMemberService;
import com.huidong.qzh.portal.service.ApShopNewsService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myStore")
public class HomePageController {

    @Autowired
    private ApMemberService apMemberService;

    @Autowired
    private ApAlbumService apAlbumService;

    @Autowired
    private ApShopNewsService apShopNewsService;


    @GetMapping("/productIntroduce/{memberId}")
    public QzhResult productIntroduce(@PathVariable Integer memberId){
        try {
            ApMember member = apMemberService.getApMemberById(memberId);

            String facadeImg = member.getFacadeimg();
            if(StringUtils.isNotBlank(facadeImg)&&(facadeImg.indexOf("/")!=1)){
                facadeImg=facadeImg.replace("//","/");
                member.setFacadeimg(facadeImg);
            }
            String logo = member.getLogo();
            if(StringUtils.isNotBlank(logo)&&(logo.indexOf("/")!=1)){
                logo = logo.replace("//","/");
                member.setLogo(logo);
            }
            String shopimgs = member.getShopimgs();
            if(StringUtils.isNotBlank(shopimgs)){
                shopimgs = shopimgs.replaceAll("//","/");
                member.setShopimgs(shopimgs);
            }
            return QzhResult.build(200,member);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

    @GetMapping("/photo/{memberId}")
    public QzhResult getMemberPhoto(@PathVariable Integer memberId,
                                        @RequestParam(defaultValue = "1") Integer pageNo,
                                        @RequestParam(defaultValue = "8") Integer pageSize){
        try {
            QzhPageResult result = apAlbumService.getMemberPhoto(memberId, pageNo, pageSize);
            return QzhResult.build(200,result);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

    @GetMapping("/productDynamic/{memberId}/{newsClassification}")
    public QzhResult getDynamic(@PathVariable Integer memberId,
                                @PathVariable String newsClassification,
                                @RequestParam(defaultValue = "1") Integer pageNo,
                                @RequestParam(defaultValue = "8") Integer pageSize){
        try {
            QzhPageResult news = apShopNewsService.getNewsByMemberAndClass(memberId, newsClassification, pageNo, pageSize);

            return QzhResult.build(200,news);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }


    @GetMapping("/enterpriseList")
    public QzhResult enterpriseList(@RequestParam(defaultValue = "1") Integer pageNo,
                                    @RequestParam(defaultValue = "8") Integer pageSize){

        try {
            QzhPageResult enterpriseList = apMemberService.getEnterpriseList(pageNo, pageSize);
            return QzhResult.build(200,enterpriseList);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

}
