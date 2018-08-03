package com.ynet.finmall.goods.enums;

/**
 * 审核驳回状态
 * @author liuxin
 *
 */
public enum RollbackStatus {

	/**
	 * 1-不驳回
	 */
	NOROLLBACK("1", "不驳回"),
	
	/**
	 * 2-驳回
	 */
	ROLLBACK("2","驳回");

	private String code;
	private String cnName;
	private RollbackStatus(String code, String cnName){
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
