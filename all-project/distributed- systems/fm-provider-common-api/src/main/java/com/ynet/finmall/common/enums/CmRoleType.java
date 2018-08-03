package com.ynet.finmall.common.enums;

/**
 * 企业类别
 * @author zhangjijian
 *
 */
public enum CmRoleType {

	/**
	 * 供应商
	 */
	SUPPLIER("1","供应商"),
	/**
	 * 核心企业
	 */
	COREENTERPRISE("2","核心企业"),

	/**
	 * 平台
	 */
	PLATFORM("3","平台"),
	/**
	 * 资金方
	 */
	CAPITAL("4","资金方");
	private String code;
	private String cnName;
	
	
	private CmRoleType(String code, String cnName) {
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
