package com.huidong.qzh.portal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApAlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApAlbumExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNull() {
            addCriterion("accountId is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("accountId is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(Integer value) {
            addCriterion("accountId =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(Integer value) {
            addCriterion("accountId <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(Integer value) {
            addCriterion("accountId >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("accountId >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(Integer value) {
            addCriterion("accountId <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("accountId <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<Integer> values) {
            addCriterion("accountId in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<Integer> values) {
            addCriterion("accountId not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(Integer value1, Integer value2) {
            addCriterion("accountId between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("accountId not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAlbumnameIsNull() {
            addCriterion("albumName is null");
            return (Criteria) this;
        }

        public Criteria andAlbumnameIsNotNull() {
            addCriterion("albumName is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumnameEqualTo(String value) {
            addCriterion("albumName =", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotEqualTo(String value) {
            addCriterion("albumName <>", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameGreaterThan(String value) {
            addCriterion("albumName >", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameGreaterThanOrEqualTo(String value) {
            addCriterion("albumName >=", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameLessThan(String value) {
            addCriterion("albumName <", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameLessThanOrEqualTo(String value) {
            addCriterion("albumName <=", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameLike(String value) {
            addCriterion("albumName like", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotLike(String value) {
            addCriterion("albumName not like", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameIn(List<String> values) {
            addCriterion("albumName in", values, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotIn(List<String> values) {
            addCriterion("albumName not in", values, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameBetween(String value1, String value2) {
            addCriterion("albumName between", value1, value2, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotBetween(String value1, String value2) {
            addCriterion("albumName not between", value1, value2, "albumname");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andAlbumdescIsNull() {
            addCriterion("albumDesc is null");
            return (Criteria) this;
        }

        public Criteria andAlbumdescIsNotNull() {
            addCriterion("albumDesc is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumdescEqualTo(String value) {
            addCriterion("albumDesc =", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescNotEqualTo(String value) {
            addCriterion("albumDesc <>", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescGreaterThan(String value) {
            addCriterion("albumDesc >", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescGreaterThanOrEqualTo(String value) {
            addCriterion("albumDesc >=", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescLessThan(String value) {
            addCriterion("albumDesc <", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescLessThanOrEqualTo(String value) {
            addCriterion("albumDesc <=", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescLike(String value) {
            addCriterion("albumDesc like", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescNotLike(String value) {
            addCriterion("albumDesc not like", value, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescIn(List<String> values) {
            addCriterion("albumDesc in", values, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescNotIn(List<String> values) {
            addCriterion("albumDesc not in", values, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescBetween(String value1, String value2) {
            addCriterion("albumDesc between", value1, value2, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andAlbumdescNotBetween(String value1, String value2) {
            addCriterion("albumDesc not between", value1, value2, "albumdesc");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlIsNull() {
            addCriterion("lastPictureUrl is null");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlIsNotNull() {
            addCriterion("lastPictureUrl is not null");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlEqualTo(String value) {
            addCriterion("lastPictureUrl =", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlNotEqualTo(String value) {
            addCriterion("lastPictureUrl <>", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlGreaterThan(String value) {
            addCriterion("lastPictureUrl >", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlGreaterThanOrEqualTo(String value) {
            addCriterion("lastPictureUrl >=", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlLessThan(String value) {
            addCriterion("lastPictureUrl <", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlLessThanOrEqualTo(String value) {
            addCriterion("lastPictureUrl <=", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlLike(String value) {
            addCriterion("lastPictureUrl like", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlNotLike(String value) {
            addCriterion("lastPictureUrl not like", value, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlIn(List<String> values) {
            addCriterion("lastPictureUrl in", values, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlNotIn(List<String> values) {
            addCriterion("lastPictureUrl not in", values, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlBetween(String value1, String value2) {
            addCriterion("lastPictureUrl between", value1, value2, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andLastpictureurlNotBetween(String value1, String value2) {
            addCriterion("lastPictureUrl not between", value1, value2, "lastpictureurl");
            return (Criteria) this;
        }

        public Criteria andIsshowIsNull() {
            addCriterion("isShow is null");
            return (Criteria) this;
        }

        public Criteria andIsshowIsNotNull() {
            addCriterion("isShow is not null");
            return (Criteria) this;
        }

        public Criteria andIsshowEqualTo(Integer value) {
            addCriterion("isShow =", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotEqualTo(Integer value) {
            addCriterion("isShow <>", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowGreaterThan(Integer value) {
            addCriterion("isShow >", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("isShow >=", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowLessThan(Integer value) {
            addCriterion("isShow <", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowLessThanOrEqualTo(Integer value) {
            addCriterion("isShow <=", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowIn(List<Integer> values) {
            addCriterion("isShow in", values, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotIn(List<Integer> values) {
            addCriterion("isShow not in", values, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowBetween(Integer value1, Integer value2) {
            addCriterion("isShow between", value1, value2, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotBetween(Integer value1, Integer value2) {
            addCriterion("isShow not between", value1, value2, "isshow");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}