package com.huidong.qzh.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "industry_type")
public class IndustryType {

    @JsonIgnore
    private String id;
    private String key;
    private String value;
    private String lv;
    private String superKey;

    public IndustryType() {
    }

    public IndustryType(String key, String value, String lv, String superKey) {
        this.key = key;
        this.value = value;
        this.lv = lv;
        this.superKey = superKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public String getSuperKey() {
        return superKey;
    }

    public void setSuperKey(String superKey) {
        this.superKey = superKey;
    }
}
