package com.ynet.finmall.gateway.yulebao.request;

/**
 * 查询余额请求参数
 * @author qiangjiyi
 * @date 2018年1月5日 上午10:40:10
 */
public class YLBQueryBalanceRequest extends AbstractYLBRequest {

	private String serial_no; // 查询流水号

	private String account_no; // 账号

	private String relation_acct; // 查询从账号

	private String trade_pwd; // 交易密码

	private String trans_date; // 交易日期

	private String trans_teller; // 交易柜员

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

	public String getRelation_acct() {
		return relation_acct;
	}

	public void setRelation_acct(String relation_acct) {
		this.relation_acct = relation_acct;
	}

	public String getTrade_pwd() {
		return trade_pwd;
	}

	public void setTrade_pwd(String trade_pwd) {
		this.trade_pwd = trade_pwd;
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

}
