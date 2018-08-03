package com.ynet.finmall.common.enums;

/**
 * 渠道来源
 * @author zhangjijian
 *
 */
public enum ChannelNoStatus {

	/**
	 * finmall运营
	 */
	FINMALL("1","finmall平台");
	
	
	private String code;
	private String cnName;
	
	
	private ChannelNoStatus(String code, String cnName) {
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
