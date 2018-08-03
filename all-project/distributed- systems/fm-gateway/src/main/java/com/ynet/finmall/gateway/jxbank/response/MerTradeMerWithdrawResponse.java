package com.ynet.finmall.gateway.jxbank.response;

import java.math.BigDecimal;

/**
 * 商户取现（娱乐宝）响应参数
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 下午1:57:28
 */
public class MerTradeMerWithdrawResponse extends AbstractJxBankResponse {

	private String account_no;// 账号

	private String original_tradeno;// 原交易码

	private String original_serialno;// 原交易流水号

	private String serial_no;// 现交易流水号

	private BigDecimal trans_amount;// 交易金额

	private String account_name;// 姓名

	private String sys_date;

	private String sys_time;

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

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getOriginal_tradeno() {
		return original_tradeno;
	}

	public void setOriginal_tradeno(String original_tradeno) {
		this.original_tradeno = original_tradeno;
	}

	public String getOriginal_serialno() {
		return original_serialno;
	}

	public void setOriginal_serialno(String original_serialno) {
		this.original_serialno = original_serialno;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public BigDecimal getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(BigDecimal trans_amount) {
		this.trans_amount = trans_amount;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

}
