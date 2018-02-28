package com.huidong.qzh.standard.feign;


import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "qzh-sso")
public interface SSOFeignClient {

    @RequestMapping(value = "/token/{token}" ,method = RequestMethod.POST)
    public QzhResult  getUserByToken(@PathVariable("token") String token);
}
