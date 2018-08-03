package com.ynet.finmall.gateway.jxbank.request;

import java.math.BigDecimal;

/**
 * 嘉兴银行商户取现异常回调通知请求参数
 * @author qiangjiyi
 * @date 2018年1月25日 下午2:49:27
 */
public class JxWithdrawExceptionNoticeRequest extends AbstractJxBankSimpleRequest {

	private String serial_no;// 流水号

	private String account_no;// 账号

	private String original_tradeno;// 原交易码

	private String original_serialno;// 原交易流水号

	private String sys_serialno;// 现交易流水号

	private BigDecimal trans_amount;// 交易金额

	private String account_name;// 姓名

	private String trans_result;// 交易结果

	private String trans_date;// 操作日期

	private String trans_tradetime;// 操作时间

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
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

	public String getSys_serialno() {
		return sys_serialno;
	}

	public void setSys_serialno(String sys_serialno) {
		this.sys_serialno = sys_serialno;
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

	public String getTrans_result() {
		return trans_result;
	}

	public void setTrans_result(String trans_result) {
		this.trans_result = trans_result;
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

	@Override
	public String getServerCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
