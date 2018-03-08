package com.qzh.personalCenter.service;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.personalCenter.entity.ReceiverAddress;

import java.util.List;

public interface ReceiverAddressService {
    /**
     *
     * @param accountId   用户id
     * @param person      联系人
     * @param phone       手机
     * @param code         省市区编码
     * @param address     详细地址
     * @param isDefault    是否设为默认地址
     * @param addressId     地址表的id
     * @return
     */
    String  insertAddress(Integer accountId,String person,String phone,String code,String address,Integer isDefault,Integer addressId);
    /**
     * 查找该用户所添加的地址
     * @param accountId   用户id
     * @return
     */
    List<ReceiverAddress> addressList(Integer accountId);
    /**
     * 删除地址
     * @param addressId   地址表id
     * @return
     */
    String deleteAddress(Integer addressId,Integer accountId);


    /**
     * 得到默认地址
     * @param accountId
     * @return
     */
    QzhResult getAddressDefault(Integer accountId);

}
