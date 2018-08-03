package com.ynet.finmall.merchant.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsWorkflowCheckDetailQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public EsWorkflowCheckDetailQuery() {
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

        public Criteria andWorkflowResultIdIsNull() {
            addCriterion("workflow_result_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdIsNotNull() {
            addCriterion("workflow_result_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdEqualTo(String value) {
            addCriterion("workflow_result_id =", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdNotEqualTo(String value) {
            addCriterion("workflow_result_id <>", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdGreaterThan(String value) {
            addCriterion("workflow_result_id >", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_result_id >=", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdLessThan(String value) {
            addCriterion("workflow_result_id <", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdLessThanOrEqualTo(String value) {
            addCriterion("workflow_result_id <=", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdLike(String value) {
            addCriterion("workflow_result_id like", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdNotLike(String value) {
            addCriterion("workflow_result_id not like", value, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdIn(List<String> values) {
            addCriterion("workflow_result_id in", values, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdNotIn(List<String> values) {
            addCriterion("workflow_result_id not in", values, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdBetween(String value1, String value2) {
            addCriterion("workflow_result_id between", value1, value2, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIdNotBetween(String value1, String value2) {
            addCriterion("workflow_result_id not between", value1, value2, "workflowResultId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(String value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(String value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(String value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(String value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(String value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLike(String value) {
            addCriterion("check_id like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotLike(String value) {
            addCriterion("check_id not like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<String> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<String> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(String value1, String value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(String value1, String value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
            return (Criteria) this;
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

        public Criteria andCurrentStepCodeIsNull() {
            addCriterion("current_step_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeIsNotNull() {
            addCriterion("current_step_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeEqualTo(String value) {
            addCriterion("current_step_code =", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeNotEqualTo(String value) {
            addCriterion("current_step_code <>", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeGreaterThan(String value) {
            addCriterion("current_step_code >", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("current_step_code >=", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeLessThan(String value) {
            addCriterion("current_step_code <", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeLessThanOrEqualTo(String value) {
            addCriterion("current_step_code <=", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeLike(String value) {
            addCriterion("current_step_code like", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeNotLike(String value) {
            addCriterion("current_step_code not like", value, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeIn(List<String> values) {
            addCriterion("current_step_code in", values, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeNotIn(List<String> values) {
            addCriterion("current_step_code not in", values, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeBetween(String value1, String value2) {
            addCriterion("current_step_code between", value1, value2, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCurrentStepCodeNotBetween(String value1, String value2) {
            addCriterion("current_step_code not between", value1, value2, "currentStepCode");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNull() {
            addCriterion("check_result is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("check_result is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("check_result =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("check_result <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("check_result >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("check_result >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("check_result <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("check_result <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("check_result like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("check_result not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("check_result in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("check_result not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("check_result between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("check_result not between", value1, value2, "checkResult");
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

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
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

        public Criteria andStartStatusIsNull() {
            addCriterion("start_status is null");
            return (Criteria) this;
        }

        public Criteria andStartStatusIsNotNull() {
            addCriterion("start_status is not null");
            return (Criteria) this;
        }

        public Criteria andStartStatusEqualTo(String value) {
            addCriterion("start_status =", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotEqualTo(String value) {
            addCriterion("start_status <>", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusGreaterThan(String value) {
            addCriterion("start_status >", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusGreaterThanOrEqualTo(String value) {
            addCriterion("start_status >=", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusLessThan(String value) {
            addCriterion("start_status <", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusLessThanOrEqualTo(String value) {
            addCriterion("start_status <=", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusLike(String value) {
            addCriterion("start_status like", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotLike(String value) {
            addCriterion("start_status not like", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusIn(List<String> values) {
            addCriterion("start_status in", values, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotIn(List<String> values) {
            addCriterion("start_status not in", values, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusBetween(String value1, String value2) {
            addCriterion("start_status between", value1, value2, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotBetween(String value1, String value2) {
            addCriterion("start_status not between", value1, value2, "startStatus");
            return (Criteria) this;
        }

        public Criteria andChannelNoIsNull() {
            addCriterion("channel_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelNoIsNotNull() {
            addCriterion("channel_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNoEqualTo(String value) {
            addCriterion("channel_no =", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotEqualTo(String value) {
            addCriterion("channel_no <>", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoGreaterThan(String value) {
            addCriterion("channel_no >", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_no >=", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoLessThan(String value) {
            addCriterion("channel_no <", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoLessThanOrEqualTo(String value) {
            addCriterion("channel_no <=", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoLike(String value) {
            addCriterion("channel_no like", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotLike(String value) {
            addCriterion("channel_no not like", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoIn(List<String> values) {
            addCriterion("channel_no in", values, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotIn(List<String> values) {
            addCriterion("channel_no not in", values, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoBetween(String value1, String value2) {
            addCriterion("channel_no between", value1, value2, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotBetween(String value1, String value2) {
            addCriterion("channel_no not between", value1, value2, "channelNo");
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