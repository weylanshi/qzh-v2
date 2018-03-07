package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.StoreCategoryService;
import com.qzh.store.service.StoreInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/storeCategory")
public class StoreCategoryController {
    @Autowired
    private CommonService commonService;
    @Autowired
    private StoreCategoryService categoryService;
    @Autowired
    private StoreInformationService storeInformationService;

    /**
     * 获取店铺所有的店铺商品自定义分类
     * @return
     */
    @PostMapping("/list")
    public QzhResult listStoreCategory(HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
//            EipAccounts accounts = (EipAccounts) land.getData();
//            Integer memberId = accounts.getMemberId();
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());

            return categoryService.listStoreCategory(memberId);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 店铺自定义分类的新增
     * @param info
     * @return
     */
    @PostMapping("/insert")
    public QzhResult insertStoreCategory(HttpServletRequest request,
                                         @RequestParam(required = true) String info){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            QzhResult storeByMemberId = storeInformationService.getStoreByMemberId(memberId);
            if(storeByMemberId.getStatus()!=200){
                return QzhResult.build(505,"请创建店铺","");
            }
            StoreInformation storeInfo = (StoreInformation)storeByMemberId.getData();
            Integer storeId = storeInfo.getId();
            return categoryService.insertStoreCategory(info,storeId);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 删除  批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public QzhResult deleteStoreCategory(HttpServletRequest request,
                                         @RequestParam(required = true) String ids){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            return categoryService.deleteStoreCategory(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     * 上传分类的图片
     * @param request
     * @param file
     * @return
     */
    @PostMapping("/uploadPic")
    public QzhResult insertStoreCategoryPic(MultipartFile file,HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> data = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(data.get("memberId").toString());
            return categoryService.insertStoreCategoryPic(file,memberId);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
}
