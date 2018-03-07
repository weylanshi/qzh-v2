package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.DecorationBanner;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/decorationBanner")
public class DecorationBannerController {

    @Autowired
    private DecorationBannerService decorationBannerService;
    @Autowired
    private CommonService commonService;
    /**
     *插入轮播图片的内容
     * @param request     公司id
     * @param pictrueInfo 图片信息
     * @param decorationBannerId 店铺轮播图片id
     */
    @RequestMapping("/insertBanner")
    public QzhResult  insertBanner( HttpServletRequest request,
                                    @RequestParam(required = false) String pictrueInfo,
                                    @RequestParam(required = false) Integer decorationBannerId){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            int memberId = Integer.parseInt(land_map.get("memberId").toString());
            String banner = decorationBannerService.insertBanner(memberId, pictrueInfo, decorationBannerId);
            return QzhResult.ok(banner);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }
    /**
     * 根据店铺id查询数据
     * @param storeId  店铺id
     * @return
     */
    @RequestMapping("/listBanner")
    public QzhResult listBanner(@RequestParam(required = false) Integer storeId){
        try {
            List<DecorationBanner> list = decorationBannerService.bannerList(storeId);
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }
    /**
     *
     * @param request           获取公司id
     * @param title              轮播名称
     * @param isShowTitle        是否展示名称
     * @param effect              切换效果，1上下滚动，2渐变滚动
     * @param decorationBannerId  店铺导航栏id
     * @return
     */
    @RequestMapping("/insertDisplay")
    public QzhResult insertDisplay(HttpServletRequest request,
                                   @RequestParam(required = false) String title,
                                   @RequestParam(required = false) Integer isShowTitle,
                                   @RequestParam(required = false) Integer effect,
                                   @RequestParam(required = false) Integer decorationBannerId){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            int memberId = Integer.parseInt(land_map.get("memberId").toString());
            String display = decorationBannerService.insertDisplay(memberId, title, isShowTitle, effect, decorationBannerId);
            return QzhResult.ok(display);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }
}
