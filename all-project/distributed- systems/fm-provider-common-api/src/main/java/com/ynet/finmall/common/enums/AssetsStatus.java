package com.ynet.finmall.common.enums;

/**
 *	'资产状态 1-待确认 2-已确认 3-确认拒绝 4-已提交融资申请 5-融资成功 6-融资失败 7-删除',
 */
public enum AssetsStatus {

	READYCONFIRM("1","待确认"),
	
	OKCONFIRM("2","已确认"),
	
	REFUSE("3","确认拒绝"),
	
	SUBMITTINGFINANCING("4","已提交融资申请"),
	
	FINANCINGSUCCESS("5","融资成功"),
	
	FINANCINGFAILED("6","融资失败"),
	
	DELETE("7","删除");
	
	private String code;
	private String cnName;
	private AssetsStatus(String code, String cnName) {
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
