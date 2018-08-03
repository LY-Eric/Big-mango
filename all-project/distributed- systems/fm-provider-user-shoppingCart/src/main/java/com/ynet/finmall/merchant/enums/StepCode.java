package com.ynet.finmall.merchant.enums;

/**
 * 审批流 所属步骤
 * @author liuxin
 *
 */
public enum StepCode {

	/**
	 * 1-第一步
	 */
	ONE("1", "第一步"),
	
	/**
	 * 2-第二步
	 */
	TWO("2", "第二步"),

	/**
	 * 3-第三步
	 */
	THREE("3","第三步"),
	
	/**
	 * 4-第四步
	 */
	FOUR("4","第四步"),
	
	/**
	 * 5-第五步
	 */
	FIVE("5","第五步"),
	
	/**
	 * 6-第六步
	 */
	SIX("6","第六步"),

	/**
	 * 7-第七步
	 */
	SEVEN("7","第七步"),
	
	/**
	 * 8-第八步
	 */
	EIGHT("8","第八步"),
	
	/**
	 * 9-第九步
	 */
	NINE("9","第九步"),
	
	/**
	 * 10-第十步
	 */
	TEN("10","第十步");

	private String code;
	private String cnName;
	private StepCode(String code, String cnName){
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
