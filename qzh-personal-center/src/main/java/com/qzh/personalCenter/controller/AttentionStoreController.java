package com.qzh.personalCenter.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.personalCenter.service.AttentionStoreService;
import com.qzh.personalCenter.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/attentionStore")
public class AttentionStoreController {

    @Autowired
    private AttentionStoreService attentionStoreService;
    @Autowired
    private CommonService commonService;

    /**
     * 关注店铺
     *
     * @param storeId
     * @return
     */
    @RequestMapping("/insert")
    public QzhResult insertAttentionStore(HttpServletRequest request,
                                          @RequestParam(required = true) Integer storeId) {
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());

            attentionStoreService.insertAttentionStore(accountId, storeId);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 分页获取关注店铺数据
     *
     * @param pageNo   第几页
     * @param pageSize 一页多少条数据
     * @return
     */
    @RequestMapping("/select")
    public QzhResult listAttentionStore(HttpServletRequest request,
                                        @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                        @RequestParam(required = false,defaultValue = "10") Integer pageSize) {

        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());

            return attentionStoreService.listAttentionStore(accountId, pageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * ids:是关注店铺表的id，删除多个id时，以逗号隔开
     *
     * @param ids 例如（1，2，3）
     */
    @RequestMapping("/delet")
    public QzhResult deletAttentionStore(@RequestParam(required = true) String ids) {
        try {
            attentionStoreService.deletAttentionStore(ids);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

    /**
     * 判断是否关注店铺  0 未关注   1 已关注
     *
     * @param storeId
     * @return
     */
    @RequestMapping("/isAttentionStore")
    public QzhResult isAttentionStore(HttpServletRequest request,
                                      @RequestParam(required = true) Integer storeId) {
        Integer attentionStore = 0;
        try {
            String token = request.getHeader("QZH_TOKEN");
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return QzhResult.ok(attentionStore);
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());
            attentionStore = attentionStoreService.isAttentionStore(accountId, storeId);
            return QzhResult.ok(attentionStore);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 判断是否关注店铺  0 未关注   1 已关注
     *
     * @param storeId
     * @return
     */
    @RequestMapping("/isAttention")
    public QzhResult isAttentionStore(@RequestParam(required = true) Integer accountId,
                                      @RequestParam(required = true) Integer storeId) {
        Integer attentionStore = 0;
        try {
            if(accountId!=null){
                attentionStore = attentionStoreService.isAttentionStore(accountId, storeId);
            }
            return QzhResult.ok(attentionStore);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
}
