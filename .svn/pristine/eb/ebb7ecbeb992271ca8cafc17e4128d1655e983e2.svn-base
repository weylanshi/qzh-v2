package com.huidong.qzh.nonstandard.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "material_price")
public class MaterialPrice {

    private String id;
    @Field("class_name")
    private String className;
    @Field("paper_name")
    private String paperName;
    private Double width;
    private Double high;
    private Double price;

    public MaterialPrice() {
    }

    public MaterialPrice(String id, String className, String paperName, Double width, Double high, Double price) {
        this.id = id;
        this.className = className;
        this.paperName = paperName;
        this.width = width;
        this.high = high;
        this.price = price;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
