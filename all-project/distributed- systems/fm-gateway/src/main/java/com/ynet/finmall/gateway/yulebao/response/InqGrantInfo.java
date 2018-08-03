package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：贷款发放查询
 * 
 * @author liaoyy@belink.com
 */
public class InqGrantInfo {
	private String apply_id;// 贷款编号
	private String receipt_id;// 借据编号
	private String serial_no;// C32 账户系统流水号 N 成功时才有值
	private String grant_status;// 放款结果
	private String grant_note;// 失败原因
	private String sys_date;// C10 账户系统日期
	private String sys_time;// C19 账户系统时间

	public String getSys_date() {
		return sys_date;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getApply_id() {
		return apply_id;
	}

	public String getReceipt_id() {
		return receipt_id;
	}

	public String getGrant_status() {
		return grant_status;
	}

	public String getGrant_note() {
		return grant_note;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public void setGrant_status(String grant_status) {
		this.grant_status = grant_status;
	}

	public void setGrant_note(String grant_note) {
		this.grant_note = grant_note;
	}

	@Override
	public String toString() {
		return "Info [apply_id=" + apply_id + ", receipt_id=" + receipt_id + ", grant_status=" + grant_status
				+ ", grant_note=" + grant_note + "]";
	}
}