package com.ynet.finmall.merchant.response;

import com.ynet.finmall.common.response.AbstractResponse;

/**
 * 创建审核记录
 */
public class CreateWorkflowCheckInfoResponse extends AbstractResponse {

	private String checkId;//审核记录表ID

	private String orderStatus;//根据审批结果 判断审核后 的业务状态
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	
}
