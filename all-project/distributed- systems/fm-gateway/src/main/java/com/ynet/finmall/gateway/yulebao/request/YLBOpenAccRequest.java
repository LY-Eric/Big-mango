package com.ynet.finmall.gateway.yulebao.request;

import java.util.List;

import com.ynet.finmall.gateway.jxbank.event.FileDetail;

/**
 * 二类账户的开户
 * 
 * @author liuxin
 */
public class YLBOpenAccRequest extends AbstractYLBRequest {

	private String account_name; // 户名
	private String account_property; // 账号性质
	private String id_type; // 证件类型
	private String id_no; // 证件号码
	private String id_startdate; // 证件有效起始日期
	private String id_enddate; // 证件有效结束日期
	private String sign_name; // 签发机关
	private String sex; // 性别
	private String ethnic; // 民族
	private String job; // 职业
	private String job_note; // 职业备注
	private String mobile; // 手机号
	private String primary_account; // 主账号
	private String bank_no; // 开户行号
	private String bank_name; // 开户行名称
	private String bank_address; // 开户行所在省编码
	private String bank_cityno; // 开户行城市编码
	private String industry; // 行业类别
	private String company_id_type; // 法人证件类型
	private String company_id_no; // 法人证件号码
	private String company_id_name; // 法人代表名称
	private String serial_no; // 流水号
	private List<FileDetail> file_list; // 开户资料信息
	private String open_date; // 开户日期
	private String open_tradetime; // 开户时间
	private String open_teller; // 开户柜员
	// 以下两字段 短信验证码，个人必输
	private String trade_no; // 交易码
	private String verify_code; // 验证码

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_property() {
		return account_property;
	}

	public void setAccount_property(String account_property) {
		this.account_property = account_property;
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

	public String getId_startdate() {
		return id_startdate;
	}

	public void setId_startdate(String id_startdate) {
		this.id_startdate = id_startdate;
	}

	public String getId_enddate() {
		return id_enddate;
	}

	public void setId_enddate(String id_enddate) {
		this.id_enddate = id_enddate;
	}

	public String getSign_name() {
		return sign_name;
	}

	public void setSign_name(String sign_name) {
		this.sign_name = sign_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob_note() {
		return job_note;
	}

	public void setJob_note(String job_note) {
		this.job_note = job_note;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompany_id_type() {
		return company_id_type;
	}

	public void setCompany_id_type(String company_id_type) {
		this.company_id_type = company_id_type;
	}

	public String getCompany_id_no() {
		return company_id_no;
	}

	public void setCompany_id_no(String company_id_no) {
		this.company_id_no = company_id_no;
	}

	public String getCompany_id_name() {
		return company_id_name;
	}

	public void setCompany_id_name(String company_id_name) {
		this.company_id_name = company_id_name;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public List<FileDetail> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<FileDetail> file_list) {
		this.file_list = file_list;
	}

	public String getOpen_date() {
		return open_date;
	}

	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}

	public String getOpen_tradetime() {
		return open_tradetime;
	}

	public void setOpen_tradetime(String open_tradetime) {
		this.open_tradetime = open_tradetime;
	}

	public String getOpen_teller() {
		return open_teller;
	}

	public void setOpen_teller(String open_teller) {
		this.open_teller = open_teller;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}
}
