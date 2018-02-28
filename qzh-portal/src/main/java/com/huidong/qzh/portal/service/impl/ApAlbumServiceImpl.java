package com.huidong.qzh.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huidong.qzh.portal.entity.ApAlbum;
import com.huidong.qzh.portal.mapper.ApAlbumMapper;
import com.huidong.qzh.portal.service.ApAlbumService;
import com.huidong.qzh.util.common.util.QzhPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ApAlbumServiceImpl implements ApAlbumService {

    @Autowired
    private ApAlbumMapper apAlbumMapper;


    @Override
    public QzhPageResult getMemberPhoto(Integer memberId, Integer pageNo, Integer pageSize) {
        Example example = new Example(ApAlbum.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("memberid",memberId);
        PageHelper.startPage(pageNo, pageSize);
        List<ApAlbum> list = apAlbumMapper.selectByExample(example);
        PageInfo<ApAlbum> pageInfo = new PageInfo<>(list);
        return QzhPageResult.build(pageNo, pageSize,pageInfo.getTotal(), list);
    }
}
