package com.ynet.finmall.gateway.yulebao.request;
/**
 * 绑定账号设定
 * @author hubk
 *
 */
public class YLBAccInfoSetPrimAccRequest extends AbstractYLBRequest {
	private String account_no            ;//账号    
	private String trade_pwd             ;//交易密码
	private String primary_account       ;//主账号  
	private String serial_no             ;//流水号  
	private String trans_date            ;//操作日期
	private String trans_tradetime       ;//操作时间
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
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
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
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
}
