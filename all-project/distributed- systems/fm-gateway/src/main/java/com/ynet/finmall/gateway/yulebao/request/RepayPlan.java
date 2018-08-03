package com.ynet.finmall.gateway.yulebao.request;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepayPlan {
	private String  settle_date ;   //应还日期
	private Integer  period ;   //期数
	private BigDecimal  need_amount ;   //应还总额
	private BigDecimal  need_corpus ;   //应还本金
	private BigDecimal  need_accrual ;   //应还利息
	private BigDecimal  need_fee ;   //应还手续费

	public String getSettle_date() {
		return settle_date;
	}
	public void setSettle_date(String settle_date) {
		this.settle_date = settle_date;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public BigDecimal getNeed_amount() {
		return need_amount;
	}
	public void setNeed_amount(BigDecimal need_amount) {
		this.need_amount = need_amount;
	}
	public BigDecimal getNeed_corpus() {
		return need_corpus;
	}
	public void setNeed_corpus(BigDecimal need_corpus) {
		this.need_corpus = need_corpus;
	}
	public BigDecimal getNeed_accrual() {
		return need_accrual;
	}
	public void setNeed_accrual(BigDecimal need_accrual) {
		this.need_accrual = need_accrual;
	}
	public BigDecimal getNeed_fee() {
		return need_fee;
	}
	public void setNeed_fee(BigDecimal need_fee) {
		this.need_fee = need_fee;
	}	
}
