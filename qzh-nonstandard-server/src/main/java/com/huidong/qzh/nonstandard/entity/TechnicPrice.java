package com.huidong.qzh.nonstandard.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "technicPrice")
public class TechnicPrice {
    private String id;
    private String className;
    private String technicName;
    private Double width;
    private Double len;
    private Double amount;
    private Integer repeat;
    private Double basePrice;

    public TechnicPrice() {
    }


    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getTechnicName() {
        return technicName;
    }

    public void setTechnicName(String technicName) {
        this.technicName = technicName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLen() {
        return len;
    }

    public void setLen(Double len) {
        this.len = len;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }
}
