package com.huidong.qzh.standard.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huidong.qzh.standard.entity.*;
import com.huidong.qzh.standard.mapper.*;
import com.huidong.qzh.standard.service.CommonService;
import com.huidong.qzh.standard.service.ProductGoodsService;
import com.huidong.qzh.util.common.util.QzhResult;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductGoodsServiceImpl implements ProductGoodsService{
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ProductGoodsMapper  productGoodsMapper;
    @Autowired
    private ProductGoodsPictureMapper pictureMapper;
    @Autowired
    private ProductAttributeOptionRelationMapper productAttributeOptionRelationMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSpecOptionRelationMapper productSpecOptionRelationMapper;
    @Autowired
    private ProductGoodsPictureMapper productGoodsPictureMapper;
    @Autowired
    private ProductGoodsDetailsMapper goodsDetailsMapper;
    @Autowired
    private ShopStatisticsMapper shopStatisticsMapper;

    /**
     *联表查询   product_goods    product_goods_picture  测试
     * @return
     */
    @Override
    public List listProductGoods() {
        return productGoodsMapper.listProductGoods();
    }

    /**
     *联表查询   product_goods    product_goods_picture
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<ProductGoods> listGoodsWithPic(Integer pageNo,Integer pageSize){
        Example example = new Example(ProductGoods.class);
        example.setOrderByClause(" sales_volume DESC ");
        PageHelper.startPage(pageNo,pageSize);
        Page<ProductGoods> page = (Page<ProductGoods>) productGoodsMapper.selectByExample(example);
        List<ProductGoods> goods = page.getResult();
        goods.forEach(good ->{
            ProductGoodsPicture pic = new ProductGoodsPicture();
            pic.setGoodsId(good.getId());
            ProductGoodsPicture productGoodsPicture = pictureMapper.selectOne(pic);
            good.setPic(productGoodsPicture);
        });
        return page;
    }

    /**
     * 通过产品ID获取产品详情
     * @param goodsId
     * @return
     */
    @Override
    public ProductGoods productGoodsDetail(Integer goodsId) {
        ProductGoods good = productGoodsMapper.selectByPrimaryKey(goodsId);
        ProductGoodsPicture pic = new ProductGoodsPicture();
        pic.setGoodsId(good.getId());
        ProductGoodsPicture productGoodsPicture = pictureMapper.selectOne(pic);
        good.setPic(productGoodsPicture);
        return good;
    }

    /**
     * 通过商家ID 获取 商家的推荐商品
     * @param memberId
     * @return
     */
    @Override
    public Page<ProductGoods> listProductRecommend(Integer memberId,Integer pageNo,Integer pageSize) {
        Example example = new Example(ProductGoods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eipMemberId",memberId);
        criteria.andEqualTo("isRecommend",1);
        PageHelper.startPage(pageNo,pageSize);
        Page<ProductGoods> page = (Page<ProductGoods>)productGoodsMapper.selectByExample(example);
        List<ProductGoods> productGoods = page.getResult();
        productGoods.forEach(good -> {
            ProductGoodsPicture pic = new ProductGoodsPicture();
            pic.setGoodsId(good.getId());
            ProductGoodsPicture productGoodsPicture = pictureMapper.selectOne(pic);
            good.setPic(productGoodsPicture);
        });
        return page;
    }

    /**
     * 企业门户的商品
     * 通过商家ID 获取 商家的商品  包括 产品图片 名称  价格   品牌
     * @param memberId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> listProductByMemberId(Integer memberId, Integer pageNo, Integer pageSize) {
        Example example = new Example(ProductGoods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eipMemberId",memberId);
        PageHelper.startPage(pageNo,pageSize);
        Page<ProductGoods> page = (Page<ProductGoods>)productGoodsMapper.selectByExample(example);
        List<ProductGoods> goodsList = page.getResult();
        List<Map<Object,Object>> listMap = new ArrayList<Map<Object,Object>>();
        goodsList.forEach(goods -> {
            BeanMap beanMap = new BeanMap(goods);
            Map<Object,Object> map = new HashMap<Object,Object>();
            map.putAll(beanMap);
            map.remove("class");
            map.remove("isRecommend");
            map.remove("salesVolume");
            map.remove("stock");
            ProductAttributeOptionRelation option = new ProductAttributeOptionRelation();
            option.setGoodsId(goods.getId());
            option.setAttributeName("品牌");
            option = productAttributeOptionRelationMapper.selectOne(option);
            Map<Object,Object> mapAttribute = new HashMap<Object,Object>();
            mapAttribute.put("attributeName","品牌");
            if(option!=null){
                mapAttribute.put("optionName",option.getAttributeOptionName());
            }else{
                mapAttribute.put("optionName","其他");
            }
            map.put("attribute",mapAttribute);
            //图片
            ProductGoodsPicture productGoodsPicture = new ProductGoodsPicture();
            productGoodsPicture.setGoodsId(goods.getId());
            productGoodsPicture = productGoodsPictureMapper.selectOne(productGoodsPicture);
            map.put("pic",productGoodsPicture.getPicturePath());

            listMap.add(map);
        });

        Map<String,Object> resMap = new HashMap<String,Object>();
        resMap.put("data",listMap);
        resMap.put("totalNum",page.getTotal());

        return resMap;
    }

    /**
     * 通过货品ID 获取 货品信息 ：图片   名称   价格   单位  自营   推荐
     * @param goodsId
     * @return
     */
    @Override
    public Map<Object, Object> getProductGoodsById(Integer goodsId) {
        Map<Object,Object> map = new HashMap<Object,Object>();
        ProductGoods good = productGoodsMapper.selectByPrimaryKey(goodsId);
        BeanMap beanMap = new BeanMap(good);
        map.putAll(beanMap);

        ProductGoodsPicture picture = new ProductGoodsPicture();
        picture.setGoodsId(goodsId);
        picture = productGoodsPictureMapper.selectOne(picture);
        map.put("pic",picture.getPicturePath());
        map.remove("class");
        return map;
    }

    /**
     *  实时增减收藏产品数量
     * @param goodsId  货品表的id
     * @param status   状态：add:新增收藏产品; del:
     * @return
     */
    public void addDelCollectionGoods(Integer goodsId,String status){
        //根据主键查出货品信息
        ProductGoods productGoods = productGoodsMapper.selectByPrimaryKey(goodsId);
        Integer collectNum = productGoods.getCollectNum();
        if(null==collectNum||collectNum==0){
            collectNum = 0;
        }
        if(StringUtils.equals(status,"add")){//状态是新增收藏产品时，产品收藏数量+1
            collectNum+=1;
        }else if(StringUtils.equals(status,"del")){//状态是删除收藏产品时，产品收藏数量-1
            collectNum-=1;
        }
        //根据goodsId修改该货品的收藏数量
        Example example = new Example(ProductGoods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",goodsId);
        ProductGoods productGoods1 = new ProductGoods();
        productGoods1.setCollectNum(collectNum);
        productGoodsMapper.updateByExampleSelective(productGoods1,example);

    }

    /**
     * 通过货品ID 获取该货品的详情页所有的信息
     * @param goodsId
     * @return
     */
    @Override
    public QzhResult getProductDetailByGoodsId(HttpServletRequest request,Integer goodsId) {
        Map<Object,Object> map = new HashMap<Object,Object>();
        try {
            ProductGoods productGoods = productGoodsMapper.selectByPrimaryKey(goodsId);
            map.put("goods",productGoods);
            //图片
            ProductGoodsPicture picture = new ProductGoodsPicture();
            picture.setGoodsId(goodsId);
            picture = pictureMapper.selectOne(picture);
            map.put("picture",picture);
            //详情
            ProductGoodsDetails goodsDetails = new ProductGoodsDetails();
            goodsDetails.setGoodsId(goodsId);
            goodsDetails = goodsDetailsMapper.selectOne(goodsDetails);
            map.put("detail",goodsDetails);

            //产品参数
            ProductAttributeOptionRelation attributeOptionRelation = new ProductAttributeOptionRelation();
            attributeOptionRelation.setGoodsId(goodsId);
            List<ProductAttributeOptionRelation> attOptionList = productAttributeOptionRelationMapper.select(attributeOptionRelation);
            map.put("attOptions",attOptionList);
            //产品规格
            Product product = new Product();
            product.setGoodsId(goodsId);
            List<Product> productList = productMapper.select(product);
            List<ProductSpecOptionRelation> productSpecOptionRelationsS = new ArrayList<ProductSpecOptionRelation>();
            productList.forEach(pro -> {
                Example example1 = new Example(ProductSpecOptionRelation.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("productId",pro.getId());
                List<ProductSpecOptionRelation> productSpecOptionRelations = productSpecOptionRelationMapper.selectByExample(example1);
                productSpecOptionRelationsS.addAll(productSpecOptionRelations);
            });
            Map<String, List<ProductSpecOptionRelation>> groupedSpec =
                    productSpecOptionRelationsS.stream().collect(Collectors.groupingBy(ProductSpecOptionRelation::getSpecName));
            Set<String> keys = groupedSpec.keySet();
            Iterator<String> iterator = keys.iterator();
            List<Map<String,Object>> map_spec = new ArrayList<Map<String,Object>>();
            while(iterator.hasNext()) {
                String key = iterator.next();
                List<ProductSpecOptionRelation> relations = groupedSpec.get(key);
                Map<String, List<ProductSpecOptionRelation>> options = relations.stream().collect(Collectors.groupingBy(ProductSpecOptionRelation::getSpecOptionName));

                Set<String> optionKeys = options.keySet();
                Iterator<String> iteratorOption = optionKeys.iterator();
                List<Map<String, Object>> optionMapList = new ArrayList<Map<String, Object>>();
                while (iteratorOption.hasNext()) {
                    String optionStr = iteratorOption.next();
                    List<ProductSpecOptionRelation> optionNames = options.get(optionStr);
                    String productIds = "";
                    for (ProductSpecOptionRelation optionName : optionNames) {
                        productIds = productIds + optionName.getProductId() + ",";
                    }
                    if (!com.huidong.qzh.util.common.util.StringUtils.equalsNull(productIds)) {
                        productIds = productIds.substring(0, productIds.length() - 1);
                    }
                    Map<String, Object> optionMap = new HashMap<String, Object>();
                    optionMap.put("option", optionStr);
                    optionMap.put("productIds", productIds);
                    optionMapList.add(optionMap);
                }

                Map<String, Object> mapList = new HashMap<String, Object>();
                mapList.put("specName", key);
                mapList.put("option", optionMapList);
                map_spec.add(mapList);
            }
            map.put("specOptions",map_spec);
            //评论   一条记录
            DBCollection dbCollection = mongoTemplate.getCollection("product_comment");
            BasicDBObject query = new BasicDBObject();
            query.put("goodsId", goodsId);
            DBCursor cursor = dbCollection.find(query).sort(new BasicDBObject("createTime", -1)).skip(0).limit(1);
            List<DBObject> list = new ArrayList<DBObject>();
            while (cursor.hasNext()){
                DBObject next = cursor.next();
                next.put("_id",next.get("_id").toString());
                list.add(next);
            }
            int count = dbCollection.find(query).count();

            Map<String,Object> map_comment = new HashMap<String,Object>();
            map_comment.put("totalNum",count);
            map_comment.put("data",list);
            map.put("comment",map_comment);
            //店铺统计
            ShopStatistics shopStatistics = new ShopStatistics();
            shopStatistics.setMemberId(productGoods.getEipMemberId());
            shopStatistics = shopStatisticsMapper.selectOne(shopStatistics);
            Map<Object,Object> map_shop = new HashMap<Object,Object>();
            BeanMap beanMap_store = new BeanMap(shopStatistics);
            map_shop.putAll(beanMap_store);
            map_shop.remove("class");
            //map.put("shop",shopStatistics);
            String memberLevel = "普通会员";//会员等级
            String storeLogo = "";//店铺图片
            String shortName = "";//店铺等级
            //判断店铺是否被关注   该商品是否被收藏 ----登陆状态下
            Map<Object,Object> map_land = new HashMap<Object,Object>();
            QzhResult land = commonService.isLand(request);
            Integer attentionStore = 0;
            Integer collentProduct = 0;
            if(land.getStatus()==200){
                Map<Object,Object> data = (Map<Object,Object>)land.getData();

                Integer memberId = Integer.parseInt(data.get("memberId").toString());
                Integer id = Integer.parseInt(data.get("id").toString());
                //获取店铺信息
                QzhResult store = commonService.getStoreByMemberId(memberId);
                if(store.getStatus()==200){
                    Map<Object,Object> storeMap = (Map<Object,Object>)store.getData();
                    storeLogo = storeMap.get("storeLogo").toString();
                    String memberLevel0 = storeMap.get("memberLevel").toString();
                    if(StringUtils.isNotBlank(memberLevel0)){
                        memberLevel = memberLevel0;
                    }
                    shortName = storeMap.get("shortName").toString();

                    QzhResult qzhResult_store = commonService.isAttentionStore(id, Integer.parseInt(storeMap.get("id").toString()));
                    if(qzhResult_store.getStatus()==200){
                        attentionStore = (Integer)qzhResult_store.getData();
                    }
                }
                //收藏产品
                QzhResult qzhResult_goods = commonService.isCollectProduct(id, goodsId);
                if(qzhResult_goods.getStatus()==200){
                    collentProduct = (Integer)qzhResult_goods.getData();
                }
            }
            map_land.put("attentionStore",attentionStore);
            map_land.put("collentProduct",collentProduct);

            //补充店铺信息
            map_shop.put("shortName",shortName);
            map_shop.put("memberLevel",memberLevel);
            map_shop.put("storeLogo",storeLogo);
            map.put("shop",map_shop);

            map.put("attentionCollect",map_land);

            return QzhResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }

    }

    /**
     * 通过 名称  价格  发布与否   分类与否 搜索某商家商品
     * @param info
     * @return
     */
    @Override
    public QzhResult listGoodsByParam(String info, Integer pageNo, Integer PageSize,Integer memberId) {
        try {
            Example example = new Example(ProductGoods.class);
            Example.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(info)){
                Map<String,Object> map = (Map<String,Object>) JSON.parse(info);
                //产品名称
                Object goodsName = map.get("goodsName");
                if(goodsName!=null){
                    criteria.andLike("goodsName","%"+goodsName.toString()+"%");
                }
                //价格区间
                Object minPrice = map.get("minPrice");
                if(minPrice!=null){
                    BigDecimal minPrice1 = new BigDecimal(minPrice.toString());
                    criteria.andGreaterThanOrEqualTo("fixedPrice",minPrice1);//大于等于
                }
                Object maxPrice = map.get("maxPrice");
                if(maxPrice!=null){
                    BigDecimal maxPrice1 = new BigDecimal(maxPrice.toString());
                    criteria.andLessThanOrEqualTo("fixedPrice",maxPrice1);//小于等于
                }
                //状态 : 是否发布
                Object isPublish = map.get("isPublish");
                if(isPublish!=null){
                    if("1".equals(isPublish.toString())){
                        criteria.andEqualTo("isPublish",Integer.parseInt(isPublish.toString()));
                    }else{
                        criteria.andNotEqualTo("isPublish",1);
                    }

                }
                //是否已分类
                Object isCustomCategory = map.get("isCustomCategory");
                if(isCustomCategory!=null){
                    if(StringUtils.equals(isCustomCategory.toString(),"1")){
                        criteria.andIsNotNull("customCategoryId");
                    }else{
                        criteria.andIsNull("customCategoryId");
                    }
                }
            }

            //商家
            if(memberId!=null){
                criteria.andEqualTo("eipMemberId",memberId);
            }

            PageHelper.startPage(pageNo,PageSize);
            Page<ProductGoods> productGoods = (Page<ProductGoods>)productGoodsMapper.selectByExample(example);
            //图片 名称  价格  分类  是否发布
            Map<Object,Object> qzhMap = new HashMap<>();
            List<Map<Object,Object>> mapList = new ArrayList<>();
            productGoods.forEach(goods -> {
                Map<Object,Object> goodsMap = new HashMap<>();
                BeanMap beanMap_goods = new BeanMap(goods);
                goodsMap.putAll(beanMap_goods);
                goodsMap.remove("class");
                //图片
                ProductGoodsPicture goodsPicture = new ProductGoodsPicture();
                goodsPicture.setGoodsId(goods.getId());
                ProductGoodsPicture productGoodsPicture = productGoodsPictureMapper.selectOne(goodsPicture);
                String picPath = productGoodsPicture.getPicturePath();
                if(StringUtils.isNotBlank(picPath)){
                    picPath = picPath.split(",")[0];
                }else{
                    picPath = "";
                }
                goodsMap.put("pic",picPath);
                mapList.add(goodsMap);
            });
            int pages = productGoods.getPages();
            long total = productGoods.getTotal();
            qzhMap.put("totalPage",pages);
            qzhMap.put("totalCount",total);
            qzhMap.put("list",mapList);
            return QzhResult.ok(qzhMap);
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
    @Override
    public QzhResult updateGoodsCategoryId(String goodsIds, String categoryIds) {
        try {
            if(StringUtils.isNotBlank(goodsIds)){
                String[] split_goodsId = goodsIds.split(",");
                for(int g=0;g<split_goodsId.length;g++){
                    if(StringUtils.isNotBlank(split_goodsId[g])){
                        ProductGoods goods = productGoodsMapper.selectByPrimaryKey(Integer.parseInt(split_goodsId[g]));
                        goods.setCategoryId(categoryIds);
                        productGoodsMapper.updateByPrimaryKey(goods);
                    }
                }
                return QzhResult.ok("操作成功");
            }else{
                return QzhResult.error("参数异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }


}
