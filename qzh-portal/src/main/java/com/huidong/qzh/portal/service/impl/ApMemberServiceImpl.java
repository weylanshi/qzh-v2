package com.huidong.qzh.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huidong.qzh.portal.entity.ApMember;
import com.huidong.qzh.portal.mapper.ApMemberMapper;
import com.huidong.qzh.portal.service.ApMemberService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ApMemberServiceImpl implements ApMemberService {

    @Autowired
    private ApMemberMapper apMemberMapper;

    @Override
    public ApMember getApMemberById(Integer id) {
        return apMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public QzhPageResult getEnterpriseList(Integer pageNo, Integer pageSize) {
        Example example = new Example(ApMember.class);
        PageHelper.startPage(pageNo,pageSize);
        List<ApMember> list = apMemberMapper.selectByExample(example);
        PageInfo<ApMember> pageInfo = new PageInfo<>(list);
        return QzhPageResult.build(pageNo,pageSize,pageInfo.getTotal(),list);
    }
}
