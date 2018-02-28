package com.qzh.store.service;

import com.huidong.qzh.util.common.util.QzhResult;

import javax.servlet.http.HttpServletRequest;

public interface CommonService {

    /**
     * 判断登陆
     * @param request
     * @return
     */
    QzhResult isLand(HttpServletRequest request);

}
