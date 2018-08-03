package com.ynet.finmall.gateway.jxbank.event;

import java.math.BigDecimal;

/**
 * 归还明细
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 下午2:57:33
 */
public class RepayDetail {
	private String repay_serial_no;// 归还流水号

	private String customer;// 姓名/名称

	private String apply_id;// 贷款编号

	private String receipt_id;// 借据编号

	private Integer period;// 归还期数

	private BigDecimal trade_amount;// 归还总额

	private Integer repay_status;// 归还结果

	private String repay_note;// 失败原因
	private String sys_serialno;// 账户系统流水号

	private Integer finish_flag;// 结清标记

	public String getRepay_serial_no() {
		return repay_serial_no;
	}

	public void setRepay_serial_no(String repay_serial_no) {
		this.repay_serial_no = repay_serial_no;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

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

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public BigDecimal getTrade_amount() {
		return trade_amount;
	}

	public void setTrade_amount(BigDecimal trade_amount) {
		this.trade_amount = trade_amount;
	}

	public Integer getRepay_status() {
		return repay_status;
	}

	public void setRepay_status(Integer repay_status) {
		this.repay_status = repay_status;
	}

	public String getRepay_note() {
		return repay_note;
	}

	public void setRepay_note(String repay_note) {
		this.repay_note = repay_note;
	}

	public Integer getFinish_flag() {
		return finish_flag;
	}

	public void setFinish_flag(Integer finish_flag) {
		this.finish_flag = finish_flag;
	}

	public String getSys_serialno() {
		return sys_serialno;
	}

	public void setSys_serialno(String sys_serialno) {
		this.sys_serialno = sys_serialno;
	}

}
