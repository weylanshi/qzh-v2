package com.huidong.qzh.standard.controller;


import com.huidong.qzh.standard.entity.EipAccounts;
import com.huidong.qzh.standard.service.CommonService;
import com.huidong.qzh.util.common.annotation.LoginRequired;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 获取 所有的计量单位
     * @return
     */
    @RequestMapping("/listUnit")
    public QzhResult listUnit(){
        try {
            List list = commonService.listUnit();
            return QzhResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    @LoginRequired
    @GetMapping("/test")
    @ResponseBody
    public QzhResult test(HttpServletRequest request){
        EipAccounts accounts = (EipAccounts) request.getAttribute("accounts");
        System.out.println(accounts);
        return QzhResult.ok();
    }


}
