package com.huidong.qzh.standard.controller;

import com.huidong.qzh.standard.entity.EipAccounts;
import com.huidong.qzh.standard.service.CommonService;
import com.huidong.qzh.standard.service.ProductService;
import com.huidong.qzh.util.common.annotation.LoginRequired;
import com.huidong.qzh.util.common.constant.LoginStatus;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommonService commonService;

    /**
     * 通过productID获取价格 库存
     * @return
     */
    @RequestMapping("/price2StockById")
    public QzhResult price2StockByProductId(@RequestParam(required = true) Integer productId){
        try {
            Map<Object, Object> map = productService.price2StockByProductId(productId);
            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 新增产品
     * @param info
     * @return
     */
    @LoginRequired
    @PostMapping("/insert")
    public QzhResult insertProductPublishInfo(@RequestParam(required = true) String info,
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
            String s = productService.insertProductPublishInfo(info,memberId);
            return QzhResult.ok(s);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

}
