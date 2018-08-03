package com.eric.education.model;

import java.util.ArrayList;
import java.util.List;

public class PermissionQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public PermissionQuery() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andPerIdIsNull() {
            addCriterion("per_id is null");
            return (Criteria) this;
        }

        public Criteria andPerIdIsNotNull() {
            addCriterion("per_id is not null");
            return (Criteria) this;
        }

        public Criteria andPerIdEqualTo(Long value) {
            addCriterion("per_id =", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotEqualTo(Long value) {
            addCriterion("per_id <>", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdGreaterThan(Long value) {
            addCriterion("per_id >", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("per_id >=", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdLessThan(Long value) {
            addCriterion("per_id <", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdLessThanOrEqualTo(Long value) {
            addCriterion("per_id <=", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdIn(List<Long> values) {
            addCriterion("per_id in", values, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotIn(List<Long> values) {
            addCriterion("per_id not in", values, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdBetween(Long value1, Long value2) {
            addCriterion("per_id between", value1, value2, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotBetween(Long value1, Long value2) {
            addCriterion("per_id not between", value1, value2, "perId");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIsNull() {
            addCriterion("url_address is null");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIsNotNull() {
            addCriterion("url_address is not null");
            return (Criteria) this;
        }

        public Criteria andUrlAddressEqualTo(String value) {
            addCriterion("url_address =", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotEqualTo(String value) {
            addCriterion("url_address <>", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressGreaterThan(String value) {
            addCriterion("url_address >", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressGreaterThanOrEqualTo(String value) {
            addCriterion("url_address >=", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLessThan(String value) {
            addCriterion("url_address <", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLessThanOrEqualTo(String value) {
            addCriterion("url_address <=", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLike(String value) {
            addCriterion("url_address like", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotLike(String value) {
            addCriterion("url_address not like", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIn(List<String> values) {
            addCriterion("url_address in", values, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotIn(List<String> values) {
            addCriterion("url_address not in", values, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressBetween(String value1, String value2) {
            addCriterion("url_address between", value1, value2, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotBetween(String value1, String value2) {
            addCriterion("url_address not between", value1, value2, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlDescIsNull() {
            addCriterion("url_desc is null");
            return (Criteria) this;
        }

        public Criteria andUrlDescIsNotNull() {
            addCriterion("url_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUrlDescEqualTo(String value) {
            addCriterion("url_desc =", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescNotEqualTo(String value) {
            addCriterion("url_desc <>", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescGreaterThan(String value) {
            addCriterion("url_desc >", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescGreaterThanOrEqualTo(String value) {
            addCriterion("url_desc >=", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescLessThan(String value) {
            addCriterion("url_desc <", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescLessThanOrEqualTo(String value) {
            addCriterion("url_desc <=", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescLike(String value) {
            addCriterion("url_desc like", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescNotLike(String value) {
            addCriterion("url_desc not like", value, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescIn(List<String> values) {
            addCriterion("url_desc in", values, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescNotIn(List<String> values) {
            addCriterion("url_desc not in", values, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescBetween(String value1, String value2) {
            addCriterion("url_desc between", value1, value2, "urlDesc");
            return (Criteria) this;
        }

        public Criteria andUrlDescNotBetween(String value1, String value2) {
            addCriterion("url_desc not between", value1, value2, "urlDesc");
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