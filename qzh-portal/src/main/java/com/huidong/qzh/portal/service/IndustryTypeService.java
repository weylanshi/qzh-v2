package com.huidong.qzh.portal.service;

import com.huidong.qzh.portal.entity.IndustryType;

import java.util.List;

public interface IndustryTypeService {


     List<IndustryType> listFirstLv();

     List<IndustryType> listSecondLv(String firstLv);

}
