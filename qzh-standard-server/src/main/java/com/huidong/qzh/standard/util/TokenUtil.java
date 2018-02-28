package com.huidong.qzh.standard.util;

import com.huidong.qzh.standard.feign.SSOFeignClient;
import com.huidong.qzh.util.common.constant.LoginStatus;
import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    @Autowired
    private SSOFeignClient ssoFeignClient;

    /**
     * 获取 token
     * @param request
     * @return
     */
    public QzhResult getEipAccounts(HttpServletRequest request){
        String token = request.getHeader("QZH_TOKEN");
        if (StringUtils.isBlank(token)) {
            token = CookieUtils.getCookieValue(request, "QZH_TOKEN");
        }
        QzhResult userByToken = ssoFeignClient.getUserByToken(token);
        if (StringUtils.isBlank(token) || userByToken.getStatus() != 200) {
            return QzhResult.build(LoginStatus.LOGOUT_STATUS.getStatus(), "登录过期,请重新登录!");
        }
        return userByToken;
    }
}
