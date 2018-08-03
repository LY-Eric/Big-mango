package com.ynet.finmall.user.model;

import java.util.Date;

public class WorkflowCheckList {

    /**
     * 审核记录表ID
     */
    private String checkId;

    /**
     * 审批流ID
     */
    private String workflowId;

    /**
     * 父项目ID
     */
    private String parentProjectId;

    /**
     * 子项目ID
     */
    private String sonProjectId;

    /**
     * 企业ID
     */
    private String companyId;

    /**
     * 业务ID
     */
    private String serviceId;

    /**
     * 业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
     */
    private String serviceType;

    /**
     * 当前步骤的操作状态,1预审中(无人领取),2审核中(已被领取别人此时不能操作),3(审核完成)通过,4(审核完成)失败
     */
    private String status;

    /**
     * 当前所属步骤类型(1开始步骤，2一般步骤，3结束步骤)
     */
    private String stepType;

    /**
     * 当前所属步骤
     */
    private String stepCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 下一步所属步骤
     */
    private String nextStepCode;

    /**
     * 审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
     */
    private String auditor;

    /**
     * 下一步审核方
     */
    private String nextAuditor;

    /**
     * 审核后的业务状态  审核记录步骤表 的审核后的状态
     */
    private String orderStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId == null ? null : workflowId.trim();
    }

    public String getParentProjectId() {
        return parentProjectId;
    }

    public void setParentProjectId(String parentProjectId) {
        this.parentProjectId = parentProjectId == null ? null : parentProjectId.trim();
    }

    public String getSonProjectId() {
        return sonProjectId;
    }

    public void setSonProjectId(String sonProjectId) {
        this.sonProjectId = sonProjectId == null ? null : sonProjectId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType == null ? null : stepType.trim();
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode == null ? null : stepCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getNextStepCode() {
        return nextStepCode;
    }

    public void setNextStepCode(String nextStepCode) {
        this.nextStepCode = nextStepCode == null ? null : nextStepCode.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getNextAuditor() {
        return nextAuditor;
    }

    public void setNextAuditor(String nextAuditor) {
        this.nextAuditor = nextAuditor == null ? null : nextAuditor.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
