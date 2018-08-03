package com.ynet.finmall.common.enums;

/**
 * 企业主信息表状态
 * @author zhangjijian
 *
 */
public enum CmCompantMainInfoStatus {

	/**
	 * 正常(已开户)
	 */
	NORMAL("1","正常"),
	/**
	 * 冻结
	 */
	FROZEN("2","冻结"),

	/**
	 * 待关联项目
	 */
	ToBeMatched("3","待关联项目"),
	/**
	 * 删除
	 */
	DELETE("4","删除");
	private String code;
	private String cnName;
	
	
	private CmCompantMainInfoStatus(String code, String cnName) {
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
