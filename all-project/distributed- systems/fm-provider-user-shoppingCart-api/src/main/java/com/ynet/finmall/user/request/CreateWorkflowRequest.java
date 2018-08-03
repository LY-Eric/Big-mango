package com.ynet.finmall.user.request;

import java.util.List;

import com.ynet.finmall.common.request.AbstractRequest;
import com.ynet.finmall.user.model.WorkflowDetail;

/**
 * 创建审核流模板接口
 */
public class CreateWorkflowRequest extends AbstractRequest {
	
//	private String workflow_id; // 审批流ID
	private String workflowType;// 审批流类型
	private String workflowName;// 审批流名称
	private String isCommon;// 是否通用 1-是 2-否
	private String remark;// 审批流描述
	private String status;// 状态（1有效,2无效）默认有效
	private String adminId;// 创建人

	private List<WorkflowDetail> workflowDetailList;

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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public List<WorkflowDetail> getWorkflowDetailList() {
		return workflowDetailList;
	}

	public void setWorkflowDetailList(List<WorkflowDetail> workflowDetailList) {
		this.workflowDetailList = workflowDetailList;
	}

	
}
