package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：贷款归还结果查询（单笔）
 * 
 * @author liaoyy@belink.com
 */
public class YLBRepaySearchSingleInfo {
	private String receipt_id; // C32 借据编号
	private String customer; // C60 姓名/名称
	private String repay_serial_no; // C32 归还流水号
	private String period;// Int 归还期数
	private String trade_amount; // N16,2 归还总额
	private String repay_status; // Int 归还结果
	private String repay_note; // C500 失败原因
	private String finish_flag; // Int 结清标记
	private String sys_serialno;// C32 账户系统流水号
	private String sys_date; // C10 账户系统日期
	private String sys_time; // C19 账户系统时间

	public String getReceipt_id() {
		return receipt_id;
	}

	public String getCustomer() {
		return customer;
	}

	public String getRepay_serial_no() {
		return repay_serial_no;
	}

	public String getPeriod() {
		return period;
	}

	public String getTrade_amount() {
		return trade_amount;
	}

	public String getRepay_status() {
		return repay_status;
	}

	public String getRepay_note() {
		return repay_note;
	}

	public String getFinish_flag() {
		return finish_flag;
	}

	public String getSys_serialno() {
		return sys_serialno;
	}

	public String getSys_date() {
		return sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setRepay_serial_no(String repay_serial_no) {
		this.repay_serial_no = repay_serial_no;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setTrade_amount(String trade_amount) {
		this.trade_amount = trade_amount;
	}

	public void setRepay_status(String repay_status) {
		this.repay_status = repay_status;
	}

	public void setRepay_note(String repay_note) {
		this.repay_note = repay_note;
	}

	public void setFinish_flag(String finish_flag) {
		this.finish_flag = finish_flag;
	}

	public void setSys_serialno(String sys_serialno) {
		this.sys_serialno = sys_serialno;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}

	@Override
	public String toString() {
		return "YLBRepaySearchSingleInfo [receipt_id=" + receipt_id + ", customer=" + customer + ", repay_serial_no="
				+ repay_serial_no + ", period=" + period + ", trade_amount=" + trade_amount + ", repay_status="
				+ repay_status + ", repay_note=" + repay_note + ", finish_flag=" + finish_flag + ", sys_serialno="
				+ sys_serialno + ", sys_date=" + sys_date + ", sys_time=" + sys_time + "]";
	}

}
