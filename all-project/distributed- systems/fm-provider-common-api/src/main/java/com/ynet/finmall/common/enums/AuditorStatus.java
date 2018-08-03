package com.ynet.finmall.common.enums;

/**
 * 审核方 1finmall运营，2核心企业，3供应商，4业务方，5资金方
 * @author zhangjijian
 *
 */
public enum AuditorStatus {
	/**
	 * finmall运营
	 */
	FINMALL("1","finmall运营"),
	/**
	 * 核心企业
	 */
	COREENTERPRISE("2","核心企业"),
	/**
	 * 供应商
	 */
	SUPPLIER("3","供应商"),
	/**
	 * 平台
	 */
	PLATFORM("4","业务方"),
	/**
	 * 资金方
	 */
	CAPITAL("5","资金方");
	
	private String code;
	private String cnName;
	
	
	private AuditorStatus(String code, String cnName) {
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
