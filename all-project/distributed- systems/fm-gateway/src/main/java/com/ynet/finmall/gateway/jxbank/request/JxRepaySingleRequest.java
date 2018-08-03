package com.ynet.finmall.gateway.jxbank.request;

/**
 * 备注：贷款归还（单笔实时）
 * @author liaoyy@belink.com
 */
public class JxRepaySingleRequest {
	private String pro_id; // 产品编号
	private String repay_serial_no; // 归还流水号
	private String customer; // 姓名/名称
	private String apply_id; // 贷款编号
	private String receipt_id; // 借据编号
	private String trade_date; // 归还日期
	private int period; // 归还期数
	private double trade_amount; // 归还总额
	private double trade_corpus; // 归还本金
	private double trade_accrual; // 归还利息
	private double trade_fee; // 归还手续费
	private String trans_date; // 操作日期
	private String trans_tradetime; // 操作时间

	public String getPro_id() {
		return pro_id;
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

	public String getTrade_date() {
		return trade_date;
	}

	public int getPeriod() {
		return period;
	}

	public double getTrade_amount() {
		return trade_amount;
	}

	public double getTrade_corpus() {
		return trade_corpus;
	}

	public double getTrade_accrual() {
		return trade_accrual;
	}

	public double getTrade_fee() {
		return trade_fee;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public String getTrans_tradetime() {
		return trans_tradetime;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
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

	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setTrade_amount(double trade_amount) {
		this.trade_amount = trade_amount;
	}

	public void setTrade_corpus(double trade_corpus) {
		this.trade_corpus = trade_corpus;
	}

	public void setTrade_accrual(double trade_accrual) {
		this.trade_accrual = trade_accrual;
	}

	public void setTrade_fee(double trade_fee) {
		this.trade_fee = trade_fee;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public void setTrans_tradetime(String trans_tradetime) {
		this.trans_tradetime = trans_tradetime;
	}

	public String getServerCode() {
		return "api/v1/loan/repay_single_ylb.do";
	}
}
