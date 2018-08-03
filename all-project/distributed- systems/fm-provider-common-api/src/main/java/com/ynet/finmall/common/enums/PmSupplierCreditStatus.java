package com.ynet.finmall.common.enums;

/**
 * 资金方授信信息表状态正常 冻结 取消合作
 * @author zhangjijian
 *
 */
public enum PmSupplierCreditStatus {
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
	private PmSupplierCreditStatus(String code, String cnName) {
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
