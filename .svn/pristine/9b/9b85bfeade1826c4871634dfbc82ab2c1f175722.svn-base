package com.qzh.personalCenter.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huidong.qzh.util.common.util.QzhResult;
import com.huidong.qzh.util.common.util.StringUtils;
import com.qzh.personalCenter.entity.AttentionStore;
import com.qzh.personalCenter.entity.CollectProduct;
import com.qzh.personalCenter.feign.StoreFeignClient;
import com.qzh.personalCenter.mapper.AttentionStoreMapper;
import com.qzh.personalCenter.pojo.CollectionProdutId;
import com.qzh.personalCenter.service.AttentionStoreService;
import com.qzh.personalCenter.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Service
public class AttentionStoreServiceImpl implements AttentionStoreService{
    @Autowired
    private AttentionStoreMapper attentionStoreMapper;

    @Autowired
    private StoreFeignClient storeFeignClient;
    @Autowired
    private CommonService commonService;

    /**
     * 关注店铺
     * @param accountId  用户id
     * @param storeId    店铺id
     */
    public void insertAttentionStore(Integer accountId,Integer storeId){

        AttentionStore attentionStore = new AttentionStore();
        //java8 获取当前时间
        LocalDate now = LocalDate.now();
        //将LocalDate转换成Date
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());

        attentionStore.setAccountId(accountId);
        attentionStore.setStoreId(storeId);
        attentionStore.setCreateDate(date);
        attentionStoreMapper.insert(attentionStore);
        storeFeignClient.addDelAttentionNum(storeId,"add");
    }

    /**
     * 根据accountId 、pageNo、pageSize 分页获取数据
     * @param accountId  用户id
     * @param pageNo      第几页
     * @param pageSize    一页多少条数据
     * @return
     */
    public QzhResult listAttentionStore(Integer accountId, Integer pageNo, Integer pageSize){
        Map maplist = null;
        try {
            maplist = new HashMap();
            Example example = new Example(AttentionStore.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("accountId",accountId);
            example.setOrderByClause(" id DESC ");
            PageHelper.startPage(pageNo,pageSize);
            Page<AttentionStore> attentionStorePage = (Page<AttentionStore>) attentionStoreMapper.selectByExample(example);

            List<Map<Object,Object>> list = new ArrayList();
            attentionStorePage.forEach(attentionStore-> {
                QzhResult storeInformation = storeFeignClient.getStoreInformation(attentionStore.getStoreId());
                Object data = storeInformation.getData();
                Integer status = storeInformation.getStatus();
                if(status==200&&data!=null){
                    //拿到店铺简称跟logo
                    Map<Object,Object> map = (Map<Object,Object>)data;
                    map.remove("class");
                    map.put("attStoreId",attentionStore.getId());
                    if(map.get("memberLevel")==null){
                        map.put("memberLevel","普通会员");
                    }
                    //客服
                    if(map.get("customerService")!=null){
                        String customerService = map.get("customerService").toString();
                        String[] split_customerService = customerService.split(",");
                        QzhResult accountsById = commonService.getAccountsById(Integer.parseInt(split_customerService[0]));
                        if(accountsById.getStatus()==200){
                            Map<Object, Object> map_account = (Map<Object, Object>) accountsById.getData();
                            Object nikeName = map_account.get("nikeName");
                            if(nikeName!=null){
                                String customerService_accountId =  map_account.get("id").toString();
                                String customerService_nikeName =  nikeName.toString();
                                map.put("customerService",customerService_accountId+","+customerService_nikeName);
                            }
                        }
                    }

                    //拿到店铺的商品   4个
                    if(map.get("memberId")!=null){
                        Integer memberId = Integer.parseInt(map.get("memberId").toString());
                        QzhResult listProductByMemberId = commonService.listProductByMemberId(memberId,1,4);
                        if(listProductByMemberId.getStatus()==200){
                            Map<Object,Object> prolistMap = (Map<Object,Object>)listProductByMemberId.getData();
                            List<Map<Object,Object>> proList = (List<Map<Object,Object>>)prolistMap.get("data");
                            List<Map<Object,Object>> listproMap_new = new ArrayList<>();
                            for(int p=0;p<proList.size();p++){
                                Map<Object,Object> promap1 = proList.get(p);
                                Map<Object,Object> newProMap = new HashMap<>();
                                newProMap.put("goodsName",promap1.get("goodsName"));
                                newProMap.put("pic",promap1.get("pic"));
                                newProMap.put("price",promap1.get("fixedPrice"));
                                newProMap.put("id",promap1.get("id"));
                                listproMap_new.add(newProMap);
                            }
                            map.put("prolist",listproMap_new);
                            map.put("totalNum",prolistMap.get("totalNum"));

                            list.add(map);
                        }
                    }

                }
            });
            int pages = attentionStorePage.getPages();
            long total = attentionStorePage.getTotal();
            maplist.put("pages",pages);
            maplist.put("totalCount",total);
            maplist.put("storeInformation",list);
            return QzhResult.ok(maplist);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * ids:是关注店铺表的id，删除多个id时，以逗号隔开
     * @param ids  例如（1，2，3）
     */
    public void deletAttentionStore(String ids){
        if(StringUtil.isNotEmpty(ids)){
            String[] idArr = ids.split(",");
            for (int i = 0; i < idArr.length; i++) {
                if(StringUtil.isNotEmpty(idArr[i])){
                    //先根据关注店铺表中的id获取店铺id  先减再删除
                    AttentionStore attentionStore = attentionStoreMapper.selectByPrimaryKey(Integer.parseInt(idArr[i]));
                    storeFeignClient.addDelAttentionNum(attentionStore.getStoreId(),"del");
                    //删除关注店铺表的信息
                    attentionStoreMapper.deleteByPrimaryKey(Integer.parseInt(idArr[i]));
                }
            }
        }
    }

    /**
     * 判断是否关注店铺
     * @param accountId
     * @param storeId
     * @return
     */
    @Override
    public Integer isAttentionStore(Integer accountId, Integer storeId) {
        Integer exist = 0;
        try {
            AttentionStore attentionStore = new AttentionStore();
            attentionStore.setAccountId(accountId);
            attentionStore.setStoreId(storeId);
            attentionStore = attentionStoreMapper.selectOne(attentionStore);
            if(attentionStore!=null){
                exist = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }

}
