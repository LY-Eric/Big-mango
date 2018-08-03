package com.ynet.finmall.merchant.model;

import java.io.Serializable;
import java.util.Date;

public class EsWorkflowDetail implements Serializable {
    /**
     * 审批流模板步骤ID
     */
    private String workflowDetailId;

    /**
     * 审批流模板ID
     */
    private String workflowId;

    /**
     * 步骤名称
     */
    private String stepName;

    /**
     * 步骤类型(1开始步骤，2一般步骤，3结束步骤)
     */
    private String stepType;

    /**
     * 所属步骤（枚举类型的） 1-第一步 2-第二步 3-第三步 。。。
     */
    private String stepCode;

    /**
     * 审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
     */
    private String auditor;

    /**
     * 是否可驳回 1-可驳回 2-不可驳回
     */
    private String isRollback;

    /**
     * 驳回步骤
     */
    private String rollbackStepCode;

    /**
     * 上级审批节点id
     */
    private String parentDetailId;

    /**
     * 状态(1有效，2删除)
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核通过后订单状态
     */
    private String successStatus;

    /**
     * 审核拒绝后订单状态
     */
    private String failStatus;

    /**
     * 审核驳回后订单状态
     */
    private String rollbackStatus;

    private static final long serialVersionUID = 1L;

    public String getWorkflowDetailId() {
        return workflowDetailId;
    }

    public void setWorkflowDetailId(String workflowDetailId) {
        this.workflowDetailId = workflowDetailId == null ? null : workflowDetailId.trim();
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId == null ? null : workflowId.trim();
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
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

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getIsRollback() {
        return isRollback;
    }

    public void setIsRollback(String isRollback) {
        this.isRollback = isRollback == null ? null : isRollback.trim();
    }

    public String getRollbackStepCode() {
        return rollbackStepCode;
    }

    public void setRollbackStepCode(String rollbackStepCode) {
        this.rollbackStepCode = rollbackStepCode == null ? null : rollbackStepCode.trim();
    }

    public String getParentDetailId() {
        return parentDetailId;
    }

    public void setParentDetailId(String parentDetailId) {
        this.parentDetailId = parentDetailId == null ? null : parentDetailId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSuccessStatus() {
        return successStatus;
    }

    public void setSuccessStatus(String successStatus) {
        this.successStatus = successStatus == null ? null : successStatus.trim();
    }

    public String getFailStatus() {
        return failStatus;
    }

    public void setFailStatus(String failStatus) {
        this.failStatus = failStatus == null ? null : failStatus.trim();
    }

    public String getRollbackStatus() {
        return rollbackStatus;
    }

    public void setRollbackStatus(String rollbackStatus) {
        this.rollbackStatus = rollbackStatus == null ? null : rollbackStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workflowDetailId=").append(workflowDetailId);
        sb.append(", workflowId=").append(workflowId);
        sb.append(", stepName=").append(stepName);
        sb.append(", stepType=").append(stepType);
        sb.append(", stepCode=").append(stepCode);
        sb.append(", auditor=").append(auditor);
        sb.append(", isRollback=").append(isRollback);
        sb.append(", rollbackStepCode=").append(rollbackStepCode);
        sb.append(", parentDetailId=").append(parentDetailId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", successStatus=").append(successStatus);
        sb.append(", failStatus=").append(failStatus);
        sb.append(", rollbackStatus=").append(rollbackStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}