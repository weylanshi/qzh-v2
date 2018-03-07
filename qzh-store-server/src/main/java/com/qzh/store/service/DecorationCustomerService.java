package com.qzh.store.service;

import com.qzh.store.entity.DecorationCustomer;

import java.util.List;

public interface DecorationCustomerService {

    /**
     *
     * @param info       info：{"workTime1":"周日"}
     * @param memberId   公司id
     */
    void insertDecorationCustomer(String info,Integer memberId,Integer decorationCustomerId);
    /**
     *
     * @param storeId  店铺id
     * @return
     */
    List<DecorationCustomer> listCustomer(Integer storeId);
    /**
     *
     * @param decorationCustomerId  客服中心的id
     * @param title                  客服中心的名字
     * @param isShowTitle            是否展示客服名字
     */
    void insertCustomerTitle(Integer decorationCustomerId,String title,Integer isShowTitle);
}
