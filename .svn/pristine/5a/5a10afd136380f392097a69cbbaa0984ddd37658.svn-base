package com.qzh.personalCenter.service.impl;

import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.personalCenter.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    RestTemplate restTemplate;
    /**
     * 判断登陆
     * @param request
     * @return
     */
    @Override
    public QzhResult isLand(HttpServletRequest request) {
        String token = request.getHeader("QZH_TOKEN");
        if (StringUtils.isBlank(token)) {
            token = CookieUtils.getCookieValue(request, "QZH_TOKEN");
            if (StringUtils.isBlank(token)) {
                return QzhResult.build(400,"会话过期，请重新登录","");
            }
        }
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://QZH-SSO/token/{1}", QzhResult.class, token);
        return responseEntity.getBody();
    }

    /**
     * 通过店铺ID 获取 店铺信息   包含 商家ID
     * @param storeId
     * @return
     */
    @Override
    public QzhResult storeByStoreId(Integer storeId) {
        try {
            ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://QZH-STORE/storeInformation/getStoreInformation/{1}", QzhResult.class, storeId);
            return  responseEntity.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 通过 memberId 获取 商品
     * @param memberId
     * @return
     */
    @Override
    public QzhResult listProductByMemberId(Integer memberId,Integer pageNo,Integer pageSize) {
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("memberId",memberId);
            map.put("pageNo",pageNo);
            map.put("pageSize",pageSize);
            String url = "http://QZH-STANDARD/productGoods/portalProduct?memberId={memberId}&pageNo={pageNo}&pageSize={pageSize}";
            ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity(url, QzhResult.class, map);
            return  responseEntity.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 通过会员ID 获取 会员信息
     * @param id
     * @return
     */
    @Override
    public QzhResult getAccountsById(Integer id) {
        try {
            String url = "http://QZH-PORTAL/eipAccounts/getAccountById?id={1}";
            ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity(url, QzhResult.class, id);
            return responseEntity.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


}
