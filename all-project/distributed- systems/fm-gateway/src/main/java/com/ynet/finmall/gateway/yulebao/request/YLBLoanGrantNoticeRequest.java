package com.ynet.finmall.gateway.yulebao.request;

/**
 * 贷款发放
 * 
 * @author xuhui
 *
 */
public class YLBLoanGrantNoticeRequest extends AbstractYLBRequest {
	private String pro_id; // 产品编号
	private String comerchant_receipt_no; // 商户借据编号
	private String customer; // 姓名/名称
	private String apply_id; // 贷款编号
	private String receipt_id; // 借据编号
	private Integer grant_status; // 放款结果
	private String grant_note; // 失败原因
	private String trans_date; // 操作日期
	private String trans_tradetime; // 操作时间

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getComerchant_receipt_no() {
		return comerchant_receipt_no;
	}

	public void setComerchant_receipt_no(String comerchant_receipt_no) {
		this.comerchant_receipt_no = comerchant_receipt_no;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public Integer getGrant_status() {
		return grant_status;
	}

	public void setGrant_status(Integer grant_status) {
		this.grant_status = grant_status;
	}

	public String getGrant_note() {
		return grant_note;
	}

	public void setGrant_note(String grant_note) {
		this.grant_note = grant_note;
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

}
