package com.ynet.finmall.merchant.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsWorkflowCheckQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public EsWorkflowCheckQuery() {
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

        public Criteria andParentProjectIdIsNull() {
            addCriterion("parent_project_id is null");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdIsNotNull() {
            addCriterion("parent_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdEqualTo(String value) {
            addCriterion("parent_project_id =", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdNotEqualTo(String value) {
            addCriterion("parent_project_id <>", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdGreaterThan(String value) {
            addCriterion("parent_project_id >", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_project_id >=", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdLessThan(String value) {
            addCriterion("parent_project_id <", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdLessThanOrEqualTo(String value) {
            addCriterion("parent_project_id <=", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdLike(String value) {
            addCriterion("parent_project_id like", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdNotLike(String value) {
            addCriterion("parent_project_id not like", value, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdIn(List<String> values) {
            addCriterion("parent_project_id in", values, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdNotIn(List<String> values) {
            addCriterion("parent_project_id not in", values, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdBetween(String value1, String value2) {
            addCriterion("parent_project_id between", value1, value2, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andParentProjectIdNotBetween(String value1, String value2) {
            addCriterion("parent_project_id not between", value1, value2, "parentProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdIsNull() {
            addCriterion("son_project_id is null");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdIsNotNull() {
            addCriterion("son_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdEqualTo(String value) {
            addCriterion("son_project_id =", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdNotEqualTo(String value) {
            addCriterion("son_project_id <>", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdGreaterThan(String value) {
            addCriterion("son_project_id >", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("son_project_id >=", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdLessThan(String value) {
            addCriterion("son_project_id <", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdLessThanOrEqualTo(String value) {
            addCriterion("son_project_id <=", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdLike(String value) {
            addCriterion("son_project_id like", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdNotLike(String value) {
            addCriterion("son_project_id not like", value, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdIn(List<String> values) {
            addCriterion("son_project_id in", values, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdNotIn(List<String> values) {
            addCriterion("son_project_id not in", values, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdBetween(String value1, String value2) {
            addCriterion("son_project_id between", value1, value2, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andSonProjectIdNotBetween(String value1, String value2) {
            addCriterion("son_project_id not between", value1, value2, "sonProjectId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
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

        public Criteria andNextStepCodeIsNull() {
            addCriterion("next_step_code is null");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeIsNotNull() {
            addCriterion("next_step_code is not null");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeEqualTo(String value) {
            addCriterion("next_step_code =", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeNotEqualTo(String value) {
            addCriterion("next_step_code <>", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeGreaterThan(String value) {
            addCriterion("next_step_code >", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("next_step_code >=", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeLessThan(String value) {
            addCriterion("next_step_code <", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeLessThanOrEqualTo(String value) {
            addCriterion("next_step_code <=", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeLike(String value) {
            addCriterion("next_step_code like", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeNotLike(String value) {
            addCriterion("next_step_code not like", value, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeIn(List<String> values) {
            addCriterion("next_step_code in", values, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeNotIn(List<String> values) {
            addCriterion("next_step_code not in", values, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeBetween(String value1, String value2) {
            addCriterion("next_step_code between", value1, value2, "nextStepCode");
            return (Criteria) this;
        }

        public Criteria andNextStepCodeNotBetween(String value1, String value2) {
            addCriterion("next_step_code not between", value1, value2, "nextStepCode");
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

        public Criteria andNextAuditorIsNull() {
            addCriterion("next_auditor is null");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIsNotNull() {
            addCriterion("next_auditor is not null");
            return (Criteria) this;
        }

        public Criteria andNextAuditorEqualTo(String value) {
            addCriterion("next_auditor =", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorNotEqualTo(String value) {
            addCriterion("next_auditor <>", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorGreaterThan(String value) {
            addCriterion("next_auditor >", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("next_auditor >=", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorLessThan(String value) {
            addCriterion("next_auditor <", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorLessThanOrEqualTo(String value) {
            addCriterion("next_auditor <=", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorLike(String value) {
            addCriterion("next_auditor like", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorNotLike(String value) {
            addCriterion("next_auditor not like", value, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIn(List<String> values) {
            addCriterion("next_auditor in", values, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorNotIn(List<String> values) {
            addCriterion("next_auditor not in", values, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorBetween(String value1, String value2) {
            addCriterion("next_auditor between", value1, value2, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorNotBetween(String value1, String value2) {
            addCriterion("next_auditor not between", value1, value2, "nextAuditor");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdIsNull() {
            addCriterion("next_auditor_id is null");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdIsNotNull() {
            addCriterion("next_auditor_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdEqualTo(String value) {
            addCriterion("next_auditor_id =", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdNotEqualTo(String value) {
            addCriterion("next_auditor_id <>", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdGreaterThan(String value) {
            addCriterion("next_auditor_id >", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdGreaterThanOrEqualTo(String value) {
            addCriterion("next_auditor_id >=", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdLessThan(String value) {
            addCriterion("next_auditor_id <", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdLessThanOrEqualTo(String value) {
            addCriterion("next_auditor_id <=", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdLike(String value) {
            addCriterion("next_auditor_id like", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdNotLike(String value) {
            addCriterion("next_auditor_id not like", value, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdIn(List<String> values) {
            addCriterion("next_auditor_id in", values, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdNotIn(List<String> values) {
            addCriterion("next_auditor_id not in", values, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdBetween(String value1, String value2) {
            addCriterion("next_auditor_id between", value1, value2, "nextAuditorId");
            return (Criteria) this;
        }

        public Criteria andNextAuditorIdNotBetween(String value1, String value2) {
            addCriterion("next_auditor_id not between", value1, value2, "nextAuditorId");
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