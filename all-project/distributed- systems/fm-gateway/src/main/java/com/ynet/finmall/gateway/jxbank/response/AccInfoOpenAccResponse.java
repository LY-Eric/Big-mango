package com.ynet.finmall.gateway.jxbank.response;

/**
 * 二类账户的开户
 * @author liuxin
 *
 */
public class AccInfoOpenAccResponse extends AbstractJxBankResponse{

	private String original_serialno	;//C32	原交易流水号
	private String account_no	;//C32	账号
	private String customer_no	;//C32	客户号
	
	public String getOriginal_serialno() {
		return original_serialno;
	}
	public void setOriginal_serialno(String original_serialno) {
		this.original_serialno = original_serialno;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}
	
}
