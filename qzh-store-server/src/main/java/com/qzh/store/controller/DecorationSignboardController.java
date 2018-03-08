package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.huidong.qzh.util.common.util.StringUtils;
import com.qzh.store.entity.DecorationSignboard;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationRankingService;
import com.qzh.store.service.DecorationSignboardService;
import com.qzh.store.service.SignboardPictureService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Map;

@RestController
@RequestMapping("/decorationSignboard")
public class DecorationSignboardController {
    @Autowired
    private CommonService commonService;
    @Autowired
    private DecorationSignboardService decorationSignboardService;
    @Autowired
    private SignboardPictureService signboardPictureService;
    @Autowired
    private DecorationRankingService decorationRankingService;
    /**
     *  根据商家id 获得店铺招牌信息
     * */
    @RequestMapping("/getSignboardInfo")
    public QzhResult getSignboardInfo(HttpServletRequest request){
        try{
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            DecorationSignboard decorationSignboard=decorationSignboardService.getDecorationSign(memberId);
            return QzhResult.ok(decorationSignboard);
        }catch (Exception e){
        return QzhResult.error(e.getMessage());
        }
    }

   /**
    * 保存招牌信息
    *
    * String signboradText  招牌内容,富文本框编辑的内容
    * Integer isDefault  1是默认，2是自定义
    *
    * */

   @RequestMapping("/doSaveSignboardInfo")
    public QzhResult doSaveSignboardInfo(HttpServletRequest request,
                                         MultipartFile file,
                                         String picType,
                                         DecorationSignboard decorationSignboard){
       try{
           QzhResult land = commonService.isLand(request);
           if(land.getStatus()!=200){
               return land;
           }
           Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
           Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            String signboardPictureUrl=null;
            if(decorationSignboard.getIsDefault()==null){
               return QzhResult.ok("数据不完整,无法保存！");
            }
            if(decorationSignboard.getIsDefault()==1){
                if(org.apache.commons.lang.StringUtils.isNotBlank(picType)&&file!=null){
                    QzhResult qzhResult=signboardPictureService.getSignboardPictureUrl(file,memberId,picType);
                    signboardPictureUrl=qzhResult.getData().toString();
                }else{
                    return QzhResult.ok("数据不完整,无法保存！");
                }

            }
           if(decorationSignboard.getIsDefault()==2){
               if(org.apache.commons.lang.StringUtils.isBlank(decorationSignboard.getSignboradText())){
                  return QzhResult.ok("数据不完整，无法保存！");
               }
           }
           //调用decorationRankingService接口方法获得storeid
           Integer storeId=decorationRankingService.getStoreId(memberId);
           decorationSignboard.setStoreId(storeId);
           if(signboardPictureUrl!=null){
               decorationSignboard.setSignboardPictureUrl(signboardPictureUrl);
           }
           Integer num=decorationSignboardService.doSaveSignboardInfo(decorationSignboard);
           if(num>0){
               return QzhResult.ok("保存成功！");
           }
       }catch (Exception e){
        return QzhResult.error(e.getMessage());
       }
       return QzhResult.ok("保存失败！");
   }
}