package com.ynet.finmall.gateway.jxbank.enums;

public enum File_type {
	
	/**
	 * 01：身份证正面
	 */
	IDFRONT("01","身份证正面"),
	/**
	 * 02：身份证反面
	 */
	IDBACK("02","身份证反面"),
	/**
	 * 03：银行卡
	 */
	BANKCAR("03","银行卡"),
	/**
	 * 11：开户证明
	 */
	OPENACCPROVE("11","开户证明"),
	/**
	 * 12：营业执照
	 */
	BUSINESSLICENSE("12","营业执照");

	private String code;
	private String cnName;
	
	private File_type(String code,String cnName){
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
