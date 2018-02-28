package com.huidong.qzh.portal.service;

import com.huidong.qzh.util.common.util.QzhResult;

public interface EipAccountsService {

    /**
     * 通过ID 获取 会员信息
     * @param id
     * @return
     */
    QzhResult getAccountById(Integer id);

}
