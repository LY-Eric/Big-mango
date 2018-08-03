package com.ynet.finmall.user.model;

public class WorkflowDetail {
	private String stepName;// 步骤名称
	private String stepType;// 步骤类型(1开始步骤，2一般步骤，3结束步骤)
	private String stepCode;// 所属步骤（枚举类型的）
	private String auditor;// 审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
	private String isRollback;// 是否可驳回 1-可驳回 2-不可驳回
	private String rollbackStepCode;// 驳回步骤
	private String parentDetailId;// 上级审批节点id
	private String status;// 状态(1有效，2删除)默认 有效
	private String remark;// 备注
	private String successStatus;// 审核通过后订单状态
	private String failStatus;// 审核拒绝后订单状态
	private String rollbackStatus;// 审核驳回后订单状态
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getStepType() {
		return stepType;
	}
	public void setStepType(String stepType) {
		this.stepType = stepType;
	}
	public String getStepCode() {
		return stepCode;
	}
	public void setStepCode(String stepCode) {
		this.stepCode = stepCode;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getIsRollback() {
		return isRollback;
	}
	public void setIsRollback(String isRollback) {
		this.isRollback = isRollback;
	}
	public String getRollbackStepCode() {
		return rollbackStepCode;
	}
	public void setRollbackStepCode(String rollbackStepCode) {
		this.rollbackStepCode = rollbackStepCode;
	}
	public String getParentDetailId() {
		return parentDetailId;
	}
	public void setParentDetailId(String parentDetailId) {
		this.parentDetailId = parentDetailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSuccessStatus() {
		return successStatus;
	}
	public void setSuccessStatus(String successStatus) {
		this.successStatus = successStatus;
	}
	public String getFailStatus() {
		return failStatus;
	}
	public void setFailStatus(String failStatus) {
		this.failStatus = failStatus;
	}
	public String getRollbackStatus() {
		return rollbackStatus;
	}
	public void setRollbackStatus(String rollbackStatus) {
		this.rollbackStatus = rollbackStatus;
	}
	
	
}
