package com.ynet.finmall.gateway.yulebao.request;

/**
 * 备注：贷款放款查询
 * 
 * @author liaoyy@belink.com
 */
public class YLBInqGrantRequest extends AbstractYLBRequest {
	private String pro_id; // 产品编号
	private String comerchant_receipt_no; // 商户借据编号
	private String customer; // 姓名/名称
	private String apply_id; // 贷款编号
	private String receipt_id; // 借据编号
	private String trans_date; // 操作日期
	private String trans_tradetime; // 操作时间

	public String getCustomer() {
		return customer;
	}

	public String getReceipt_id() {
		return receipt_id;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public String getTrans_tradetime() {
		return trans_tradetime;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public void setTrans_tradetime(String trans_tradetime) {
		this.trans_tradetime = trans_tradetime;
	}

	public String getPro_id() {
		return pro_id;
	}

	public String getComerchant_receipt_no() {
		return comerchant_receipt_no;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public void setComerchant_receipt_no(String comerchant_receipt_no) {
		this.comerchant_receipt_no = comerchant_receipt_no;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	@Override
	public String toString() {
		return "YLBInqGrantRequest [pro_id=" + pro_id + ", comerchant_receipt_no=" + comerchant_receipt_no
				+ ", apply_id=" + apply_id + "]";
	}

}
