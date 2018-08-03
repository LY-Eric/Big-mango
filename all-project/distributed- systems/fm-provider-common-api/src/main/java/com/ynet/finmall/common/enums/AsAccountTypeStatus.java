package com.ynet.finmall.common.enums;

/**
 * 账户类型 账户类型ID,1信用卡;2借记卡 3-二类户
 * @author zhangjijian
 *
 */
public enum AsAccountTypeStatus {

	/**
	 * 信用卡
	 */
	CREDITCARD("1","信用卡"),
	/**
	 * 借记卡
	 */
	DEBITCARD("2","借记卡"),
	/**
	 * 二类户
	 */
	TWOTYPESOFHOUSEHOLDS("3","二类户");
	
	private String code;
	private String cnName;
	private AsAccountTypeStatus(String code, String cnName) {
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
