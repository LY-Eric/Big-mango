package com.ynet.finmall.gateway.yulebao.request;

import java.math.BigDecimal;

public class ReturnInfo {
	private String repay_serial_no ;//归还流水号

	private String customer        ;//姓名/名称

	private String apply_id        ;//贷款编号

	private String receipt_id      ;//借据编号

	private String trade_date      ;//归还日期

	private Integer period          ;//归还期数

	private BigDecimal trade_amount    ;//归还总额

	private BigDecimal trade_corpus    ;//归还本金

	private BigDecimal trade_accrual   ;//归还利息

	private BigDecimal trade_fee       ;//归还手续费

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

	public String getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
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

	public BigDecimal getTrade_corpus() {
		return trade_corpus;
	}

	public void setTrade_corpus(BigDecimal trade_corpus) {
		this.trade_corpus = trade_corpus;
	}

	public BigDecimal getTrade_accrual() {
		return trade_accrual;
	}

	public void setTrade_accrual(BigDecimal trade_accrual) {
		this.trade_accrual = trade_accrual;
	}

	public BigDecimal getTrade_fee() {
		return trade_fee;
	}

	public void setTrade_fee(BigDecimal trade_fee) {
		this.trade_fee = trade_fee;
	}
}
