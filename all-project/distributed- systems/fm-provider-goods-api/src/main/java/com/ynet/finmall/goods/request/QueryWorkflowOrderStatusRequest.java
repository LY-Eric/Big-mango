package com.ynet.finmall.goods.request;

import com.ynet.finmall.common.request.AbstractRequest;

/**
 * 查询审核后业务状态接口
 * 
 * @author liuxin
 *
 */
public class QueryWorkflowOrderStatusRequest extends AbstractRequest {

	private String checkId;// 审核记录ID
	private String serviceId;// 业务ID
	private String serviceType;// 业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
	
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
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
	

}
