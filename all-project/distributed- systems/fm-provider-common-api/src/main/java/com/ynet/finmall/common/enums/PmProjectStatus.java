package com.ynet.finmall.common.enums;

/**
 * 项目状态
 * 1-正常 2-冻结 3-停止 4-删除
 */
public enum PmProjectStatus {

	/**
	 * 正常
	 */
	NORMAL("1","正常"),
	/**
	 * 冻结
	 */
	FROZEN("2","冻结"),
	/**
	 * 停止
	 */
	STOP("3","停止"),
	/**
	 * 删除
	 */
	DELETE("4","删除");
	private String code;
	private String cnName;
	private PmProjectStatus(String code, String cnName) {
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
