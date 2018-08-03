package com.ynet.finmall.gateway.aliyuncs.request;

/**
 * 平台商户应收账款
 * @author liuxin
 *
 */
public class AddCollectionInfoOfProviderRequest extends AbstractAliyunRequest {

	private String platformName    ;//平台名
	private String siteMemId       ;//供应商代码（供应商在平台体系内的独立编号，唯一标识）
	private String providerName    ;//供应商名称
	private String payNo           ;//付款单据号
	private String currency        ;//币种
	private double amountTotal     ;//金额，单位（元）
	private int payStatus          ;//状态（0-未付款，1-已付款）
	private long billCreateDate    ;//应收账款产生日期
	private long dueDate           ;//应收账款到期日（付款日）(可选)
	
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
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmountTotal() {
		return amountTotal;
	}
	public void setAmountTotal(double amountTotal) {
		this.amountTotal = amountTotal;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public long getBillCreateDate() {
		return billCreateDate;
	}
	public void setBillCreateDate(long billCreateDate) {
		this.billCreateDate = billCreateDate;
	}
	public long getDueDate() {
		return dueDate;
	}
	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	
	
}
