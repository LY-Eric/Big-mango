package com.ynet.finmall.user.response;

import java.util.List;

import com.ynet.finmall.common.response.AbstractResponse;
import com.ynet.finmall.user.model.Workflow;

/**
 * 查询审核流模板接口
 * @author liuxin
 *
 */
public class QueryWorkflowResponse extends AbstractResponse {
	private int totalCount;
	private List<Workflow> workflowList;
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Workflow> getWorkflowList() {
		return workflowList;
	}

	public void setWorkflowList(List<Workflow> workflowList) {
		this.workflowList = workflowList;
	}
	
}
