package com.huidong.qzh.standard.service;

import com.github.pagehelper.Page;
import com.huidong.qzh.standard.entity.ProductGoods;
import com.huidong.qzh.standard.entity.ProductSpecOptionRelation;
import com.huidong.qzh.util.common.util.QzhResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ProductGoodsService {


    /**
     *联表查询   product_goods    product_goods_picture  测试
     * @return
     */
    List listProductGoods();

    /**
     *联表查询   product_goods    product_goods_picture
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<ProductGoods> listGoodsWithPic(Integer pageNo,Integer pageSize);

    /**
     * 通过产品ID获取产品详情
     * @param goodsId
     * @return
     */
    ProductGoods productGoodsDetail(Integer goodsId);

    /**
     * 通过商家ID 获取 商家的推荐商品
     * @param memberId
     * @return
     */
    Page<ProductGoods> listProductRecommend(Integer memberId,Integer pageNo,Integer pageSize);


    /**
     * 企业门户的商品
     * 通过商家ID 获取 商家的商品  包括 产品图片 名称  价格   品牌
     * @param memberId
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map<String,Object> listProductByMemberId(Integer memberId,Integer pageNo,Integer pageSize);

    /**
     * 通过货品ID 获取 货品信息 ：图片   名称   价格   单位  自营   推荐
     * @param goodsId
     * @return
     */
    Map<Object,Object> getProductGoodsById(Integer goodsId);
    /**
     *  实时增减收藏产品数量
     * @param goodsId  货品表的id
     * @param status   状态：add:新增收藏产品; del:
     * @return
     */
    void addDelCollectionGoods(Integer goodsId,String status);
    /**
     * 通过货品ID 获取该货品的详情页所有的信息
     * @param goodsId
     * @return
     */
    QzhResult getProductDetailByGoodsId(HttpServletRequest request,Integer goodsId);

    /**
     * 通过 名称  价格  发布与否   分类与否 搜索某商家商品
     * @param info
     * @return
     */
    QzhResult listGoodsByParam(String info, Integer pageNo, Integer PageSize,Integer memberId);


    /**
     * 商品 修改/设置分类
     * @param goodsIds
     * @param categoryIds
     * @return
     */
    QzhResult updateGoodsCategoryId(String goodsIds,String categoryIds);


}
