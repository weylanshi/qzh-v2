package com.qzh.store.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.entity.DecorationCustomer;
import com.qzh.store.service.CommonService;
import com.qzh.store.service.DecorationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/decorationCustomer")
public class DecorationCustomerController {

    @Autowired
    private DecorationCustomerService decorationCustomerService;
    @Autowired
    private CommonService commonService;

    /**
     *
     * @param info       info：{"workTime1":"周日"}
     */
    @RequestMapping("/insertDecorationCustomer")
    public QzhResult insertDecorationCustomer(HttpServletRequest request,
                                              @RequestParam(required = false) String info,
                                              @RequestParam(required = false) Integer decorationCustomerId){
        try {
            QzhResult land = commonService.isLand(request);
            if(land.getStatus()!=200){
                return land;
            }
            Map<Object,Object> eipMap = (Map<Object,Object>)land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            decorationCustomerService.insertDecorationCustomer(info,memberId,decorationCustomerId);
            return QzhResult.ok();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

    /**
     * 根据店铺id获取客服中心的信息
     * @param storeId  店铺id
     * @return
     */
    @RequestMapping("/listCustomer")
    public QzhResult listCustomer(@RequestParam(required = false) Integer storeId){
        try {
            List<DecorationCustomer> customerList = decorationCustomerService.listCustomer(storeId);
            return QzhResult.ok(customerList);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

    /**
     * 插入客服中心的标题，如果decorationCustomerId存在就update该数据中
     * @param decorationCustomerId   客服中心的id
     * @param isShowTitle             是否展示标题；0是不展示，1是展示
     * @param title                    客服中心的标题
     * @return
     */
    @RequestMapping("/insertCustomerTitle")
    public QzhResult insertCustomerTitle(@RequestParam(required = false) Integer decorationCustomerId,
                                         @RequestParam(required = false) Integer isShowTitle,
                                         @RequestParam(required = false) String title){
        try {
            decorationCustomerService.insertCustomerTitle(decorationCustomerId,title,isShowTitle);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }
}
