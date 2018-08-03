package com.ynet.finmall.gateway.jxbank.response;

import java.math.BigDecimal;

/**
 * 查询交易
 * 
 * @author hubk
 *
 */
public class TradeDetailsQueryTradeInfoResponse extends AbstractJxBankResponse {
	private String account_no;// 账号
	private String account_name;// 户名
	private String id_type;// 证件类型
	private String id_no;// 证件号码
	private String mobile;// 手机号
	private String serial_no;// 交易流水号
	private BigDecimal trans_amount;// 交易金额
	private BigDecimal total_amount;// 交易总额
	private BigDecimal trans_fee;// 手续费
	private String channel_no;// 渠道编号
	private String sys_date;// 系统日期
	private String sys_time;// 系统时间

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

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}

	public BigDecimal getTrans_fee() {
		return trans_fee;
	}

	public void setTrans_fee(BigDecimal trans_fee) {
		this.trans_fee = trans_fee;
	}

	public String getChannel_no() {
		return channel_no;
	}

	public void setChannel_no(String channel_no) {
		this.channel_no = channel_no;
	}

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

}
