package com.ynet.finmall.merchant.request;

import com.ynet.finmall.common.request.AbstractRequest;


/**
 * 创建审核记录
 * 
 * @author liuxin
 *
 */
public class CreateWorkflowCheckInfoRequest extends AbstractRequest {

	private String workflowId;// 审批流模板ID
	private String parentProjectId;// 父项目ID
	private String sonProjectId;// 子项目ID
	private String companyId;// 企业ID
	private String serviceId;// 业务ID
	private String serviceType;// 业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
	private String checkResult;// 审核结果（1通过，2拒绝，3打回修改） 不为空时审核人ID、渠道编号不能为空
	private String adminId;// 审核人ID
	private String auditor;//审核方
	private String nextAuditorId;//下一步审核方ID(企业ID营业执照号...)
	private String remark;// 审核记录步骤备注
	private String rollbackStatus;//驳回状态(1-不驳回,2-驳回)
	private String rollbackStepCode;//驳回步骤
	
	public String getNextAuditorId() {
		return nextAuditorId;
	}
	public void setNextAuditorId(String nextAuditorId) {
		this.nextAuditorId = nextAuditorId;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRollbackStatus() {
		return rollbackStatus;
	}
	public void setRollbackStatus(String rollbackStatus) {
		this.rollbackStatus = rollbackStatus;
	}
	public String getRollbackStepCode() {
		return rollbackStepCode;
	}
	public void setRollbackStepCode(String rollbackStepCode) {
		this.rollbackStepCode = rollbackStepCode;
	}

}
