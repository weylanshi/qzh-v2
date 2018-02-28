package com.huidong.qzh.nonstandard.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "printing_price")
public class PrintingPrice {

    @Field("class_name")
    private String className;//产品类名
    @Field("product_num")
    private Integer productNum;//产品数量
    private Integer price;//价格
    @Field("paper_num")
    private Integer paperNum;//纸张数（32开、16开、8开、4开）
    @Field("is_double")
    private String isDouble;//是否是单双面
    @Field("single_price")
    private Double singlePrice;


    public PrintingPrice() {
    }

    public PrintingPrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(Integer paperNum) {
        this.paperNum = paperNum;
    }

    public String getIsDouble() {
        return isDouble;
    }

    public void setIsDouble(String isDouble) {
        this.isDouble = isDouble;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }
}
