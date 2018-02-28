package com.huidong.qzh.standard.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.huidong.qzh.standard.entity.*;
import com.huidong.qzh.standard.mapper.*;
import com.huidong.qzh.standard.service.ProductService;
import com.mongodb.util.JSON;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductGoodsMapper productGoodsMapper;
    @Autowired
    private ProductAttributeOptionRelationMapper productAttributeOptionRelationMapper;
    @Autowired
    private ProductGoodsPictureMapper productGoodsPictureMapper;
    @Autowired
    private ProductGoodsSpecRelationMapper goodsSpecRelationMapper;
    @Autowired
    private ProductGoodsDetailsMapper goodsDetailsMapper;
    @Autowired
    private ProductSpecOptionRelationMapper productSpecOptionRelationMapper;



    /**
     * 通过productID获取价格 库存
     * @param productId
     * @return
     */
    @Override
    public Map<Object, Object> price2StockByProductId(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        BeanMap beanMap = new BeanMap(product);
        Map<Object, Object> map = new HashMap<>();
        map.putAll(beanMap);
        map.remove("class");
        return map;
    }

    /**
     * 新增产品
     * @param info
     */
    @Override
    public String insertProductPublishInfo(String info,Integer memberId) {
        //JSONObject jsonObject = JSONObject.parseObject(info);
        Date date = new Date();
        Map<String,Object> map = (Map<String,Object>)JSON.parse(info);
        //货品
        Object goods = map.get("goods");
        if(goods!=null){
            ProductGoods proGoods = new ProductGoods();
            try {
                Map<String,Object> goodsMap = (Map<String,Object>)goods;
                //分类
                Object categoryId = goodsMap.get("categoryId");
                if(categoryId!=null){
                    proGoods.setCategoryId(categoryId.toString());
                }
                //名称
                Object goodsName = goodsMap.get("goodsName");
                if(goodsName!=null){
                    proGoods.setGoodsName(goodsName.toString());
                }
                //价格
                Object fixedPrice = goodsMap.get("fixedPrice");
                if(fixedPrice!=null){
                    BigDecimal bigDecimal = new BigDecimal(fixedPrice.toString());
                    proGoods.setFixedPrice(bigDecimal);
                }
                //总库存
                Object stock = goodsMap.get("stock");
                if(stock!=null){
                    proGoods.setStock(Integer.parseInt(stock.toString()));
                }
                //商品编码
                Object productCode = goodsMap.get("productCode");
                if(productCode!=null){
                    proGoods.setProductCode(productCode.toString());
                }
                //条形码
                Object barCode = goodsMap.get("barCode");
                if(barCode!=null){
                    proGoods.setBarCode(barCode.toString());
                }
                //是否推荐
                Object isRecommend = goodsMap.get("isRecommend");
                if(isRecommend!=null){
                    proGoods.setIsRecommend(Integer.parseInt(isRecommend.toString()));
                }else{
                    proGoods.setIsRecommend(0);
                }
                //是否发布
                Object isPublish = goodsMap.get("isPublish");
                if(isPublish!=null){
                    proGoods.setIsPublish(Integer.parseInt(isPublish.toString()));
                }else{
                    proGoods.setIsPublish(0);
                }
                //自定义分类
                Object customCategoryId = goodsMap.get("customCategoryId");
                if(customCategoryId!=null){
                    proGoods.setCustomCategoryId(customCategoryId.toString());
                }
                //保存
                if(proGoods!=null){
                    proGoods.setEipMemberId(memberId);
                    proGoods.setIsNew(0);
                    proGoods.setIsHot(0);
                    proGoods.setSelfSupport(0);
                    proGoods.setCreateDate(date);
                    productGoodsMapper.insert(proGoods);
                }else{
                    return "productGoods is null !";
                }


                //货品 属性选项关系表
                Object attribute = map.get("attributes");
                List<ProductAttributeOptionRelation> attributeOptionRelationList = null;
                if(attribute!=null){
                    try {
                        attributeOptionRelationList = new ArrayList<ProductAttributeOptionRelation>();
                        List<Map<String, Object>> attOptionList = (List<Map<String, Object>>) attribute;
                        for(Map<String,Object> attOptionMap : attOptionList){
                            ProductAttributeOptionRelation attributeOptionRelation = new ProductAttributeOptionRelation();
                            //属性选项ID
                            Object attributeOptionId = attOptionMap.get("attributeOptionId");
                            if(attributeOptionId!=null){
                                attributeOptionRelation.setAttributeOptionId(Integer.parseInt(attributeOptionId.toString()));
                            }
                            //属性名称
                            Object attributeName = attOptionMap.get("attributeName");
                            if(attributeName!=null){
                                attributeOptionRelation.setAttributeName(attributeName.toString());
                            }
                            //属性选项名称
                            Object attributeOptionName = attOptionMap.get("attributeOptionName");
                            if(attributeOptionName!=null){
                                attributeOptionRelation.setAttributeOptionName(attributeOptionName.toString());
                            }
                            if(attributeOptionRelation!=null){
                                attributeOptionRelation.setGoodsId(proGoods.getId());
                                productAttributeOptionRelationMapper.insert(attributeOptionRelation);
                                attributeOptionRelationList.add(attributeOptionRelation);
                            }
                        }
//                        if(attributeOptionRelationList.size()!=0){
//                            productAttributeOptionRelationMapper.insertList(attributeOptionRelationList);
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        //删除 proGoods
                        productGoodsMapper.delete(proGoods);
                        return "productAttributeOptionRelation save Exception !";
                    }
                }

                //货品图片表
                Object picture =  map.get("picture");
                ProductGoodsPicture goodsPicture = null;
                if(picture!=null){
                    try {
                        goodsPicture = new ProductGoodsPicture();
                        Map<String, Object> picMap = (Map<String, Object>) picture;
                        //默认图片
                        Object picturePath = picMap.get("picturePath");
                        if(picturePath!=null){
                            goodsPicture.setPicturePath(picturePath.toString());
                        }
                        //3D图片
                        Object picture3DPath = picMap.get("picture3DPath");
                        if(picture3DPath!=null){
                            goodsPicture.setPicture3dPath(picture3DPath.toString());
                        }
                        //视频
                        Object videoPath = picMap.get("videoPath");
                        if(videoPath!=null){
                            goodsPicture.setVideoPath(videoPath.toString());
                        }
                        //保存
                        if(goodsPicture!=null){
                            goodsPicture.setCreateDate(date);
                            goodsPicture.setGoodsId(proGoods.getId());
                            productGoodsPictureMapper.insert(goodsPicture);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        //删除以上保存的
                        productGoodsMapper.delete(proGoods);
                        if(attributeOptionRelationList!=null&&attributeOptionRelationList.size()!=0){
                            attributeOptionRelationList.forEach(productAttributeOptionRelation -> {
                                productAttributeOptionRelationMapper.delete(productAttributeOptionRelation);
                            });
                        }

                        return "productGoodsPicture save Exception !";
                    }
                }

                //货品规格表
                Object spec = map.get("spec");
                List<ProductGoodsSpecRelation> goodsSpecRelationList = null;
                if(spec!=null){
                    try {
                        goodsSpecRelationList = new ArrayList<ProductGoodsSpecRelation>();
                        List<Map<String, Object>> specList = (List<Map<String, Object>>) spec;
                        for(Map<String, Object> specMap : specList){
                            ProductGoodsSpecRelation goodsSpecRelation = new ProductGoodsSpecRelation();
                            Object specId = specMap.get("specId");
                            //规格ID
                            if(specId!=null){
                                goodsSpecRelation.setSpecId(Integer.parseInt(specId.toString()));
                                goodsSpecRelation.setGoodsId(proGoods.getId());
                                goodsSpecRelationMapper.insert(goodsSpecRelation);
                                goodsSpecRelationList.add(goodsSpecRelation);
                            }
                        }
//                        if(goodsSpecRelationList!=null&&goodsSpecRelationList.size()!=0){
//                            goodsSpecRelationMapper.insertList(goodsSpecRelationList);
//                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        //删除以上保存的
                        productGoodsMapper.delete(proGoods);
                        if(attributeOptionRelationList!=null&&attributeOptionRelationList.size()!=0){
                            attributeOptionRelationList.forEach(productAttributeOptionRelation -> {
                                productAttributeOptionRelationMapper.delete(productAttributeOptionRelation);
                            });
                        }
                        if(goodsPicture!=null){
                           productGoodsPictureMapper.delete(goodsPicture);
                        }

                        return "productGoodsSpecRelation save Exception !";
                    }
                }

                //货品详情表
                Object detail = map.get("detail");
                ProductGoodsDetails goodsDetails = null;
                if(detail!=null){
                    try {
                        goodsDetails = new ProductGoodsDetails();
                        Map<String, Object> detailMap = (Map<String, Object>) detail;
                        //pc端详情
                        Object productDetailsPc = detailMap.get("productDetailsPc");
                        if(productDetailsPc!=null){
                            goodsDetails.setProductDetailsPc(productDetailsPc.toString());
                        }
                        //app端详情
                        Object productDetailsApp = detailMap.get("productDetailsApp");
                        if(productDetailsApp!=null){
                            goodsDetails.setProductDetailsApp(productDetailsApp.toString());
                        }
                        //保存
                        if(goodsDetails!=null){
                            goodsDetails.setGoodsId(proGoods.getId());
                            goodsDetailsMapper.insert(goodsDetails);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        //删除以上保存的
                        productGoodsMapper.delete(proGoods);
                        if(attributeOptionRelationList!=null&&attributeOptionRelationList.size()!=0){
                            attributeOptionRelationList.forEach(productAttributeOptionRelation -> {
                                productAttributeOptionRelationMapper.delete(productAttributeOptionRelation);
                            });
                        }
                        if(goodsPicture!=null){
                            productGoodsPictureMapper.delete(goodsPicture);
                        }
                        if(goodsSpecRelationList!=null&&goodsSpecRelationList.size()!=0){
                            goodsSpecRelationList.forEach(productGoodsSpecRelation -> {
                                goodsSpecRelationMapper.delete(productGoodsSpecRelation);
                            });
                        }

                        return "productGoodsDetails save Exception !";
                    }
                }


                //商品 及 规格选项表
                Object productSpecOptions = map.get("productSpecOptions");
                if(productSpecOptions!=null){
                    List<Product> productList = new ArrayList<Product>();
                    List<ProductSpecOptionRelation> productSpecOptionRelationList = new ArrayList<ProductSpecOptionRelation>();
                    List<Map<String, Object>> specOptionsMap = (List<Map<String, Object>>) productSpecOptions;
                    try {
                        for(Map<String, Object> optionMap : specOptionsMap){
                            //产品
                            Product product = new Product();
                            //产品名称
                            Object productName = optionMap.get("productName");
                            if(productName!=null){
                                product.setProductName(productName.toString());
                            }
                            //原价
                            Object originalPrice = optionMap.get("originalPrice");
                            if(originalPrice!=null){
                                product.setOriginalPrice(new BigDecimal(originalPrice.toString()));
                            }
                            //条形码
                            Object barCode1 = optionMap.get("barCode");
                            if(barCode1!=null){
                                product.setBarCode(barCode1.toString());
                            }
                            //商品编码
                            Object productCode1 = optionMap.get("productCode");
                            if(productCode1!=null){
                                product.setProductCode(productCode1.toString());
                            }
                            //库存
                            Object stock1 = optionMap.get("stock");
                            if(stock1!=null){
                                product.setStock(new BigDecimal(stock1.toString()));
                            }
                            //图片
                            Object picturePath = optionMap.get("picturePath");
                            if(picturePath!=null){
                                product.setPicturePath(picturePath.toString());
                            }
                            //保存
                            if(product!=null){
                                product.setGoodsId(proGoods.getId());
                                product.setCreateDate(date);
                                productList.add(product);
                                productMapper.insert(product);

                                ProductSpecOptionRelation specOptionRelation = new ProductSpecOptionRelation();
                                //规格选项ID
                                Object specOptionId = optionMap.get("specOptionId");
                                if(specOptionId!=null){
                                    specOptionRelation.setSpecOptionId(Integer.parseInt(specOptionId.toString()));
                                }
                                //规格名称
                                Object specName = optionMap.get("specName");
                                if(specName!=null){
                                    specOptionRelation.setSpecName(specName.toString());
                                }
                                //规格选项名称
                                Object specOptionName = optionMap.get("specOptionName");
                                if(specOptionName!=null){
                                    specOptionRelation.setSpecOptionName(specOptionName.toString());
                                }
                                //保存
                                if(specOptionRelation!=null){
                                    specOptionRelation.setProductId(product.getId());
                                    productSpecOptionRelationMapper.insert(specOptionRelation);
                                    productSpecOptionRelationList.add(specOptionRelation);
                                }
                            }
                        }
//                        if(productSpecOptionRelationList!=null&&productSpecOptionRelationList.size()!=0){
//                            productSpecOptionRelationMapper.insertList(productSpecOptionRelationList);
//                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        //删除以上保存的
                        productGoodsMapper.delete(proGoods);
                        if(attributeOptionRelationList!=null&&attributeOptionRelationList.size()!=0){
                            attributeOptionRelationList.forEach(productAttributeOptionRelation -> {
                                productAttributeOptionRelationMapper.delete(productAttributeOptionRelation);
                            });
                        }
                        if(goodsPicture!=null){
                            productGoodsPictureMapper.delete(goodsPicture);
                        }
                        if(goodsSpecRelationList!=null&&goodsSpecRelationList.size()!=0){
                            goodsSpecRelationList.forEach(productGoodsSpecRelation -> {
                                goodsSpecRelationMapper.delete(productGoodsSpecRelation);
                            });
                        }
                        if(productList!=null&&productList.size()!=0){
                            productList.forEach(product1 -> {
                                productMapper.delete(product1);
                            });
                        }
                        if(productSpecOptionRelationList!=null&&productSpecOptionRelationList.size()!=0){
                            productSpecOptionRelationList.forEach(productSpecOptionRelation1 -> {
                                productSpecOptionRelationMapper.delete(productSpecOptionRelation1);
                            });
                        }
                        return "product OR productSpecOptionRelation save Exception !";
                    }
                }
                return "SUCCESS";
            } catch (Exception e) {
                e.printStackTrace();
                return "productGoods save Exception !";
            }
        }else{
            return "goods parameter is null !";
        }
    }


}
