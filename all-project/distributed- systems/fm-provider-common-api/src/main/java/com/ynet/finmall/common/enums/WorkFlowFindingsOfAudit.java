package com.ynet.finmall.common.enums;

/**
 * 审批流审核结果
 * @author zhangjijian
 *
 */
public enum WorkFlowFindingsOfAudit {

	/**
	 * 通过
	 */
	ADOPT("1","通过"),
	/**
	 * 拒绝
	 */
	REFUSE("2","拒绝"),
	/**
	 * 打回修改
	 */
	REVISE("3","打回修改");
	
	private String code;
	private String cnName;
	private WorkFlowFindingsOfAudit(String code, String cnName) {
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
