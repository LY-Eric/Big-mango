package com.ynet.finmall.gateway.jxbank.request;

public class TradeDetailsQueryTradeInfoRequest extends AbstractJxBankRequest{
	private String serial_no               ;//查询流水号  
	private String account_no              ;//账号        
	private String trade_pwd               ;//交易密码    
	private String serial_date             ;//流水日期    
	private String original_serialno       ;//原交易流水号
	private String trans_date              ;//交易日期    
	private String trans_teller            ;//交易柜员    
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
	public String getTrade_pwd() {
		return trade_pwd;
	}
	public void setTrade_pwd(String trade_pwd) {
		this.trade_pwd = trade_pwd;
	}
	public String getSerial_date() {
		return serial_date;
	}
	public void setSerial_date(String serial_date) {
		this.serial_date = serial_date;
	}
	public String getOriginal_serialno() {
		return original_serialno;
	}
	public void setOriginal_serialno(String original_serialno) {
		this.original_serialno = original_serialno;
	}
	public String getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}
	public String getTrans_teller() {
		return trans_teller;
	}
	public void setTrans_teller(String trans_teller) {
		this.trans_teller = trans_teller;
	}
	@Override
	public String getServerCode() {
		return "tradeDetails/queryTradeInfo";
	}
}
