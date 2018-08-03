package com.ynet.finmall.file.response;

import com.ynet.finmall.common.response.AbstractResponse;

/**
 * 创建审核流模板接口
 */
public class CreateWorkflowResponse extends AbstractResponse {

	private String workflowId;

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	
	
}
