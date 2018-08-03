package com.ynet.finmall.gateway.aliyuncs.request;

/**
 * 平台商户基本信息
 * @author liuxin
 *
 */
public class CreateProviderRequest extends AbstractAliyunRequest {
	
	private String  platformName					 ;//平台名
	private String  siteMemId						 ;//供应商代码（供应商在平台体系内的独立编号，唯一标识）
	private String  providerName					 ;//供应商名称
	private String  companyName						 ;//公司名称
	private String  businessRegistrationNo			;//工商注册号
	private String  alipayNo						 ;//支付宝账号（申请贷款、还款账号），邮箱号或是手机号
	private long    contractBeginDate			 ;//当前合同开始日期
	private long    contractExpirationDate 		;//当前合同到期日
	private int     contractStatus				 ;//当前合同状态，1-有效，0-无效
	private String  accountSubject				 ;//收款账号主体，个人或企业
	
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getSiteMemId() {
		return siteMemId;
	}
	public void setSiteMemId(String siteMemId) {
		this.siteMemId = siteMemId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusinessRegistrationNo() {
		return businessRegistrationNo;
	}
	public void setBusinessRegistrationNo(String businessRegistrationNo) {
		this.businessRegistrationNo = businessRegistrationNo;
	}
	public String getAlipayNo() {
		return alipayNo;
	}
	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}
	public long getContractBeginDate() {
		return contractBeginDate;
	}
	public void setContractBeginDate(long contractBeginDate) {
		this.contractBeginDate = contractBeginDate;
	}
	public long getContractExpirationDate() {
		return contractExpirationDate;
	}
	public void setContractExpirationDate(long contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}
	public int getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(int contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getAccountSubject() {
		return accountSubject;
	}
	public void setAccountSubject(String accountSubject) {
		this.accountSubject = accountSubject;
	}

	
	
}
