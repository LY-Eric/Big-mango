package com.ynet.finmall.goods.request;

import com.ynet.finmall.common.request.AbstractRequest;

/**
 * 查询审核记录
 */
public class QueryWorkflowCheckInfoRequest extends AbstractRequest {
	
	private String checkId	    	;//审核记录ID
	private String parentProjectId	;//父项目ID
	private String sonProjectId   	;//子项目ID
	private String companyId	  	;//企业ID
	private String serviceId	  	;//业务ID
	private String serviceType		;//业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
	private String auditor			;//当前审核方
	private String stepCode			;//所属步骤类型 
	
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public String getParentProjectId() {
		return parentProjectId;
	}
	public void setParentProjectId(String parentProjectId) {
		this.parentProjectId = parentProjectId;
	}
	public String getSonProjectId() {
		return sonProjectId;
	}
	public void setSonProjectId(String sonProjectId) {
		this.sonProjectId = sonProjectId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getStepCode() {
		return stepCode;
	}
	public void setStepCode(String stepCode) {
		this.stepCode = stepCode;
	}
	
}
