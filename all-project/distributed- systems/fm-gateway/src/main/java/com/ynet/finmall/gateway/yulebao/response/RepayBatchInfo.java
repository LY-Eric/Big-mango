package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：贷款归还批量查询明细信息
 * 
 * @author liaoyy@belink.com
 */
public class RepayBatchInfo {
	private String repay_serial_no; // 归还流水号
	private String customer; // 姓名/名称
	private String apply_id; // 贷款编号
	private String receipt_id; // 借据编号
	private int period; // 归还期数
	private double trade_amount; // 归还总额
	private int repay_status; // 归还结果
	private String repay_note; // 失败原因
	private int finish_flag; // 结清标记
	private String sys_serialno; // 账户系统流水号
	private String sys_date; // 账户系统日期
	private String sys_time; // 账户系统时间

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

	public String getSys_serialno() {
		return sys_serialno;
	}

	public void setSys_serialno(String sys_serialno) {
		this.sys_serialno = sys_serialno;
	}

	public String getRepay_serial_no() {
		return repay_serial_no;
	}

	public String getCustomer() {
		return customer;
	}

	public String getApply_id() {
		return apply_id;
	}

	public String getReceipt_id() {
		return receipt_id;
	}

	public int getPeriod() {
		return period;
	}

	public double getTrade_amount() {
		return trade_amount;
	}

	public int getRepay_status() {
		return repay_status;
	}

	public String getRepay_note() {
		return repay_note;
	}

	public int getFinish_flag() {
		return finish_flag;
	}

	public void setRepay_serial_no(String repay_serial_no) {
		this.repay_serial_no = repay_serial_no;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setTrade_amount(double trade_amount) {
		this.trade_amount = trade_amount;
	}

	public void setRepay_status(int repay_status) {
		this.repay_status = repay_status;
	}

	public void setRepay_note(String repay_note) {
		this.repay_note = repay_note;
	}

	public void setFinish_flag(int finish_flag) {
		this.finish_flag = finish_flag;
	}

}
