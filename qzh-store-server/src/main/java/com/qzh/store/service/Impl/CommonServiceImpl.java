package com.qzh.store.service.Impl;

import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.netflix.appinfo.AmazonInfo.MetaDataKey.accountId;

@Service
public class CommonServiceImpl implements CommonService{
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
     * 判断是否关注店铺  0 未关注  1 已关注
     * @param request
     * @param storeId
     * @return
     */
    @Override
    public QzhResult isAttentionStore(HttpServletRequest request, Integer storeId) {
        String token = request.getHeader("QZH_TOKEN");
        if (StringUtils.isBlank(token)) {
            token = CookieUtils.getCookieValue(request, "QZH_TOKEN");
            if (StringUtils.isBlank(token)) {
                return QzhResult.ok(0);
            }
        }
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://QZH-SSO/token/{1}", QzhResult.class, token);
        QzhResult body = responseEntity.getBody();
        if(body.getStatus()!=200){
            return QzhResult.ok(0);
        }
        Map<String,Object> data = (Map<String,Object>)body.getData();
        Integer accountId = Integer.parseInt(data.get("id").toString());

        String uri = "http://QZH-PERSONALCENTER/attentionStore/isAttention?accountId={accountId}&storeId={storeId}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("accountId", accountId);
        map.put("storeId", storeId);

        ResponseEntity<QzhResult> responseEntity1 = restTemplate.getForEntity(uri, QzhResult.class, map);
        return responseEntity1.getBody();
    }
}
