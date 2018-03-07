package com.qzh.personalCenter.service.impl;

import com.qzh.personalCenter.entity.ReceiverAddress;
import com.qzh.personalCenter.mapper.ReceiverAddressMapper;
import com.qzh.personalCenter.service.ReceiverAddressService;
import org.apache.ibatis.javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ReceiverAddressServiceImpl implements ReceiverAddressService {
    @Autowired
    private ReceiverAddressMapper receiverAddressMapper;

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
   public String  insertAddress(Integer accountId,String person,String phone,String code,String address,Integer isDefault,Integer addressId){
       ReceiverAddress receiverAddress = new ReceiverAddress();
       if(addressId!=null){
           receiverAddress =  receiverAddressMapper.selectByPrimaryKey(addressId);
       }
       if(accountId!=null){
           receiverAddress.setAccountId(accountId);
           //如果同一用户设置了另一个地址为默认地址，这步操作是取消默认地址
           if(isDefault==1){
               Example example = new Example(ReceiverAddress.class);
               Example.Criteria criteria = example.createCriteria();
               criteria.andEqualTo("accountId",accountId);
               criteria.andEqualTo("isDefault",isDefault);
               List<ReceiverAddress> receiverAddresses = receiverAddressMapper.selectByExample(example);
               if(receiverAddresses.size()>0){

                   Integer id = receiverAddresses.get(0).getId();
                   ReceiverAddress primaryKey = receiverAddressMapper.selectByPrimaryKey(id);
                   primaryKey.setIsDefault(0);
                   receiverAddressMapper.updateByPrimaryKey(primaryKey);
               }

           }else if(null==isDefault||isDefault==0){
               Example example = new Example(ReceiverAddress.class);
               Example.Criteria criteria = example.createCriteria();
               criteria.andEqualTo("accountId",accountId);
               List<ReceiverAddress> receiverAddresses = receiverAddressMapper.selectByExample(example);
               if(receiverAddresses.size()==0){
                   receiverAddress.setIsDefault(1);
               }else{
                   receiverAddress.setIsDefault(isDefault);
               }

           }
       }
       if(null!=person&&""!=person){
           receiverAddress.setPersonName(person);
       }
       if(null!=phone&&""!=phone){
           receiverAddress.setPhone(phone);
       }
       if(null!=code&&""!=code){
           receiverAddress.setArea(code);
       }
       if(null!=address&&""!=address){
           receiverAddress.setDetailedAddress(address);
       }


       if(addressId!=null){
            receiverAddressMapper.updateByPrimaryKey(receiverAddress);
       }else{
           receiverAddressMapper.insert(receiverAddress);
       }
       return "保存成功";
   }


    /**
     * 查找该用户所添加的地址
     * @param accountId   用户id
     * @return
     */
    public List<ReceiverAddress>  addressList(Integer accountId){
        Example example = new Example(ReceiverAddress.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("accountId",accountId);
        List<ReceiverAddress> receiverAddresses = receiverAddressMapper.selectByExample(example);
        return receiverAddresses;
    }

    /**
     * 删除地址
     * @param addressId   地址表id
     * @return
     */
    public String deleteAddress(Integer addressId,Integer accountId){
        if(addressId!=null){
            ReceiverAddress receiverAddress = receiverAddressMapper.selectByPrimaryKey(addressId);
            Integer isDefault = receiverAddress.getIsDefault();
            receiverAddressMapper.deleteByPrimaryKey(addressId);
            //如果删除的是地址是默认地址，就拿到id最大的设置为默认地址
            if(isDefault==1){
                Example example = new Example(ReceiverAddress.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("accountId",accountId);
                example.setOrderByClause("id DESC");
                List<ReceiverAddress> receiverAddresses = receiverAddressMapper.selectByExample(example);
                if(receiverAddresses.size()>0){
                    ReceiverAddress address = new ReceiverAddress();
                    Integer id = receiverAddresses.get(0).getId();
                    address = receiverAddressMapper.selectByPrimaryKey(id);
                    address.setIsDefault(1);
                    receiverAddressMapper.updateByPrimaryKey(address);
                }
            }


            return "删除成功";
        }
        return "未找到该地址";
    }
}
