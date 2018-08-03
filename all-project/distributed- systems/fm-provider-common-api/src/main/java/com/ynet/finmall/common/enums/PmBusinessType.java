package com.ynet.finmall.common.enums;
/**
 * 业务方类型 business_type 1-第三方平台, 2-核心企业
 * @author zhangjijian
 *
 */
public enum PmBusinessType {
	/**
	 * 核心企业
	 */
	COREENTERPRISE("1","平台"),

	/**
	 * 平台
	 */
	PLATFORM("2","核心企业");
	
	private String code;
	private String cnName;
	
	
	private PmBusinessType(String code, String cnName) {
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
