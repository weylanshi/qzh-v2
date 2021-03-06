package com.qzh.personalCenter.feign;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "qzh-standard")
public interface StandardFeignClient {

    @RequestMapping(value = "/productGoods/getProductGoodsById/{goodsId}")
    public QzhResult getProductGoodsById(@PathVariable(value = "goodsId") Integer goodsId);

    @RequestMapping(value = "/productGoods/addDelCollectionGoods")
    public QzhResult addDelCollectionGoods (@RequestParam(value = "goodsId") Integer goodsId,
                                            @RequestParam(value = "status") String status);
}
