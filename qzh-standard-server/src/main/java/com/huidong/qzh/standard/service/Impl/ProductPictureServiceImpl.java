package com.huidong.qzh.standard.service.Impl;

import com.huidong.qzh.standard.feign.FILEFeignClient;
import com.huidong.qzh.standard.service.ProductPictureService;
import com.huidong.qzh.util.common.util.QzhResult;
import com.huidong.qzh.util.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductPictureServiceImpl implements ProductPictureService {


    @Autowired
    private FILEFeignClient fileFeignClient;

    /**
     * 新增产品中  3D视图/视图/图片上传   规格图片
     *
     * @param file
     * @return
     */
    @Override
    public QzhResult insertProPicture(MultipartFile file, Integer memberId, String picType) {
        try {
            if (!StringUtils.equalsNull(picType) && ("img".equals(picType) || "video".equals(picType) || "picture3D".equals(picType) || "specPic".equals(picType))) {
                return fileFeignClient.handFileUpload(file, "/product/product_" + memberId + "/" + picType);
            }
        } catch (RestClientException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
        return QzhResult.error("product picture upload fail !");
    }


}
