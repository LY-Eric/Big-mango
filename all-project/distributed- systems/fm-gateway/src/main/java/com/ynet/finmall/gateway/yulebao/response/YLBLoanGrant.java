package com.ynet.finmall.gateway.yulebao.response;

public class YLBLoanGrant {

	private String apply_id;// 贷款编号

	private String receipt_id;// 借据编号

	private String comerchant_receipt_no;//  商户借据编号
	
	private Integer grant_status;// 放款结果

	private String grant_note;// 失败原因

	private String serial_no;// 账户系统流水号
	private String sys_date;//  账户系统日期
	private String sys_time;// 账户系统时间
	

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public Integer getGrant_status() {
		return grant_status;
	}

	public void setGrant_status(Integer grant_status) {
		this.grant_status = grant_status;
	}

	public String getGrant_note() {
		return grant_note;
	}

	public void setGrant_note(String grant_note) {
		this.grant_note = grant_note;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getComerchant_receipt_no() {
		return comerchant_receipt_no;
	}

	public String getSys_date() {
		return sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setComerchant_receipt_no(String comerchant_receipt_no) {
		this.comerchant_receipt_no = comerchant_receipt_no;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}
}
