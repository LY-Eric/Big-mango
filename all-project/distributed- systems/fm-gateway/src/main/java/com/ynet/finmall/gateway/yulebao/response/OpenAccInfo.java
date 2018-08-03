package com.ynet.finmall.gateway.yulebao.response;

public class OpenAccInfo {
	private String original_serialno;// C32 原交易流水号
	private String account_no;// C32 账号
	private String customer_no;// C32 客户号
	private String finmall_id;

	public String getOriginal_serialno() {
		return original_serialno;
	}

	public String getAccount_no() {
		return account_no;
	}

	public String getCustomer_no() {
		return customer_no;
	}

	public String getFinmall_id() {
		return finmall_id;
	}

	public void setOriginal_serialno(String original_serialno) {
		this.original_serialno = original_serialno;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}

	public void setFinmall_id(String finmall_id) {
		this.finmall_id = finmall_id;
	}

}
