package com.qzh.store.service.Impl;

import com.huidong.qzh.util.common.util.QzhResult;
import com.huidong.qzh.util.common.util.StringUtils;
import com.qzh.store.feign.FILEFeignClient;
import com.qzh.store.service.SignboardPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SignboardPictureServiceImpl implements SignboardPictureService{
    @Autowired
    private FILEFeignClient fileFeignClient;
    @Override
    public QzhResult getSignboardPictureUrl(MultipartFile file, Integer memberId, String picType) {
        try {
            if (!StringUtils.equalsNull(picType) && ("img".equals(picType) || "video".equals(picType) || "picture3D".equals(picType) || "specPic".equals(picType) || "png".equals(picType))) {
                return fileFeignClient.handFileUpload(file, "/product/storeSignboard_" + memberId + "/" + picType);
            }
        } catch (RestClientException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
        return QzhResult.error("product picture upload fail !");
    }
}
