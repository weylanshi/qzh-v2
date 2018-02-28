package com.huidong.qzh.portal.service;

import com.github.pagehelper.Page;
import com.huidong.qzh.portal.entity.Area;
import com.huidong.qzh.portal.entity.EipMember;

import java.util.HashMap;
import java.util.List;

public interface EipMemberService {

    Page<EipMember> getEipMember(String pca, String enterpriseType, String industryType, String order, Integer pageNo, Integer pageSize);

    HashMap<String, Object> companyIntroduce(Integer memberId);
    List<Area> getPca(String pca);
}
