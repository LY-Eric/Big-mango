package com.ynet.finmall.merchant.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsWorkflowQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public EsWorkflowQuery() {
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

        public Criteria andWorkflowIdIsNull() {
            addCriterion("workflow_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdIsNotNull() {
            addCriterion("workflow_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdEqualTo(String value) {
            addCriterion("workflow_id =", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotEqualTo(String value) {
            addCriterion("workflow_id <>", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdGreaterThan(String value) {
            addCriterion("workflow_id >", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_id >=", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdLessThan(String value) {
            addCriterion("workflow_id <", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdLessThanOrEqualTo(String value) {
            addCriterion("workflow_id <=", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdLike(String value) {
            addCriterion("workflow_id like", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotLike(String value) {
            addCriterion("workflow_id not like", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdIn(List<String> values) {
            addCriterion("workflow_id in", values, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotIn(List<String> values) {
            addCriterion("workflow_id not in", values, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdBetween(String value1, String value2) {
            addCriterion("workflow_id between", value1, value2, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotBetween(String value1, String value2) {
            addCriterion("workflow_id not between", value1, value2, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeIsNull() {
            addCriterion("workflow_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeIsNotNull() {
            addCriterion("workflow_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeEqualTo(String value) {
            addCriterion("workflow_type =", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotEqualTo(String value) {
            addCriterion("workflow_type <>", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeGreaterThan(String value) {
            addCriterion("workflow_type >", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_type >=", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeLessThan(String value) {
            addCriterion("workflow_type <", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeLessThanOrEqualTo(String value) {
            addCriterion("workflow_type <=", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeLike(String value) {
            addCriterion("workflow_type like", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotLike(String value) {
            addCriterion("workflow_type not like", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeIn(List<String> values) {
            addCriterion("workflow_type in", values, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotIn(List<String> values) {
            addCriterion("workflow_type not in", values, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeBetween(String value1, String value2) {
            addCriterion("workflow_type between", value1, value2, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotBetween(String value1, String value2) {
            addCriterion("workflow_type not between", value1, value2, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameIsNull() {
            addCriterion("workflow_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameIsNotNull() {
            addCriterion("workflow_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameEqualTo(String value) {
            addCriterion("workflow_name =", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotEqualTo(String value) {
            addCriterion("workflow_name <>", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameGreaterThan(String value) {
            addCriterion("workflow_name >", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_name >=", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameLessThan(String value) {
            addCriterion("workflow_name <", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameLessThanOrEqualTo(String value) {
            addCriterion("workflow_name <=", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameLike(String value) {
            addCriterion("workflow_name like", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotLike(String value) {
            addCriterion("workflow_name not like", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameIn(List<String> values) {
            addCriterion("workflow_name in", values, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotIn(List<String> values) {
            addCriterion("workflow_name not in", values, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameBetween(String value1, String value2) {
            addCriterion("workflow_name between", value1, value2, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotBetween(String value1, String value2) {
            addCriterion("workflow_name not between", value1, value2, "workflowName");
            return (Criteria) this;
        }

        public Criteria andIsCommonIsNull() {
            addCriterion("is_common is null");
            return (Criteria) this;
        }

        public Criteria andIsCommonIsNotNull() {
            addCriterion("is_common is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommonEqualTo(String value) {
            addCriterion("is_common =", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotEqualTo(String value) {
            addCriterion("is_common <>", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonGreaterThan(String value) {
            addCriterion("is_common >", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonGreaterThanOrEqualTo(String value) {
            addCriterion("is_common >=", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonLessThan(String value) {
            addCriterion("is_common <", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonLessThanOrEqualTo(String value) {
            addCriterion("is_common <=", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonLike(String value) {
            addCriterion("is_common like", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotLike(String value) {
            addCriterion("is_common not like", value, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonIn(List<String> values) {
            addCriterion("is_common in", values, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotIn(List<String> values) {
            addCriterion("is_common not in", values, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonBetween(String value1, String value2) {
            addCriterion("is_common between", value1, value2, "isCommon");
            return (Criteria) this;
        }

        public Criteria andIsCommonNotBetween(String value1, String value2) {
            addCriterion("is_common not between", value1, value2, "isCommon");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(String value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(String value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(String value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(String value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(String value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLike(String value) {
            addCriterion("admin_id like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotLike(String value) {
            addCriterion("admin_id not like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<String> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<String> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(String value1, String value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(String value1, String value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
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