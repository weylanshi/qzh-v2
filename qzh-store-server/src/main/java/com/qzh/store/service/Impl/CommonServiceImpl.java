package com.qzh.store.service.Impl;

import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
public class CommonServiceImpl implements CommonService{
    @Autowired
    RestTemplate restTemplate;
    /**
     * 判断登陆
     * @param request
     * @return
     */
    @Override
    public QzhResult isLand(HttpServletRequest request) {
        String token = request.getHeader("QZH_TOKEN");
        if (StringUtils.isBlank(token)) {
            token = CookieUtils.getCookieValue(request, "QZH_TOKEN");
            if (StringUtils.isBlank(token)) {
                return QzhResult.build(400,"会话过期，请重新登录","");
            }
        }
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://QZH-SSO/token/{1}", QzhResult.class, token);
        return responseEntity.getBody();
    }
}
