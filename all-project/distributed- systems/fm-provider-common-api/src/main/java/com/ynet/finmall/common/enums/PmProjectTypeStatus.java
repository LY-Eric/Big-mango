package com.ynet.finmall.common.enums;

/**
 * 项目类型状态
 * 1-正常 2-删除
 */
public enum PmProjectTypeStatus {

	/**
	 * 正常
	 */
	NORMAL("1","正常"),
	/**
	 * 删除
	 */
	DELETE("4","删除");
	private String code;
	private String cnName;
	private PmProjectTypeStatus(String code, String cnName) {
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
