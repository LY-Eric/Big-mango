package com.ynet.finmall.common.enums;

/**
 *业务类型
 *	1-融资单 2-资产单 3-核心企业入网 4-供应商入网
 */
public enum WorkFlowServiceType {

	/**
	 * 1-融资单
	 */
	ORDER("1","融资单"),
	/**
	 * 2-资产单
	 */
	ASSETS("2","资产单"),
	/**
	 * 3-核心企业入网 
	 */
	CORECOMPANY("3","核心企业入网"),
	/**
	 * 4-供应商入网
	 */
	SUPPLIER("4","供应商入网");
	
	private String code;
	private String cnName;
	private WorkFlowServiceType(String code, String cnName) {
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
