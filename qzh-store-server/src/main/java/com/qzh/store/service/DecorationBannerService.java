package com.qzh.store.service;

import com.qzh.store.entity.DecorationBanner;

import java.util.List;

public interface DecorationBannerService {
    /**
     *插入轮播图片的内容
     * @param memberId     公司id
     * @param pictrueInfo 图片信息
     */
    String  insertBanner(Integer memberId,String pictrueInfo,Integer decorationBannerId);
    /**
     * 根据店铺id查询数据
     * @param storeId  店铺id
     * @return
     */
    List<DecorationBanner> bannerList(Integer storeId);
    /**
     *
     * @param memberId           公司id
     * @param title              轮播名称
     * @param isShowTitle        是否展示名称
     * @param effect              切换效果，1上下滚动，2渐变滚动
     * @param decorationBannerId  店铺导航栏id
     * @return
     */
    String insertDisplay(Integer memberId,String title,Integer isShowTitle,Integer effect,Integer decorationBannerId);
}
