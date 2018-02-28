package com.huidong.qzh.portal.service;

import com.huidong.qzh.portal.entity.EipHomeAd;

import java.util.List;
import java.util.Map;

public interface EipHomeAdService {

    Map<String,List<EipHomeAd>> findAllAd();
}
