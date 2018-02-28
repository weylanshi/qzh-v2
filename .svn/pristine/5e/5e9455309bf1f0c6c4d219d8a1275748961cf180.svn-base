package com.qzh.store.service;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.web.multipart.MultipartFile;


public interface StoreCategoryService {

    /**
     * 获取店铺所有的店铺商品自定义分类
     * @return
     */
    QzhResult listStoreCategory(Integer memberId);

    /**
     * 店铺自定义分类的新增   / 修改  排序
     * @param info
     * @return
     */
    QzhResult insertStoreCategory(String info,Integer storeId);

    /**
     * 删除  批量删除
     * @param ids
     * @return
     */
    QzhResult deleteStoreCategory(String ids);

    /**
     * 上传分类的图片
     * @param file
     * @param memberId
     * @return
     */
    QzhResult insertStoreCategoryPic(MultipartFile file, Integer memberId);



}
