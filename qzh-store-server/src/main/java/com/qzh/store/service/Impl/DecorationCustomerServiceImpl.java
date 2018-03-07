package com.qzh.store.service.Impl;


import com.huidong.qzh.util.common.util.StringUtils;
import com.mongodb.util.JSON;
import com.qzh.store.entity.DecorationCustomer;
import com.qzh.store.entity.StoreInformation;
import com.qzh.store.mapper.DecorationCustomerMapper;
import com.qzh.store.mapper.StoreInformationMapper;
import com.qzh.store.service.DecorationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DecorationCustomerServiceImpl implements DecorationCustomerService{
    @Autowired
    private DecorationCustomerMapper decorationCustomerMapper;
    @Autowired
    private StoreInformationMapper storeInformationMapper;

    /**
     *
     * @param info       info：{"workTime1":"周日"}
     * @param memberId   公司id
     * @param decorationCustomerId  客户中心的id
     */
    public void insertDecorationCustomer(String info,Integer memberId,Integer decorationCustomerId){
        Map<String,Object> map = (Map<String,Object>) JSON.parse(info);
        Object customer = map.get("decorationCustomer");
        DecorationCustomer decorationCustomer = new DecorationCustomer();
        if(decorationCustomerId!=null){
            decorationCustomer =  decorationCustomerMapper.selectByPrimaryKey(decorationCustomerId);
        }

        try {
            Map<String, Object> objectMap = (Map<String, Object>) customer;
            Object workTime1 = objectMap.get("workTime1");
            if(null!=workTime1){
                decorationCustomer.setWorkTime1(workTime1.toString());
            }
            Object workTime2 = objectMap.get("workTime2");
            if(null!=workTime2){
                decorationCustomer.setWorkTime2(workTime2.toString());
            }
            Object isShowTime1 = objectMap.get("isShowTime1");
            if(isShowTime1!=null){
                decorationCustomer.setIsShowTime1(isShowTime1.hashCode());
            }
            Object isShowTime2 = objectMap.get("isShowTime2");
            if(isShowTime2!=null){
                decorationCustomer.setIsShowTime2(isShowTime2.hashCode());
            }
            Object customerId = objectMap.get("customerId");
            if(null!=customerId){
                decorationCustomer.setCustomerId(customerId.toString());
            }
            Object isShowCustomer = objectMap.get("isShowCustomer");
            if(null!=isShowCustomer){
                decorationCustomer.setIsShowCustomer(isShowCustomer.hashCode());
            }
            Object tel = objectMap.get("tel");
            if(null!=tel){
                decorationCustomer.setTel(tel.toString());
            }
            Object phoneNumber = objectMap.get("phoneNumber");
            if(null!=phoneNumber){
                decorationCustomer.setPhoneNumber(phoneNumber.toString());
            }
            StoreInformation information = new StoreInformation();
            information.setMemberId(memberId);
            information = storeInformationMapper.selectOne(information);
            Integer storeId = information.getId();
            decorationCustomer.setStoreId(storeId);
            if(decorationCustomerId!=null){
                decorationCustomerMapper.updateByPrimaryKey(decorationCustomer);
            }else{
                decorationCustomerMapper.insert(decorationCustomer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param storeId  店铺id
     * @return
     */
    public List<DecorationCustomer> listCustomer(Integer storeId){
        Example example = new Example(DecorationCustomer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("storeId",storeId);
        List<DecorationCustomer> customerList = decorationCustomerMapper.selectByExample(example);
        return customerList;
    }

    /**
     *
     * @param decorationCustomerId  客服中心的id
     * @param title                  客服中心的名字
     * @param isShowTitle            是否展示客服名字
     */
    public void insertCustomerTitle(Integer decorationCustomerId,String title,Integer isShowTitle){
        DecorationCustomer decorationCustomer = new DecorationCustomer();
        if(decorationCustomerId!=null){
            decorationCustomer =  decorationCustomerMapper.selectByPrimaryKey(decorationCustomerId);
        }
        if(null!=title&&""!=title){
            decorationCustomer.setTitle(title);
        }
        if(isShowTitle!=null){
            decorationCustomer.setIsShowTitle(isShowTitle);
        }
        if(decorationCustomerId!=null){
            decorationCustomerMapper.updateByPrimaryKey(decorationCustomer);
        }else{
            decorationCustomerMapper.insert(decorationCustomer);
        }
    }

}
