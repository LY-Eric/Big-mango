package com.ynet.finmall.common.enums;
/**
 * 账户属性,1对公;2对私
 * @author zhangjijian
 *
 */
public enum AsAccountPropertyStatus {

	/**
	 * 对公
	 */
	TOTHEPUBLIC("1","对公"),
	/**
	 * 对私
	 */
	TOPRIVATE("2","对私");
	
	private String code;
	private String cnName;
	private AsAccountPropertyStatus(String code, String cnName) {
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
