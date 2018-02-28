package com.huidong.qzh.portal.controller;


import com.huidong.qzh.portal.service.EipAccountsService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eipAccounts")
public class EipAccountsController {
    @Autowired
    private EipAccountsService eipAccountsService;

    /**
     * 通过ID 获取 会员信息
     * @param id
     * @return
     */
    @RequestMapping("/getAccountById")
    public QzhResult getAccountById(@RequestParam(required = true) Integer id){
        try {
            return eipAccountsService.getAccountById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

}
