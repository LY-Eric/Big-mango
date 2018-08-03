package com.ynet.finmall.file.response;

import java.util.List;

import com.ynet.finmall.common.response.AbstractResponse;
import com.ynet.finmall.file.model.WorkflowDetail;

/**
 * 查询审核流模板明细信息
 * @author liuxin
 *
 */
public class QueryWorkflowDetailResponse extends AbstractResponse {
	
	List<WorkflowDetail> workflowDetailList;

	public List<WorkflowDetail> getWorkflowDetailList() {
		return workflowDetailList;
	}

	public void setWorkflowDetailList(List<WorkflowDetail> workflowDetailList) {
		this.workflowDetailList = workflowDetailList;
	}
	
}
