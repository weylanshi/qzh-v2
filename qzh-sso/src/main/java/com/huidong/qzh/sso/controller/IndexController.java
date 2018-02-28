package com.huidong.qzh.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
//        QzhResult error = QzhResult.build(403, "error");
        return "hello";
    }
}
