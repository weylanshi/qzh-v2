package com.huidong.qzh.portal.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huidong.qzh.portal.entity.ApShopnews;
import com.huidong.qzh.portal.entity.Area;
import com.huidong.qzh.portal.entity.EipInfo;
import com.huidong.qzh.portal.entity.EipMember;
import com.huidong.qzh.portal.mapper.AreaMapper;
import com.huidong.qzh.portal.mapper.EipInfoMapper;
import com.huidong.qzh.portal.mapper.EipMemberMapper;
import com.huidong.qzh.portal.service.EipMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EipMemberServiceImpl implements EipMemberService {
    @Autowired
    private EipMemberMapper eipMemberMapper;
    @Autowired
    private EipInfoMapper eipInfoMapper;
    @Autowired
    private AreaMapper areaMapper;


    @Override
    public Page<EipMember> getEipMember(String pca,String enterpriseType,String industryType,String order,Integer pageNo,Integer pageSize) {
        Example example = new Example(EipMember.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("flag",1);
        if(StringUtils.isNotBlank(pca)){
            String province = pca.substring(0, 2);
            String city = pca.substring(2, 4);
            String area = pca.substring(4, 6);
            if("00".equals(city)){
                criteria.andLike("pca",province+"%");
            }else if("00".equals(area)){
                criteria.andLike("pca",province+city+"%");
            }else {
                criteria.andEqualTo("pca",pca);
            }
        }

        //criteria.andEqualTo("pca",pca);
        if(StringUtils.isNotBlank(enterpriseType)){
            criteria.andLike("enterpriseType",enterpriseType);
        }
        if(StringUtils.isNotBlank(industryType)){
            criteria.andLike("industryType",industryType+"%");
        }


        if("1".equals(order)){
            example.setOrderByClause("id ASC");
        }else if("2".equals(order)){
            example.setOrderByClause("name ASC");
        }else if("3".equals(order)){
            example.setOrderByClause("id DESC");
        }
        PageHelper.startPage(pageNo,pageSize);
        Page<EipMember> page= (Page<EipMember>)  eipMemberMapper.selectByExample(example);
        return page;
    }

    @Override
    public HashMap<String, Object> companyIntroduce(Integer memberId){
        EipMember eipMember = eipMemberMapper.selectByPrimaryKey(memberId);

        EipInfo eipInfoBase = new EipInfo();
        eipInfoBase.setMemberId(eipMember.getId());
        EipInfo eipInfo = eipInfoMapper.selectOne(eipInfoBase);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("eipMember",eipMember);
        resultMap.put("eipInfo",eipInfo);

        return resultMap;
    }

    /**
     * 获取省市区名称
     * @return
     */

    public List<Area> getPca(String pca){

        Example example = new Example(Area.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(pca)){
            String province = pca.substring(0, 2);
            String city = pca.substring(2, 4);
            String area = pca.substring(4, 6);
            if("00".equals(city)){
                criteria.andLike("code",province+"%");
                criteria.andEqualTo("level",2);
            }else if("00".equals(area)){
                criteria.andLike("code",province+city+"%");
                criteria.andEqualTo("level",3);
            }else {
                criteria.andEqualTo("code",pca);
            }
        }else {
            criteria.andEqualTo("level",1);
        }
        List<Area> areas = areaMapper.selectByExample(example);

        return areas;
    }

    @Override
    public String getAreaInfo(String code){
        Example example = new Example(Area.class);
        Example.Criteria criteria = example.createCriteria();
        String areaInfo = "";
        if(null!=code&&""!=code){
            String province = code.substring(0, 2);
            String city = code.substring(2, 4);
            String area = code.substring(4, 6);

                criteria.andLike("code",province+"%");
                List<Area> areas = areaMapper.selectByExample(example);
                areaInfo = areas.get(0).getName();

                criteria.andLike("code",province+city+"%");
                List<Area> areas2 = areaMapper.selectByExample(example);
                areaInfo  = areaInfo + areas2.get(0).getName();

                criteria.andEqualTo("code",code);
                List<Area> areas3 = areaMapper.selectByExample(example);
                areaInfo  = areaInfo + areas3.get(0).getName();
            }

        return areaInfo;
    }
}
