package com.huidong.qzh.standard.service;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.web.multipart.MultipartFile;

public interface ProductPictureService {

    /**
     * 新增产品中  3D视图/视图/图片上传    规格图片
     * @param file
     * @return
     */
    QzhResult insertProPicture(MultipartFile file, Integer memberId, String picType);



}
