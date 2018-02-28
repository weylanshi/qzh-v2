package com.huidong.qzh.standard.mapper;

import com.huidong.qzh.standard.entity.ProductGoods;
import com.huidong.qzh.standard.pojo.ProductGoodsPic;
import com.huidong.qzh.standard.util.MyMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductGoodsMapper extends MyMapper<ProductGoods> {
    /**
     * 联合查询   product_goods    product_goods_picture
     * @return
     */
    @Select("select pg.id ,pg.goods_name,pg.fixed_price, pgp.goods_id,pgp.picture_path from product_goods pg,product_goods_picture pgp where pg.id = pgp.goods_id")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "fixedPrice",column = "fixed_price"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "picturePath",column = "picture_path")
    })
    public List<ProductGoodsPic> listProductGoods();
}