package com.qzh.store.service;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface CommonService {

    /**
     * 判断登陆
     * @param request
     * @return
     */
    QzhResult isLand(HttpServletRequest request);

    /**
     * 判断是否关注店铺  0 未关注  1 已关注
     * @param request
     * @param storeId
     * @return
     */
    QzhResult isAttentionStore(HttpServletRequest request, Integer storeId);

}
