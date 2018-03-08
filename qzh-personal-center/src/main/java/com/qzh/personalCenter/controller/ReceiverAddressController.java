package com.qzh.personalCenter.controller;

import com.huidong.qzh.util.common.annotation.LoginRequired;
import com.huidong.qzh.util.common.entity.EipAccounts;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.personalCenter.entity.ReceiverAddress;
import com.qzh.personalCenter.service.CommonService;
import com.qzh.personalCenter.service.ReceiverAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class ReceiverAddressController {
    @Autowired
    private ReceiverAddressService receiverAddressService;
    @Autowired
    private CommonService commonService;
    /**
     *
     * @param person      联系人
     * @param phone       手机
     * @param code         省市区编码
     * @param address     详细地址
     * @param isDefault    是否设为默认地址
     * @param addressId     地址表的id
     * @return
     */
    @RequestMapping("/insertAddress")
    public QzhResult insertAddress(HttpServletRequest request,
                                    @RequestParam(required = false) String person,
                                   @RequestParam(required = false) String phone,
                                   @RequestParam(required = false) String code,
                                   @RequestParam(required = false) String address,
                                   @RequestParam(required = false) Integer isDefault,
                                   @RequestParam(required = false) Integer addressId){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());
            String insertAddress = receiverAddressService.insertAddress(accountId, person, phone, code, address, isDefault, addressId);
            return QzhResult.ok(insertAddress);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }

    }

    /**
     * 获取该用户已添加过的地址
     * @param request  获取登陆信息
     * @return
     */
    @RequestMapping("/listAddress")
    public QzhResult listAddress(HttpServletRequest request){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());
            List<ReceiverAddress> receiverAddresses = receiverAddressService.addressList(accountId);
            return QzhResult.ok(receiverAddresses);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

    /**
     * 根据地址id删除地址信息
     * @param addressId
     * @return
     */
    @RequestMapping("/deleteAddress")
    public QzhResult deleteAddress(HttpServletRequest request,
                                    @RequestParam(required = false) Integer addressId){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<String, Object> land_map = (Map<String, Object>) land.getData();
            Integer accountId = Integer.parseInt(land_map.get("id").toString());
            String address = receiverAddressService.deleteAddress(addressId,accountId);
            return QzhResult.ok(address);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e);
        }
    }

    /**
     * 获取默认地址
     * @param request
     * @return
     */
    @PostMapping("/defaultAddress")
    @LoginRequired
    public QzhResult getAddressDefault(HttpServletRequest request){
        try {
            EipAccounts accounts = (EipAccounts) request.getAttribute("accounts");
            Integer accountId = accounts.getId();

            QzhResult addressDefault = receiverAddressService.getAddressDefault(accountId);
            return addressDefault;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     *  获取默认地址
     * @param accountId
     * @return
     */
    @RequestMapping("/accDefault")
    public QzhResult getAddressDefault(Integer accountId){
        try {
            QzhResult addressDefault = receiverAddressService.getAddressDefault(accountId);
            return addressDefault;
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


}
