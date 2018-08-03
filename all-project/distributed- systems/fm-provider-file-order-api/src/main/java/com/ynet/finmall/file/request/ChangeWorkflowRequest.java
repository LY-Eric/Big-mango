package com.ynet.finmall.file.request;

import com.ynet.finmall.common.request.AbstractRequest;

/**
 * 修改审批流模板信息
 * 
 * @author liuxin
 *
 */
public class ChangeWorkflowRequest extends AbstractRequest {

	private String workflowId;	// 是 string 审批流模板ID
	private String workflowType;// 否 string 审批流模板类型
	private String workflowName;// 否 string 审批流模板名称
	private String isCommon;	// 否 string 是否通用 1-是 2-否
	private String remark;		// 否 string 审批流模板描述
	private String status;		// 否 string 状态（1-正常,2-冻结，3删除）
	
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getWorkflowType() {
		return workflowType;
	}
	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getIsCommon() {
		return isCommon;
	}
	public void setIsCommon(String isCommon) {
		this.isCommon = isCommon;
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
	
	

}
