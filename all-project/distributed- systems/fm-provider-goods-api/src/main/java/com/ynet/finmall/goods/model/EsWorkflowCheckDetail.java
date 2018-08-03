package com.ynet.finmall.goods.model;

import java.io.Serializable;
import java.util.Date;

public class EsWorkflowCheckDetail implements Serializable {
    /**
     * 审核记录步骤ID
     */
    private String workflowResultId;

    /**
     * 审核记录表ID
     */
    private String checkId;

    /**
     * 审批流模板详情表ID
     */
    private String workflowDetailId;

    /**
     * 审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
     */
    private String auditor;

    /**
     * 审核人ID
     */
    private String adminId;

    /**
     * 当前所属步骤
     */
    private String currentStepCode;

    /**
     * 审核结果（1通过，2拒绝，3打回修改）
     */
    private String checkResult;

    /**
     * 驳回步骤
     */
    private String rollbackStepCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 审核状态(1预审中,2审核中,3(审核完成)通过,4(审核完成)失败)
     */
    private String status;

    /**
     * 审核后的状态  对应审核流模板步骤表中的   审核通过后状态、审核拒绝后状态、审核驳回后状态
     */
    private String orderStatus;

    /**
     * 驳回状态(1-不驳回,2-驳回)
     */
    private String rollbackStatus;

    /**
     * 审核前状态
     */
    private String startStatus;

    /**
     * 审核渠道编号
     */
    private String channelNo;

    private static final long serialVersionUID = 1L;

    public String getWorkflowResultId() {
        return workflowResultId;
    }

    public void setWorkflowResultId(String workflowResultId) {
        this.workflowResultId = workflowResultId == null ? null : workflowResultId.trim();
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getWorkflowDetailId() {
        return workflowDetailId;
    }

    public void setWorkflowDetailId(String workflowDetailId) {
        this.workflowDetailId = workflowDetailId == null ? null : workflowDetailId.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getCurrentStepCode() {
        return currentStepCode;
    }

    public void setCurrentStepCode(String currentStepCode) {
        this.currentStepCode = currentStepCode == null ? null : currentStepCode.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getRollbackStepCode() {
        return rollbackStepCode;
    }

    public void setRollbackStepCode(String rollbackStepCode) {
        this.rollbackStepCode = rollbackStepCode == null ? null : rollbackStepCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getRollbackStatus() {
        return rollbackStatus;
    }

    public void setRollbackStatus(String rollbackStatus) {
        this.rollbackStatus = rollbackStatus == null ? null : rollbackStatus.trim();
    }

    public String getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(String startStatus) {
        this.startStatus = startStatus == null ? null : startStatus.trim();
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workflowResultId=").append(workflowResultId);
        sb.append(", checkId=").append(checkId);
        sb.append(", workflowDetailId=").append(workflowDetailId);
        sb.append(", auditor=").append(auditor);
        sb.append(", adminId=").append(adminId);
        sb.append(", currentStepCode=").append(currentStepCode);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", rollbackStepCode=").append(rollbackStepCode);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", rollbackStatus=").append(rollbackStatus);
        sb.append(", startStatus=").append(startStatus);
        sb.append(", channelNo=").append(channelNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}