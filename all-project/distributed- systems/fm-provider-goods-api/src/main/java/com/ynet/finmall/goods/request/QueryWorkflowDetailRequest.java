package com.ynet.finmall.goods.request;

import com.ynet.finmall.common.request.AbstractRequest;

/**
 * 查询审核流模板明细信息
 * @author liuxin
 *
 */
public class QueryWorkflowDetailRequest extends AbstractRequest {

	private String workflowId;

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	
}
