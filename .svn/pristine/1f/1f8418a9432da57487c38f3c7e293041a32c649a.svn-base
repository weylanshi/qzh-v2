package com.huidong.qzh.portal.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huidong.qzh.portal.entity.ApShopnews;
import com.huidong.qzh.portal.mapper.ApShopnewsMapper;
import com.huidong.qzh.portal.service.ApShopNewsService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class ApShopNewsServiceImpl implements ApShopNewsService {

    @Autowired
    private ApShopnewsMapper apShopnewsMapper;


    @Override
    public QzhPageResult getNewsByMemberAndClass(Integer memberId, String newsClassification, Integer pageNo, Integer pageSize) {
        Example example = new Example(ApShopnews.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("memberid",memberId);
        criteria.andEqualTo("newsclassification",newsClassification);
        example.setOrderByClause("createdate DESC ");
        PageHelper.startPage(pageNo,pageSize);
        Page<ApShopnews> page= (Page<ApShopnews>) apShopnewsMapper.selectByExample(example);
        return QzhPageResult.build(pageNo,pageSize,page.getTotal(),page.getResult());
    }
}
