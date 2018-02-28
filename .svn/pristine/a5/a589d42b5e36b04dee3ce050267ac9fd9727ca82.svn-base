package com.huidong.qzh.standard.service.Impl;

import com.huidong.qzh.standard.entity.ProductCategory;
import com.huidong.qzh.standard.mapper.ProductCategoryMapper;
import com.huidong.qzh.standard.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     *根据parentId 查询分类
     * @return
     */
    @Override
    public List<ProductCategory> listProductCategoryByParentId(Integer parentId) {
        Example example = new Example(ProductCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",parentId);

        return productCategoryMapper.selectByExample(example);

    }
}
