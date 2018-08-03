package com.ynet.finmall.common.enums;

/**
 *订单  审核方
 */
public enum OrderStatus {

	READYTRIAL("1","待初审"),
	
	TRIALREFUSE("2","初审拒绝"),
	
	READYCAPITALTRIAL("3","待资金方审核"),
	
	CAPITALTRIALREFUSE("4","资金方审核拒绝方"),
	
	READYSUPPLIERTRIAL("5","待供应商确认"),
	
	SUPPLIERTRIALREFUSE("6","待供应商确认拒绝"),
	
	READYLOAN("7","待放款"),
	
	LOANOK("8","已放款");
	
	private String code;
	private String cnName;
	private OrderStatus(String code, String cnName) {
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
