package com.qzh.personalCenter.feign;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "qzh-store")//微服务名称
public interface StoreFeignClient {
    /**
     * 根据店铺id获取店铺信息
     * @param storeId
     * @return
     */
    @RequestMapping(value = "/storeInformation/getStoreInformation/{storeId}",method = RequestMethod.GET)
    public QzhResult getStoreInformation(@PathVariable(value = "storeId") Integer storeId);

    @RequestMapping(value = "/storeInformation/addDelAttentionNum")
    public QzhResult addDelAttentionNum(@RequestParam(value = "storeId") Integer storeId,
                                        @RequestParam(value = "status") String status);
}
