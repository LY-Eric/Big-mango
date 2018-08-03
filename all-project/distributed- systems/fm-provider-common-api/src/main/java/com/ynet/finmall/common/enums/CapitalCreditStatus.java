package com.ynet.finmall.common.enums;

/**
 * 授信类型 1-供应商 2-核心企业 3-平台
 * @desc
 * @author zhangjijian
 * @date: 2018年5月21日 下午2:47:51 
 * @since JDK 1.8  
 * 
 *
 */
public enum CapitalCreditStatus {

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
	PLATFORM("3","平台");
	
	private String code;
	private String cnName;
	
	private CapitalCreditStatus(String code, String cnName) {
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
