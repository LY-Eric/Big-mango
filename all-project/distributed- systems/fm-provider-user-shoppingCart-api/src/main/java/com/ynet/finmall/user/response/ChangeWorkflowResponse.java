package com.ynet.finmall.user.response;

import java.util.List;

import com.ynet.finmall.common.response.AbstractResponse;
import com.ynet.finmall.user.model.WorkflowDetail;

/**
 * 修改审批流模板信息
 * @author liuxin
 *
 */
public class ChangeWorkflowResponse extends AbstractResponse {
	
	List<WorkflowDetail> workflowDetailList;

	public List<WorkflowDetail> getWorkflowDetailList() {
		return workflowDetailList;
	}

	public void setWorkflowDetailList(List<WorkflowDetail> workflowDetailList) {
		this.workflowDetailList = workflowDetailList;
	}
	
}
