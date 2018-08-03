package com.ynet.finmall.goods.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsWorkflowDetailQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public EsWorkflowDetailQuery() {
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

        public Criteria andWorkflowDetailIdIsNull() {
            addCriterion("workflow_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdIsNotNull() {
            addCriterion("workflow_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdEqualTo(String value) {
            addCriterion("workflow_detail_id =", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdNotEqualTo(String value) {
            addCriterion("workflow_detail_id <>", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdGreaterThan(String value) {
            addCriterion("workflow_detail_id >", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_detail_id >=", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdLessThan(String value) {
            addCriterion("workflow_detail_id <", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdLessThanOrEqualTo(String value) {
            addCriterion("workflow_detail_id <=", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdLike(String value) {
            addCriterion("workflow_detail_id like", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdNotLike(String value) {
            addCriterion("workflow_detail_id not like", value, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdIn(List<String> values) {
            addCriterion("workflow_detail_id in", values, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdNotIn(List<String> values) {
            addCriterion("workflow_detail_id not in", values, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdBetween(String value1, String value2) {
            addCriterion("workflow_detail_id between", value1, value2, "workflowDetailId");
            return (Criteria) this;
        }

        public Criteria andWorkflowDetailIdNotBetween(String value1, String value2) {
            addCriterion("workflow_detail_id not between", value1, value2, "workflowDetailId");
            return (Criteria) this;
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

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNull() {
            addCriterion("step_type is null");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNotNull() {
            addCriterion("step_type is not null");
            return (Criteria) this;
        }

        public Criteria andStepTypeEqualTo(String value) {
            addCriterion("step_type =", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotEqualTo(String value) {
            addCriterion("step_type <>", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThan(String value) {
            addCriterion("step_type >", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThanOrEqualTo(String value) {
            addCriterion("step_type >=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThan(String value) {
            addCriterion("step_type <", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThanOrEqualTo(String value) {
            addCriterion("step_type <=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLike(String value) {
            addCriterion("step_type like", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotLike(String value) {
            addCriterion("step_type not like", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeIn(List<String> values) {
            addCriterion("step_type in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotIn(List<String> values) {
            addCriterion("step_type not in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeBetween(String value1, String value2) {
            addCriterion("step_type between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotBetween(String value1, String value2) {
            addCriterion("step_type not between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNull() {
            addCriterion("step_code is null");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNotNull() {
            addCriterion("step_code is not null");
            return (Criteria) this;
        }

        public Criteria andStepCodeEqualTo(String value) {
            addCriterion("step_code =", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotEqualTo(String value) {
            addCriterion("step_code <>", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThan(String value) {
            addCriterion("step_code >", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("step_code >=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThan(String value) {
            addCriterion("step_code <", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThanOrEqualTo(String value) {
            addCriterion("step_code <=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLike(String value) {
            addCriterion("step_code like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotLike(String value) {
            addCriterion("step_code not like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeIn(List<String> values) {
            addCriterion("step_code in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotIn(List<String> values) {
            addCriterion("step_code not in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeBetween(String value1, String value2) {
            addCriterion("step_code between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotBetween(String value1, String value2) {
            addCriterion("step_code not between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andIsRollbackIsNull() {
            addCriterion("is_rollback is null");
            return (Criteria) this;
        }

        public Criteria andIsRollbackIsNotNull() {
            addCriterion("is_rollback is not null");
            return (Criteria) this;
        }

        public Criteria andIsRollbackEqualTo(String value) {
            addCriterion("is_rollback =", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackNotEqualTo(String value) {
            addCriterion("is_rollback <>", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackGreaterThan(String value) {
            addCriterion("is_rollback >", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackGreaterThanOrEqualTo(String value) {
            addCriterion("is_rollback >=", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackLessThan(String value) {
            addCriterion("is_rollback <", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackLessThanOrEqualTo(String value) {
            addCriterion("is_rollback <=", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackLike(String value) {
            addCriterion("is_rollback like", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackNotLike(String value) {
            addCriterion("is_rollback not like", value, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackIn(List<String> values) {
            addCriterion("is_rollback in", values, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackNotIn(List<String> values) {
            addCriterion("is_rollback not in", values, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackBetween(String value1, String value2) {
            addCriterion("is_rollback between", value1, value2, "isRollback");
            return (Criteria) this;
        }

        public Criteria andIsRollbackNotBetween(String value1, String value2) {
            addCriterion("is_rollback not between", value1, value2, "isRollback");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeIsNull() {
            addCriterion("rollback_step_code is null");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeIsNotNull() {
            addCriterion("rollback_step_code is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeEqualTo(String value) {
            addCriterion("rollback_step_code =", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeNotEqualTo(String value) {
            addCriterion("rollback_step_code <>", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeGreaterThan(String value) {
            addCriterion("rollback_step_code >", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rollback_step_code >=", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeLessThan(String value) {
            addCriterion("rollback_step_code <", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeLessThanOrEqualTo(String value) {
            addCriterion("rollback_step_code <=", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeLike(String value) {
            addCriterion("rollback_step_code like", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeNotLike(String value) {
            addCriterion("rollback_step_code not like", value, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeIn(List<String> values) {
            addCriterion("rollback_step_code in", values, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeNotIn(List<String> values) {
            addCriterion("rollback_step_code not in", values, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeBetween(String value1, String value2) {
            addCriterion("rollback_step_code between", value1, value2, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andRollbackStepCodeNotBetween(String value1, String value2) {
            addCriterion("rollback_step_code not between", value1, value2, "rollbackStepCode");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdIsNull() {
            addCriterion("parent_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdIsNotNull() {
            addCriterion("parent_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdEqualTo(String value) {
            addCriterion("parent_detail_id =", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdNotEqualTo(String value) {
            addCriterion("parent_detail_id <>", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdGreaterThan(String value) {
            addCriterion("parent_detail_id >", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_detail_id >=", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdLessThan(String value) {
            addCriterion("parent_detail_id <", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdLessThanOrEqualTo(String value) {
            addCriterion("parent_detail_id <=", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdLike(String value) {
            addCriterion("parent_detail_id like", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdNotLike(String value) {
            addCriterion("parent_detail_id not like", value, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdIn(List<String> values) {
            addCriterion("parent_detail_id in", values, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdNotIn(List<String> values) {
            addCriterion("parent_detail_id not in", values, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdBetween(String value1, String value2) {
            addCriterion("parent_detail_id between", value1, value2, "parentDetailId");
            return (Criteria) this;
        }

        public Criteria andParentDetailIdNotBetween(String value1, String value2) {
            addCriterion("parent_detail_id not between", value1, value2, "parentDetailId");
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

        public Criteria andSuccessStatusIsNull() {
            addCriterion("success_status is null");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusIsNotNull() {
            addCriterion("success_status is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusEqualTo(String value) {
            addCriterion("success_status =", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusNotEqualTo(String value) {
            addCriterion("success_status <>", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusGreaterThan(String value) {
            addCriterion("success_status >", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("success_status >=", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusLessThan(String value) {
            addCriterion("success_status <", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusLessThanOrEqualTo(String value) {
            addCriterion("success_status <=", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusLike(String value) {
            addCriterion("success_status like", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusNotLike(String value) {
            addCriterion("success_status not like", value, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusIn(List<String> values) {
            addCriterion("success_status in", values, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusNotIn(List<String> values) {
            addCriterion("success_status not in", values, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusBetween(String value1, String value2) {
            addCriterion("success_status between", value1, value2, "successStatus");
            return (Criteria) this;
        }

        public Criteria andSuccessStatusNotBetween(String value1, String value2) {
            addCriterion("success_status not between", value1, value2, "successStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusIsNull() {
            addCriterion("fail_status is null");
            return (Criteria) this;
        }

        public Criteria andFailStatusIsNotNull() {
            addCriterion("fail_status is not null");
            return (Criteria) this;
        }

        public Criteria andFailStatusEqualTo(String value) {
            addCriterion("fail_status =", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusNotEqualTo(String value) {
            addCriterion("fail_status <>", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusGreaterThan(String value) {
            addCriterion("fail_status >", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusGreaterThanOrEqualTo(String value) {
            addCriterion("fail_status >=", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusLessThan(String value) {
            addCriterion("fail_status <", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusLessThanOrEqualTo(String value) {
            addCriterion("fail_status <=", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusLike(String value) {
            addCriterion("fail_status like", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusNotLike(String value) {
            addCriterion("fail_status not like", value, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusIn(List<String> values) {
            addCriterion("fail_status in", values, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusNotIn(List<String> values) {
            addCriterion("fail_status not in", values, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusBetween(String value1, String value2) {
            addCriterion("fail_status between", value1, value2, "failStatus");
            return (Criteria) this;
        }

        public Criteria andFailStatusNotBetween(String value1, String value2) {
            addCriterion("fail_status not between", value1, value2, "failStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusIsNull() {
            addCriterion("rollback_status is null");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusIsNotNull() {
            addCriterion("rollback_status is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusEqualTo(String value) {
            addCriterion("rollback_status =", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotEqualTo(String value) {
            addCriterion("rollback_status <>", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusGreaterThan(String value) {
            addCriterion("rollback_status >", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusGreaterThanOrEqualTo(String value) {
            addCriterion("rollback_status >=", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusLessThan(String value) {
            addCriterion("rollback_status <", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusLessThanOrEqualTo(String value) {
            addCriterion("rollback_status <=", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusLike(String value) {
            addCriterion("rollback_status like", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotLike(String value) {
            addCriterion("rollback_status not like", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusIn(List<String> values) {
            addCriterion("rollback_status in", values, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotIn(List<String> values) {
            addCriterion("rollback_status not in", values, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusBetween(String value1, String value2) {
            addCriterion("rollback_status between", value1, value2, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotBetween(String value1, String value2) {
            addCriterion("rollback_status not between", value1, value2, "rollbackStatus");
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