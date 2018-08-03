package com.ynet.finmall.common.enums;

/**
 *订单  审核方
 */
public enum OrderAuditorStatus {

	FINMALL("1","finmall运营"),
	
	COREENTERPRISE("2","核心企业"),
	
	SUPPLIER("3","供应商"),
	
	BUSSINESS("4","业务方"),
	
	CAPITAL("5","资金方");
	
	private String code;
	private String cnName;
	private OrderAuditorStatus(String code, String cnName) {
		this.code = code;
		this.cnName = cnName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	
}
