package com.ynet.finmall.merchant.request;

import com.ynet.finmall.common.request.AbstractRequest;



/**
 * 查询待审核记录接口
 * @author liuxin
 *
 */
public class QueryWorkflowWaitCheckInfoRequest extends AbstractRequest {

	private String nextAuditor;//审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
	private String parentProjectId;//父项目ID
	private String sonProjectId;//子项目ID
	private String nextAuditorId;//下一步审核方ID(企业ID\营业执照号。。。)
	private String serviceType;//业务类型
	
	public String getNextAuditor() {
		return nextAuditor;
	}
	public void setNextAuditor(String nextAuditor) {
		this.nextAuditor = nextAuditor;
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
	public String getNextAuditorId() {
		return nextAuditorId;
	}
	public void setNextAuditorId(String nextAuditorId) {
		this.nextAuditorId = nextAuditorId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
	
}
