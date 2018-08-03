package com.ynet.finmall.common.enums;

/**
 *字典 类型
 */
public enum DictionaryType {

	/**
	 * 供应商入网审核
	 */
	SUPPLIERNETAUDITOR("1","供应商入网审核"),
	/**
	 * 核心企业入网审核
	 */
	COREENTERPRISENETAUDIT("2","核心企业入网审核"),
	
	/**
	 * 订单审核
	 */
	ORDERAUDIT("3", "订单审核");

	
	
	private String code;
	private String cnName;
	private DictionaryType(String code, String cnName) {
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
