package com.ynet.finmall.common.enums;

/**
 * 核心企业审核状态
 * 3待修改 4已开户 1 待资金方审核 2资金方审核拒绝
 * @author zhangjijian
 *
 */
public enum PmCoreEnterpriseStatus {
	
	/**
	 * 待资金方审核
	 */
	READYCAPITALTRIAL("1","待资金方审核"),
	/**
	 * 资金方审核拒绝
	 */
	CAPITALTRIALREFUSE("2","资金方审核拒绝"),
	/**
	 * 待修改
	 */
	TOBEMODIFIED("3","待修改"),
	/**
	 * 已开户
	 */
	ALREADYOPENED("4","已开户");
	
	
	private String code;
	private String cnName;
	private PmCoreEnterpriseStatus(String code, String cnName) {
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
