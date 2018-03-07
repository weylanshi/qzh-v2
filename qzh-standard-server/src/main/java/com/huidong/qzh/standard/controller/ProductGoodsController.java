package com.huidong.qzh.standard.controller;

import com.github.pagehelper.Page;
import com.huidong.qzh.standard.entity.ProductGoods;
import com.huidong.qzh.standard.feign.SSOFeignClient;
import com.huidong.qzh.standard.service.CommonService;
import com.huidong.qzh.standard.service.ProductGoodsService;
import com.huidong.qzh.util.common.util.CookieUtils;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/productGoods")
public class ProductGoodsController{
    @Autowired
    private ProductGoodsService productGoodsService;
    @Autowired
    private CommonService commonService;


    /**
     *联表查询   product_goods    product_goods_picture
     * @return
     */
    @RequestMapping("/listProductGoods")
    public QzhResult listProductGoods(){
        try {
            return QzhResult.build(200,productGoodsService.listProductGoods());
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.build(500,e.getMessage());
        }
    }

    /**
     * 热销产品
     * 联表查询   product_goods    product_goods_picture
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/hotSell")
    public QzhResult listGoodsWithPic(@RequestParam(defaultValue = "1",required = false) Integer pageNo,
                                      @RequestParam(defaultValue = "12",required = false) Integer pageSize){
        try {
            Page<ProductGoods> page = productGoodsService.listGoodsWithPic(pageNo,pageSize);
            return QzhResult.ok(QzhPageResult.build(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     * 产品详情
     * @return
     */
    @RequestMapping("/productGoodsDetail")
    public QzhResult productGoodsById(@RequestParam(required = true) Integer goodsId){
        try {
            ProductGoods productGoods = productGoodsService.productGoodsDetail(goodsId);

            return QzhResult.ok(productGoods);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }

    /**
     * 通过商家ID 获取 商家的推荐商品
     * @param memberId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/productsRecommend")
    public QzhResult listProductRecommend(@RequestParam(required = true) Integer memberId,
                                          @RequestParam(defaultValue = "1",required = false) Integer pageNo,
                                          @RequestParam(defaultValue = "4",required = false) Integer pageSize){
        try {
            Page<ProductGoods> page = productGoodsService.listProductRecommend(memberId, pageNo, pageSize);
            return QzhResult.ok(QzhPageResult.build(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 企业门户的商品
     * 通过商家ID 获取 商家的商品  包括 产品图片 名称  价格   品牌
     * @param memberId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/portalProduct")
    public QzhResult listProductByMemberId(@RequestParam(required = true) Integer memberId,
                                           @RequestParam(defaultValue = "1",required = false) Integer pageNo,
                                           @RequestParam(defaultValue = "4",required = false) Integer pageSize){
        try {
            Map<String, Object> map = productGoodsService.listProductByMemberId(memberId, pageNo, pageSize);
            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 通过货品ID 获取 货品信息 ：包括图片
     * @return
     */
    @RequestMapping(value = "/getProductGoodsById/{goodsId}",method = RequestMethod.GET)
    public QzhResult getProductGoodsById(@PathVariable(value = "goodsId") Integer goodsId){
        try {
            Map<Object, Object> goods2PicPath = productGoodsService.getProductGoodsById(goodsId);
            return QzhResult.ok(goods2PicPath);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }
    @RequestMapping("/addDelCollectionGoods")
    public QzhResult addDelCollectionGoods (@RequestParam(required = false) Integer goodsId,
                                            @RequestParam(required = false) String status){
        try {
             productGoodsService.addDelCollectionGoods(goodsId, status);
            return QzhResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.ok(e);
        }
    }

    /**
     * 通过货品ID 获取该货品的详情页所有的信息
     * @param request
     * @param goodsId
     * @return
     */
    @PostMapping("/proDetail")
    public QzhResult getProductDetailByGoodsId(HttpServletRequest request,
                                        @RequestParam(required = true) Integer goodsId){
        return productGoodsService.getProductDetailByGoodsId(request, goodsId);
    }


    /**
     * 通过 名称  价格  发布与否   分类与否 搜索某商家商品
     * @param info
     * @param pageNo
     * @param PageSize
     * @param memberId
     * @return
     */
    @RequestMapping("/listGoodsByParam")
    public QzhResult listGoodsByParam(@RequestParam(required = true) String info,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                      @RequestParam(required = false,defaultValue = "10") Integer PageSize,
                                      @RequestParam(required = true) Integer memberId){
        try {
            return productGoodsService.listGoodsByParam(info, pageNo, PageSize, memberId);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     * 商品 修改/设置分类
     * @param goodsIds
     * @param categoryIds
     * @return
     */
    @RequestMapping("/updateGoodsCategory")
    public QzhResult updateGoodsCategoryId(@RequestParam(required = true) String goodsIds,
                                           @RequestParam(required = true) String categoryIds){
        try {
            return productGoodsService.updateGoodsCategoryId(goodsIds, categoryIds);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


    /**
     *
     * 根据商家id 查询产品表的为推荐产品  以及推荐产品个数 和为推荐产品个数
     * 店铺装修时 宝贝推荐时用此接口
     * @param customCategoryId 自定义分类的ID的拼接 以逗号隔开
     * @param keyword 货物名称
     * @param rangeOfPrice 价格范围
     * @return
     */
    @RequestMapping("/getNoRecommendGoods")
    public QzhResult getNoRecommendGoods(HttpServletRequest request,
                                         @RequestParam(required = true) String customCategoryId,
                                         @RequestParam(required = true) String keyword,
                                         @RequestParam(required = true) String rangeOfPrice,
                                         @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                         @RequestParam(required = false,defaultValue = "5") Integer pageSize){
        try {
            QzhResult land = commonService.isLand(request);
            if (land.getStatus() != 200) {
                return land;
            }
            Map<Object, Object> eipMap = (Map<Object, Object>) land.getData();
            Integer memberId = Integer.parseInt(eipMap.get("memberId").toString());
            Map<String, Object> map = productGoodsService.getNoRecommendGoods(memberId,customCategoryId,keyword,rangeOfPrice,pageNo, pageSize);
            return QzhResult.ok(map);
        } catch (Exception e) {
            return QzhResult.error(e.getMessage());
        }


    }

    /**
     * 根据产品id 修改产品 is_recommend 属性
     * */
    @RequestMapping("/doRecommend")
    public QzhResult doRecommend(Integer productGoodsId){
        try{
            Integer num=productGoodsService.doRecommend(productGoodsId);
            if(num>0){
                return QzhResult.ok("推荐成功！");
            }
        }catch(Exception e){
            return QzhResult.error(e.getMessage());
        }
        return QzhResult.error("推荐失败！");
    }

}
