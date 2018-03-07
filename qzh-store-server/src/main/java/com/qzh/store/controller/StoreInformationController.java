package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.StoreInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/storeInformation")
public class StoreInformationController {

    @Autowired
    private StoreInformationService storeInformationService;
    @Autowired
    private CommonService commonService;

    /**
     *根据storeId 获取店铺信息
     * @param storeId  店铺的id
     * @return
     */
    @RequestMapping(value = "/getStoreInformation/{storeId}",method = RequestMethod.GET)
    public QzhResult getStoreInformation(@PathVariable(value = "storeId") Integer storeId){
        try {
            Map<Object, Object> storeInfo = storeInformationService.getStoreInformation(storeId);
            return QzhResult.ok(storeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
    /**
     * 随收藏店铺实时增减数量
     * @param storeId  店铺id
     * @param status   状态：add :关注店铺数量就增加一，del:就减一
     */
    @RequestMapping("/addDelAttentionNum")
    public QzhResult addDelAttentionNum(@RequestParam(required = false) Integer storeId,
                                        @RequestParam(required = false) String status){
        try {
            storeInformationService.addDelAttentionNum(storeId,status);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

    /**
     * 通过商家ID 获取 店铺信息
     * @param memberId
     * @return
     */
    @RequestMapping("/getStore")
    public QzhResult getStoreByMemberId(@RequestParam(required = true) Integer memberId){
        try {
            return storeInformationService.getStoreByMemberId(memberId);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error("");
        }
    }

    /**
     * 通过商家ID 获取 店铺信息 并且 是否已关注
     * @param request
     * @param memberId
     * @return
     */
    @RequestMapping("/findStore")
    public QzhResult findStoreByMemberId(HttpServletRequest request,
                                         @RequestParam(required = true) Integer memberId){
        try {
            //店铺信息
            QzhResult storeByMemberId = storeInformationService.getStoreByMemberId(memberId);
            if(storeByMemberId.getStatus()!=200){
                return storeByMemberId;
            }
            StoreInformation info = (StoreInformation) storeByMemberId.getData();
            Integer storeId = info.getId();

            //是否关注
            QzhResult attentionStore = commonService.isAttentionStore(request, storeId);
            if(attentionStore.getStatus()!=200){
                return attentionStore;
            }


            Integer data = (Integer) attentionStore.getData();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("info",info);
            map.put("isAttent",data);
            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


}
