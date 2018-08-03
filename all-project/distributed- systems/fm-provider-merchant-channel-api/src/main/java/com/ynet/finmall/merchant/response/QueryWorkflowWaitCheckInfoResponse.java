package com.ynet.finmall.merchant.response;

import java.util.List;

import com.ynet.finmall.common.response.AbstractResponse;
import com.ynet.finmall.merchant.model.WorkflowCheckList;

/**
 * 查询待审核记录接口
 * @author liuxin
 *
 */
public class QueryWorkflowWaitCheckInfoResponse extends AbstractResponse {

	List<WorkflowCheckList> workflowCheckDetailList;

	public List<WorkflowCheckList> getWorkflowCheckDetailList() {
		return workflowCheckDetailList;
	}

	public void setWorkflowCheckDetailList(List<WorkflowCheckList> workflowCheckDetailList) {
		this.workflowCheckDetailList = workflowCheckDetailList;
	}
	
}
