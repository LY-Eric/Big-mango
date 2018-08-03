package com.ynet.finmall.gateway.jxbank.response;

import java.math.BigDecimal;

/**
 * 明细列表
 * @author hubk
 *
 */
public class Detail_list {
	private String account_date             ;//记账日期    
	private String detail_type              ;//明细类型    
	private String trans_type               ;//交易类型    
	private String original_serialno        ;//原交易流水号
	private String serial_no                ;//现交易流水号
	private BigDecimal trans_amount             ;//交易金额    
	private BigDecimal total_amount             ;//交易总额    
	private BigDecimal trans_fee                ;//手续费      
	private BigDecimal balance                  ;//余额        
	private String channel_no               ;//渠道编号    
	public String getAccount_date() {
		return account_date;
	}
	public void setAccount_date(String account_date) {
		this.account_date = account_date;
	}
	public String getDetail_type() {
		return detail_type;
	}
	public void setDetail_type(String detail_type) {
		this.detail_type = detail_type;
	}
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
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
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getChannel_no() {
		return channel_no;
	}
	public void setChannel_no(String channel_no) {
		this.channel_no = channel_no;
	}
	

}
