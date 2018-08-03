package com.ynet.finmall.common.enums;

/**
 * 还款 状态
 * 1.待还款,2.已还款 ,3.已逾期 ,4.逾期以还
 */
public enum OrderRepaymentStatus {

	STAYREPAYMENT("1","待还款"),
	
	OKREPAYMENT("2","已还款"),
	
	OVERDUE("3","已逾期"),
	
	OKOVERDUE("4","逾期已还");
	
	private String code;
	private String cnName;
	private OrderRepaymentStatus(String code, String cnName) {
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
