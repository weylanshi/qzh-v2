package com.huidong.qzh.nonstandard.entity;

import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "attribute")
public class Attribute {

    private String id;
    private String className;
    private Integer memberId;
    private String title;
//    private BasicDBObject


    public Attribute() {
    }

    public Attribute(String id, String className, Integer memberId, String title) {
        this.id = id;
        this.className = className;
        this.memberId = memberId;
        this.title = title;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
