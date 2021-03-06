package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.service.CommonService;
import com.huidong.qzh.standard.service.ProductPictureService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/productPic")
public class ProductPictureController {

    @Autowired
    private ProductPictureService productPictureService;

    @Autowired
    private CommonService commonService;

    /**
     * 新增产品中  3D视图/视图/图片上传   规格图片
     * @param file
     * @return
     */
    @RequestMapping("/insert")
    public QzhResult insertPicture3D(MultipartFile file, String picType,
                                     HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
//            EipAccounts accounts = (EipAccounts)land.getData();
//            Integer memberId = accounts.getMemberId();
            Map<Object,Object> data = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(data.get("memberId").toString());
            return productPictureService.insertProPicture(file,memberId,picType);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }


    }
}
