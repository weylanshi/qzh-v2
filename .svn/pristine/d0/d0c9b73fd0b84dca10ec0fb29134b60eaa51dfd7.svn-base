package com.huidong.qzh.standard.service.Impl;

import com.huidong.qzh.standard.entity.*;
import com.huidong.qzh.standard.mapper.*;
import com.huidong.qzh.standard.service.ProductSpecService;
import com.huidong.qzh.util.common.util.StringUtils;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductSpecServiceImpl implements ProductSpecService{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSpecOptionRelationMapper productSpecOptionRelationMapper;

    @Autowired
    private ProductCategorySpecMapper productCategorySpecMapper;
    @Autowired
    private ProductSpecMapper productSpecMapper;
    @Autowired
    private ProductSpecOptionMapper productSpecOptionMapper;
    @Autowired
    private ProductColorMapper productColorMapper;



    /**
     * 通过产品ID获取产品规格
     * @param goodsId
     * @return
     */
    @Override
    public List<Map<String,Object>> listProductSpecOption(Integer goodsId) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("goodsId",goodsId);
        List<Product> products = productMapper.selectByExample(example);

        List<ProductSpecOptionRelation> productSpecOptionRelationsS = new ArrayList<>();
        products.forEach(product -> {
            Example example1 = new Example(ProductSpecOptionRelation.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("productId",product.getId());
            List<ProductSpecOptionRelation> productSpecOptionRelations = productSpecOptionRelationMapper.selectByExample(example1);
            productSpecOptionRelationsS.addAll(productSpecOptionRelations);
        });
        Map<String, List<ProductSpecOptionRelation>> groupedSpec =
                productSpecOptionRelationsS.stream().collect(Collectors.groupingBy(ProductSpecOptionRelation::getSpecName));
        Set<String> keys = groupedSpec.keySet();
        Iterator<String> iterator = keys.iterator();
        List<Map<String,Object>> map = new ArrayList<Map<String,Object>>();
        while(iterator.hasNext()){
            String key = iterator.next();
            List<ProductSpecOptionRelation> relations = groupedSpec.get(key);
            Map<String, List<ProductSpecOptionRelation>> options = relations.stream().collect(Collectors.groupingBy(ProductSpecOptionRelation::getSpecOptionName));

            Set<String> optionKeys = options.keySet();
            Iterator<String> iteratorOption = optionKeys.iterator();
            List<Map<String,Object>> optionMapList = new ArrayList<Map<String,Object>>();
            while(iteratorOption.hasNext()){
                String optionStr = iteratorOption.next();
                List<ProductSpecOptionRelation> optionNames = options.get(optionStr);
                String productIds = "";
                for (ProductSpecOptionRelation optionName : optionNames){
                    productIds = productIds + optionName.getProductId()+",";
                }
                if(!StringUtils.equalsNull(productIds)){
                    productIds = productIds.substring(0,productIds.length()-1);
                }
                Map<String,Object> optionMap = new HashMap<String,Object>();
                optionMap.put("option",optionStr);
                optionMap.put("productIds",productIds);
                optionMapList.add(optionMap);
            }

            Map<String,Object> mapList = new HashMap<String,Object>();
            mapList.put("specName",key);
            mapList.put("option",optionMapList);
            map.add(mapList);
        }

        return map;
    }

    /**
     * 获取这个分类下的所有规格  及  规格选项
     * 颜色的另外获取
     * @param categoryId
     * @return
     */
    @Override
    public List listSpecOption(Integer categoryId) {
        ProductCategorySpec categorySpec = new ProductCategorySpec();
        categorySpec.setCategoryId(categoryId);
        List<ProductCategorySpec> categorySpecList = productCategorySpecMapper.select(categorySpec);

        List<Map<Object,Object>> listMap = new ArrayList<Map<Object,Object>>();
        categorySpecList.forEach(productCategorySpec -> {
            Integer specId = productCategorySpec.getSpecId();
            ProductSpec productSpec = productSpecMapper.selectByPrimaryKey(specId);
            String specName = productSpec.getSpecName();

            BeanMap beanMap = new BeanMap(productSpec);
            Map<Object,Object> map = new HashMap<Object,Object>();
            map.putAll(beanMap);
            map.remove("class");
            if(!"颜色".equals(specName)){
                ProductSpecOption specOption = new ProductSpecOption();
                specOption.setSpecId(productSpec.getId());
                List<ProductSpecOption> optionList = productSpecOptionMapper.select(specOption);
                map.put("options",optionList);

                listMap.add(map);
            }else{
                //颜色系   颜色
                List<ProductColor> productColorList = productColorMapper.selectAll();
                Map<Integer, List<ProductColor>> groupColor = productColorList.stream().collect(Collectors.groupingBy(ProductColor::getParentId));

                List<Map<Object,Object>> totalMap = new ArrayList<>();
                //颜色系
                List<ProductColor> colorlist0 = groupColor.get(0);

                Set<Integer> colorKeys = groupColor.keySet();
                Iterator<Integer> iteratorColor = colorKeys.iterator();
                while(iteratorColor.hasNext()){
                    Integer next = iteratorColor.next();
                    if(next!=0){
                        colorlist0.forEach(productColor -> {
                            if(next == productColor.getId()){
                                BeanMap beanMapColor = new BeanMap(productColor);
                                Map<Object,Object> mapColor = new HashMap<Object,Object>();
                                mapColor.putAll(beanMapColor);
                                mapColor.remove("class");

                                List<ProductColor> colorsNext = groupColor.get(next);
                                mapColor.put("child",colorsNext);
                                totalMap.add(mapColor);
                            }
                        });
                    }
                }
                map.put("options",totalMap);
                listMap.add(map);
            }
        });
        return listMap;
    }

}
