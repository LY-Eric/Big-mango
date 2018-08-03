package com.ynet.finmall.gateway.yulebao.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * 核心企业信息表
 * 
 * @author 刘俊重
 * @email magichair522@gmail.com
 * @date 2017-11-24 10:02:52
 */
public class CoreCorpInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	// ID
	private Long id;
	// 帐号
	@NotNull(message = "账号不能为空")
	private String userName;

	// 商户ID(finmallID)
	private Long finmallId;
	// 支付宝用户ID
	private String alipayUserId;
	// 支付宝账号
	private String alipayNo;
	// 公司简称
	private String companyNameAbbreviation;

	// 公司全称
	@NotNull(message = "公司名称不能为空")
	private String companyName;

	// 工商注册号
	@NotNull(message = "营业执照号不能为空")
	private String businessRegistrationNo;

	// 平台名称
	private String platformName;

	// 邮箱
	@NotNull(message = "邮箱不能为空")
	private String email;
	// 联系电话
	private String phone;
	// 联系人姓名
	private String contactPerson;
	// 创建时间
	private Date createTime;
	// 合作状态
	private String state;

	// 娱乐宝新增____________________________________________开始
	/**
	 * 工商注册日期
	 */
	private String businessRegisterDate;
	/**
	 * 工商注册类型 工商注册类型，1-统一社会信用代码，2-营业执照&组织机构代码
	 */
	private String businessType;
	/**
	 * 营业执照
	 */
	@NotNull(message = "营业执照不能为空")
	private String businessLicence;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 注册资本
	 */
	private String businessRegisterCapital;
	/**
	 * 企业地址
	 */
	private String companyAddress;
	/**
	 * 法人证件类型 1-身份证2-护照3-军人证
	 */
	private String legalCertType;
	/**
	 * 法人姓名
	 */
	private String legalPerson;
	/**
	 * 法人证件号
	 */
	private String legalErtificateNo;

	// 娱乐宝新增____________________________________________结束

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessType() {
		return businessType;
	}

	public String getBusinessLicence() {
		return businessLicence;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public String getBusinessRegisterCapital() {
		return businessRegisterCapital;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getLegalCertType() {
		return legalCertType;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public String getBusinessRegisterDate() {
		return businessRegisterDate;
	}

	public void setBusinessRegisterDate(String businessRegisterDate) {
		this.businessRegisterDate = businessRegisterDate;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public void setBusinessRegisterCapital(String businessRegisterCapital) {
		this.businessRegisterCapital = businessRegisterCapital;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public void setLegalCertType(String legalCertType) {
		this.legalCertType = legalCertType;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalErtificateNo() {
		return legalErtificateNo;
	}

	public void setLegalErtificateNo(String legalErtificateNo) {
		this.legalErtificateNo = legalErtificateNo;
	}

	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getFinmallId() {
		return finmallId;
	}

	public void setFinmallId(Long finmallId) {
		this.finmallId = finmallId;
	}

	/**
	 * 设置：支付宝用户ID
	 */
	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}

	/**
	 * 获取：支付宝用户ID
	 */
	public String getAlipayUserId() {
		return alipayUserId;
	}

	/**
	 * 设置：支付宝账号
	 */
	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	/**
	 * 获取：支付宝账号
	 */
	public String getAlipayNo() {
		return alipayNo;
	}

	/**
	 * 设置：公司简称
	 */
	public void setCompanyNameAbbreviation(String companyNameAbbreviation) {
		this.companyNameAbbreviation = companyNameAbbreviation;
	}

	/**
	 * 获取：公司简称
	 */
	public String getCompanyNameAbbreviation() {
		return companyNameAbbreviation;
	}

	/**
	 * 设置：公司全称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取：公司全称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置：工商注册号
	 */
	public void setBusinessRegistrationNo(String businessRegistrationNo) {
		this.businessRegistrationNo = businessRegistrationNo;
	}

	/**
	 * 获取：工商注册号
	 */
	public String getBusinessRegistrationNo() {
		return businessRegistrationNo;
	}

	/**
	 * 设置：平台名称
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	/**
	 * 获取：平台名称
	 */
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置：联系人姓名
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * 获取：联系人姓名
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：合作状态
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 获取：合作状态
	 */
	public String getState() {
		return state;
	}
}
