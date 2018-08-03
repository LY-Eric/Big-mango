package com.ynet.finmall.gateway.yulebao.model.api;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * 备注：1.2.1 核心企业入驻接口
 * 
 * @author liaoyy@belink.com
 */
public class CreateCore {
	/**
	 * 用户名
	 */
	@NotNull(message="用户名不能为空")
	private String userName;
	/**
	 * 邮箱
	 */
	@NotNull(message="邮箱不能为空")
	private String email;
	/**
	 * 联系电话
	 */
	@NotNull(message="联系电话不能为空")
	private String phone;
	/**
	 * 联系人姓名
	 */
	@NotNull(message="联系人姓名不能为空")
	private String contact_person;
	/**
	 * 公司全称
	 */
	@NotNull(message="公司全称不能为空")
	private String companyName;
	/**
	 * 工商注册号
	 */
	private String business_registration_no;
	/**
	 * 工商注册日期
	 */
	private Date business_register_date;
	/**
	 * 工商注册类型 工商注册类型，1-统一社会信用代码，2-营业执照&组织机构代码
	 */
	private String business_type;
	/**
	 * 营业执照
	 */
	@NotNull(message="营业执照不能为空")
	private String business_licence;
	/**
	 * 组织机构代码
	 */
	private String organization_code;
	/**
	 * 注册资本
	 */
	private String business_register_capital;
	/**
	 * 企业地址
	 */
	private String company_address;
	/**
	 * 法人证件类型 1-身份证2-护照3-军人证
	 */
	private String legal_cert_type;
	/**
	 * 法人姓名
	 */
	private String legal_person;
	/**
	 * 法人证件号
	 */
	private String legal_ertificate_no;

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getContact_person() {
		return contact_person;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getBusiness_registration_no() {
		return business_registration_no;
	}

	public Date getBusiness_register_date() {
		return business_register_date;
	}

	public String getBusiness_type() {
		return business_type;
	}

	public String getBusiness_licence() {
		return business_licence;
	}

	public String getOrganization_code() {
		return organization_code;
	}

	public String getBusiness_register_capital() {
		return business_register_capital;
	}

	public String getCompany_address() {
		return company_address;
	}

	public String getLegal_cert_type() {
		return legal_cert_type;
	}

	public String getLegal_person() {
		return legal_person;
	}

	public String getLegal_ertificate_no() {
		return legal_ertificate_no;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setBusiness_registration_no(String business_registration_no) {
		this.business_registration_no = business_registration_no;
	}

	public void setBusiness_register_date(Date business_register_date) {
		this.business_register_date = business_register_date;
	}

	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	public void setBusiness_licence(String business_licence) {
		this.business_licence = business_licence;
	}

	public void setOrganization_code(String organization_code) {
		this.organization_code = organization_code;
	}

	public void setBusiness_register_capital(String business_register_capital) {
		this.business_register_capital = business_register_capital;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public void setLegal_cert_type(String legal_cert_type) {
		this.legal_cert_type = legal_cert_type;
	}

	public void setLegal_person(String legal_person) {
		this.legal_person = legal_person;
	}

	public void setLegal_ertificate_no(String legal_ertificate_no) {
		this.legal_ertificate_no = legal_ertificate_no;
	}

	@Override
	public String toString() {
		return "CreateCore [userName=" + userName + ", email=" + email + ", phone=" + phone + ", contact_person="
				+ contact_person + ", companyName=" + companyName + ", business_registration_no="
				+ business_registration_no + ", business_register_date=" + business_register_date + ", business_type="
				+ business_type + ", business_licence=" + business_licence + ", organization_code=" + organization_code
				+ ", business_register_capital=" + business_register_capital + ", company_address=" + company_address
				+ ", legal_cert_type=" + legal_cert_type + ", legal_person=" + legal_person + ", legal_ertificate_no="
				+ legal_ertificate_no + "]";
	}

}
