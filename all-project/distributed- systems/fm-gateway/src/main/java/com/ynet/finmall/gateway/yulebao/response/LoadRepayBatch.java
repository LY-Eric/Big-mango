package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：贷款批量归还
 * 
 * @author liaoyy@belink.com
 */
public class LoadRepayBatch {
	private String serial_no; // 账户系统交易流水号
	private String sys_date; // 账户系统日期
	private String sys_time; // 账户系统时间

	public String getSerial_no() {
		return serial_no;
	}

	public String getSys_date() {
		return sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}
}
