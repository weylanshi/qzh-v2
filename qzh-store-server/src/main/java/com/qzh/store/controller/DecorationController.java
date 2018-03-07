package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/store")
public class DecorationController {
    @Autowired
    private DecorationService decorationService;
    @Autowired
    private CommonService commonService;

    /**
     * 备份店铺模板
     * @param request      请求的登陆信息
     * @param leftSort     左边装修模块的顺序     例如 'customer,search,category,ranking'
     * @param rightSort    右边装修模块的顺序
     * @return
     */
    @RequestMapping("/insertDecoration")
    public QzhResult insertDecoration(HttpServletRequest request,
                                      @RequestParam(required = false) String leftSort,
                                      @RequestParam(required = false) String rightSort,
                                      @RequestParam(required = false) Integer decorationId){

        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());
            int memberId = Integer.parseInt(land_map.get("memberId").toString());
            String result = decorationService.insertDecoration(accountId, memberId, leftSort, rightSort,decorationId);
            return QzhResult.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }

    }

    /**
     *发布店铺模板
     * @param decorationId  店铺装修id
     * @param isPublish     是否发布 0：是未发布；1是发布
     * @return
     */
    @RequestMapping("/updateDecoration")
    public QzhResult updateDecoration(HttpServletRequest request,
                                      @RequestParam(required = false) Integer decorationId,
                                      @RequestParam(required = false) Integer isPublish){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            decorationService.updateDecoration(decorationId,isPublish);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

}
