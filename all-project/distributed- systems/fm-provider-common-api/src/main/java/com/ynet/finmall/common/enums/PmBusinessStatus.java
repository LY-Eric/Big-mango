package com.ynet.finmall.common.enums;

/**
 *业务方状态  合作资金方状态  审批流关系状态
 * 1-正常 2-冻结 3-取消合作
 */
public enum PmBusinessStatus {

	/**
	 * 正常
	 */
	NORMAL("1","正常"),
	/**
	 * 冻结
	 */
	FROZEN("2","冻结"),
	/**
	 * 取消合作
	 */
	CANCEL("3","取消合作");
	
	private String code;
	private String cnName;
	private PmBusinessStatus(String code, String cnName) {
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
