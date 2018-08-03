package com.ynet.finmall.gateway.jxbank.event;

import java.math.BigDecimal;

/**
 * 二类户余额明细列表
 * @author qiangjiyi
 * @date 2018年1月5日 上午10:53:08
 */
public class BalanceDetail {

	private String account_no;// 账号
	
	private String account_relation;// 账户关系
	
	private BigDecimal cur_balance;// 当前余额
	
	private BigDecimal avail_balance;// 可用余额
	
	private BigDecimal withdraw_balance;// 可提现金额
	
	private BigDecimal pre_balance;// 昨日余额

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_relation() {
		return account_relation;
	}

	public void setAccount_relation(String account_relation) {
		this.account_relation = account_relation;
	}

	public BigDecimal getCur_balance() {
		return cur_balance;
	}

	public void setCur_balance(BigDecimal cur_balance) {
		this.cur_balance = cur_balance;
	}

	public BigDecimal getAvail_balance() {
		return avail_balance;
	}

	public void setAvail_balance(BigDecimal avail_balance) {
		this.avail_balance = avail_balance;
	}

	public BigDecimal getWithdraw_balance() {
		return withdraw_balance;
	}

	public void setWithdraw_balance(BigDecimal withdraw_balance) {
		this.withdraw_balance = withdraw_balance;
	}

	public BigDecimal getPre_balance() {
		return pre_balance;
	}

	public void setPre_balance(BigDecimal pre_balance) {
		this.pre_balance = pre_balance;
	}

}
