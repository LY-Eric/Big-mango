package com.ynet.finmall.gateway.jxbank.request;

/**
 * 查询账户交易明细
 */
public class TradeDetailsQueryTradeListRequest extends AbstractJxBankSimpleRequest {
	
	private String serial_no              ;//查询流水号
	private String account_no             ;//账号      
	private String trade_pwd              ;//交易密码  
	private String start_date             ;//起始日期  
	private String end_date               ;//结束日期  
	private String trans_date             ;//交易日期  
	private String trans_teller           ;//交易柜员  
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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
	//接口名称
	@Override
	public String getServerCode() {
		return "/tradeDetails/queryTradeList";
	}
	

}
