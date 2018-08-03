package com.ynet.finmall.gateway.yulebao.request;

import java.math.BigDecimal;

/**
 * 商户取现（娱乐宝）请求参数
 * @author qiangjiyi
 * @date 2018年1月5日 下午1:53:15
 */
public class YLBMerTradeMerWithdrawRequest extends AbstractYLBRequest {
	private String serial_no;// 流水号

	private BigDecimal amount;// 取现金额

	private String account_no;// 账号

	private String account_name;// 姓名

	private String currency;// 币种

	private String trade_pwd;// 交易密码

	private String primary_account;// 主账号

	private String trade_no;// 交易码

	private String verify_code;//验证码

	private String trans_summary;// 摘要

	private String receive_url;// 回调地址

	private String trans_date;// 操作日期

	private String trans_tradetime;// 操作时间

	private String trans_teller;// 操作柜员

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTrade_pwd() {
		return trade_pwd;
	}

	public void setTrade_pwd(String trade_pwd) {
		this.trade_pwd = trade_pwd;
	}

	public String getPrimary_account() {
		return primary_account;
	}

	public void setPrimary_account(String primary_account) {
		this.primary_account = primary_account;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTrans_summary() {
		return trans_summary;
	}

	public void setTrans_summary(String trans_summary) {
		this.trans_summary = trans_summary;
	}

	public String getReceive_url() {
		return receive_url;
	}

	public void setReceive_url(String receive_url) {
		this.receive_url = receive_url;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public String getTrans_tradetime() {
		return trans_tradetime;
	}

	public void setTrans_tradetime(String trans_tradetime) {
		this.trans_tradetime = trans_tradetime;
	}

	public String getTrans_teller() {
		return trans_teller;
	}

	public void setTrans_teller(String trans_teller) {
		this.trans_teller = trans_teller;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}
}
