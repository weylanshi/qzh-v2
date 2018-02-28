package com.huidong.qzh.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;

@Document(collection = "enterprise_type")
public class  EnterpriseType{
    @JsonIgnore
    private String id;
    @Field("type_name")
    private String typeName;
    @JsonIgnore
    private String status;

    public EnterpriseType() {
    }

    public EnterpriseType(String id, String typeName, String status) {
        this.id = id;
        this.typeName = typeName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}