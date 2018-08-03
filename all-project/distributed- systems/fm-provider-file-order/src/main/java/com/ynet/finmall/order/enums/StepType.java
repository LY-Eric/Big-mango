package com.ynet.finmall.order.enums;

/**
 * 审批流 步骤类型
 * @author liuxin
 *
 */
public enum StepType {

	/**
	 * 1-开始步骤
	 */
	START("1", "开始步骤"),
	
	/**
	 * 2-一般步骤
	 */
	NORMAL("2", "一般步骤"),
	
	/**
	 * 3-结束步骤
	 */
	END("3","结束步骤");

	private String code;
	private String cnName;
	private StepType(String code, String cnName){
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
