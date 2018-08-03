package com.ynet.finmall.gateway.jxbank.response;

import java.math.BigDecimal;
import java.util.List;

/**
 * 查询账户交易明细 响应
 * @author hubk
 *
 */
public class TradeDetailsQueryTradeListResponse extends AbstractJxBankResponse {
	private String account_no          ;//账号    
	private String account_name        ;//户名    
	private String id_type             ;//证件类型
	private String id_no               ;//证件号码
	private String mobile              ;//手机号  
	private BigDecimal cur_balance         ;//当前余额
	private BigDecimal avail_balance       ;//可用余额
	private BigDecimal withdraw_balance    ;//可提现金
	private BigDecimal pre_balance         ;//昨日余额
	private List<Detail_list> detail_list;//明细列表
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
	public List<Detail_list> getDetail_list() {
		return detail_list;
	}
	public void setDetail_list(List<Detail_list> detail_list) {
		this.detail_list = detail_list;
	}

	
	
}
