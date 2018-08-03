package com.ynet.finmall.gateway.jxbank.response;

/**
 * 1.2.21 商户取现查证接口
 * 
 * @author liuxin
 *
 */
public class AerWithdrawCheckResponse extends AbstractJxBankResponse {

	private String info;// C100 失败原因
	private String account_no;// C32 账号
	private String primary_account;// C32 主账号
	private String trans_amount;// N16,2 交易金额
	private String account_name;// C60 姓名
	private String original_serialno;// C32 原交易流水号
	private String serial_no; // C32 被查证交易流水号
	private String status;// C1 取现状态 0：未知 1：成功 2：失败
	private String sys_date;// 系统日期
	private String sys_time;// 系统时间

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getPrimary_account() {
		return primary_account;
	}

	public void setPrimary_account(String primary_account) {
		this.primary_account = primary_account;
	}

	public String getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSys_date() {
		return sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}

	public String getOriginal_serialno() {
		return original_serialno;
	}

	public void setOriginal_serialno(String original_serialno) {
		this.original_serialno = original_serialno;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

}
