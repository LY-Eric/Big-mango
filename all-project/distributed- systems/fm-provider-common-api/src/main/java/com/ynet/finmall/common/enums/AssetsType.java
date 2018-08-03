package com.ynet.finmall.common.enums;

/**
 *	资产类型 1-应收账款 2-固定资产
 */
public enum AssetsType {

	ACCOUNTSRECEIVABLE("1","应收账款"),
	
	FIXEDASSET("2","固定资产");
	
	private String code;
	private String cnName;
	private AssetsType(String code, String cnName) {
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
