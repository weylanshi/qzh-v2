package com.huidong.qzh.standard.service.Impl;

import com.huidong.qzh.standard.entity.SysUnit;
import com.huidong.qzh.standard.mapper.SysUnitMapper;
import com.huidong.qzh.standard.service.CommonService;
import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private SysUnitMapper unitMapper;

    /**
     * 获取 所有的计量单位
     *
     * @return
     */
    @Override
    public List listUnit() {
        List<SysUnit> units = unitMapper.selectAll();
        return units;
    }

    /**
     * 判断登陆
     *
     * @param request
     * @return
     */
    @Override
    public QzhResult isLand(HttpServletRequest request) {
        String token = request.getHeader("QZH_TOKEN");
        if (StringUtils.isBlank(token)) {
            token = CookieUtils.getCookieValue(request, "QZH_TOKEN");
        }
        if (StringUtils.isBlank(token)) {
            return QzhResult.error("token 为空!");
        }
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity("http://QZH-SSO/token/{1}", QzhResult.class, token);
        return responseEntity.getBody();
    }

    /**
     * 判断是否关注店铺
     *
     * @param accountId
     * @param storeId
     * @return
     */
    @Override
    public QzhResult isAttentionStore(Integer accountId, Integer storeId) {
        String url = "http://QZH-PERSONALCENTER/attentionStore/isAttentionStore?accountId={accountId}&storeId={storeId}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("accountId", accountId);
        map.put("storeId", storeId);
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity(url, QzhResult.class, map);
        return responseEntity.getBody();
    }

    /**
     * 判断是否收藏商品
     *
     * @param accountId
     * @param goodsId
     * @return
     */
    @Override
    public QzhResult isCollectProduct(Integer accountId, Integer goodsId) {
        String url = "http://QZH-PERSONALCENTER/collectProduct/isCollectProduct?accountId={accountId}&goodsId={goodsId}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("accountId", accountId);
        map.put("goodsId", goodsId);
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity(url, QzhResult.class, map);
        return responseEntity.getBody();
    }

    /**
     * 通过商家ID 获取 店铺信息
     *
     * @param memberId
     * @return
     */
    @Override
    public QzhResult getStoreByMemberId(Integer memberId) {
        String url = "http://QZH-STORE/storeInformation/getStore?memberId={1}";
        ResponseEntity<QzhResult> responseEntity = restTemplate.getForEntity(url, QzhResult.class, memberId);
        return responseEntity.getBody();
    }
}
