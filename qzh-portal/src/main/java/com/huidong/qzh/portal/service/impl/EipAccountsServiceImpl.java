package com.huidong.qzh.portal.service.impl;

import com.huidong.qzh.portal.entity.EipAccounts;
import com.huidong.qzh.portal.mapper.EipAccountsMapper;
import com.huidong.qzh.portal.service.EipAccountsService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EipAccountsServiceImpl implements EipAccountsService{

    @Autowired
    private EipAccountsMapper eipAccountsMapper;

    /**
     * 通过ID 获取 会员信息
     * @param id
     * @return
     */
    @Override
    public QzhResult getAccountById(Integer id) {
        try {
            EipAccounts eipAccounts = eipAccountsMapper.selectByPrimaryKey(id);
            return QzhResult.ok(eipAccounts);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }
}
