package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.service.StoreInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/storeInformation")
public class StoreInformationController {

    @Autowired
    private StoreInformationService storeInformationService;
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

}
