package com.ynet.finmall.gateway.yulebao.request;
/**
 * 绑定账号新增
 * @author hubk
 *
 */
public class YLBAccInfoAddPrimAccRequest extends AbstractYLBRequest {
	private String account_no             ;//账号            
	private String trade_pwd              ;//交易密码        
	private String account_property       ;//账号性质        
	private String mobile                 ;//手机号          
	private String primary_account        ;//主账号          
	private String bank_no                ;//开户行号        
	private String bank_name              ;//开户行名称      
	private String bank_address           ;//开户行所在省编码
	private String bank_cityno            ;//开户行城市编码  
	private String set_default            ;//设为默认        
	private String id_type            ;//证件类型
	private String id_no            ;//证件号码
	private String serial_no              ;//流水号          
	private String trans_date             ;//操作日期        
	private String trans_tradetime        ;//操作时间 
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
	public String getAccount_property() {
		return account_property;
	}
	public void setAccount_property(String account_property) {
		this.account_property = account_property;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPrimary_account() {
		return primary_account;
	}
	public void setPrimary_account(String primary_account) {
		this.primary_account = primary_account;
	}
	public String getBank_no() {
		return bank_no;
	}
	public void setBank_no(String bank_no) {
		this.bank_no = bank_no;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public String getBank_cityno() {
		return bank_cityno;
	}
	public void setBank_cityno(String bank_cityno) {
		this.bank_cityno = bank_cityno;
	}
	public String getSet_default() {
		return set_default;
	}
	public void setSet_default(String set_default) {
		this.set_default = set_default;
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
	public String getId_type() {
		return id_type;
	}
	public String getId_no() {
		return id_no;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public void setId_no(String id_no) {
		this.id_no = id_no;
	}
	
}
