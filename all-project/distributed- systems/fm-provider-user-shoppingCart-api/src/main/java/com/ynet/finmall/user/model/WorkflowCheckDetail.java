package com.ynet.finmall.user.model;

import java.util.Date;

/**
 * 审核记录步骤集合
 * @author liuxin
 *
 */
public class WorkflowCheckDetail {

	private String serviceId;			//业务ID
	private String serviceType;		//业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
	private String parentProjectId;	//父项目ID
	private String sonProjectId;	//子项目ID
    private String companyId;		//企业ID
    private String checkId;			//审核记录ID
	private String workflowResultId	;//审核记录步骤ID
	private String workflowDetailId	;//审批流模板步骤表ID
	private String auditor				;//审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
	private String adminId				;//审核人ID
	private String checkResult			;//表单状态（1通过，2驳回）
	private String stepCode;//当前步骤
	private String stepName			    ;//当前审核步骤名称
	private String remark				;//备注
	private String status				;//审核状态(1预审中2审核中3(审核完成)通过4(审核完成)失败)
	private String orderStatus			;//审核后的状态
	private String rollbackStatus		;//驳回状态(1-不驳回2-驳回)
	private String rollbackStepCode		;//驳回步骤
	private String startStatus			;//审核前状态
	private String channelNo			;//审核渠道编号
	private Date createTime;//创建时间
	
	public String getStepCode() {
		return stepCode;
	}
	public void setStepCode(String stepCode) {
		this.stepCode = stepCode;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getParentProjectId() {
		return parentProjectId;
	}
	public void setParentProjectId(String parentProjectId) {
		this.parentProjectId = parentProjectId;
	}
	public String getSonProjectId() {
		return sonProjectId;
	}
	public void setSonProjectId(String sonProjectId) {
		this.sonProjectId = sonProjectId;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public String getWorkflowResultId() {
		return workflowResultId;
	}
	public void setWorkflowResultId(String workflowResultId) {
		this.workflowResultId = workflowResultId;
	}
	public String getWorkflowDetailId() {
		return workflowDetailId;
	}
	public void setWorkflowDetailId(String workflowDetailId) {
		this.workflowDetailId = workflowDetailId;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getRollbackStepCode() {
		return rollbackStepCode;
	}
	public void setRollbackStepCode(String rollbackStepCode) {
		this.rollbackStepCode = rollbackStepCode;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRollbackStatus() {
		return rollbackStatus;
	}
	public void setRollbackStatus(String rollbackStatus) {
		this.rollbackStatus = rollbackStatus;
	}
	public String getStartStatus() {
		return startStatus;
	}
	public void setStartStatus(String startStatus) {
		this.startStatus = startStatus;
	}
	public String getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
	
	

}
