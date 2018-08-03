package com.ynet.finmall.order.enums;

/**
 * 审批流 审核结果
 * @author liuxin
 *
 */
public enum CheckResult {

	/**
	 * 1-通过
	 */
	CONCENT("1", "通过"),
	
	/**
	 * 2-拒绝
	 */
	REFUSE("2", "拒绝"),

	/**
	 * 3-打回修改
	 */
	MODIFY("3","打回修改");

	private String code;
	private String cnName;
	private CheckResult(String code, String cnName){
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
