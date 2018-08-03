package com.ynet.finmall.gateway.jxbank.client.request;


/**
 * @Description 贷款申请
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class ApplyYlbCallBackRequest extends AbstractLoanRequest{

	private String pro_id;//产品编号
	private String comerchant_apply_no;//商户申请编号
	private String customer;//姓名/名称
	private String apply_id;//贷款编号
	private String approval_status;//审批结果
	private String approval_note;//拒绝原因
	private String voucher_no;//存证编号
	private String trans_date;//操作日期
	private String trans_tradetime;//操作时间

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getComerchant_apply_no() {
		return comerchant_apply_no;
	}

	public void setComerchant_apply_no(String comerchant_apply_no) {
		this.comerchant_apply_no = comerchant_apply_no;
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

	public String getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}

	public String getApproval_note() {
		return approval_note;
	}

	public void setApproval_note(String approval_note) {
		this.approval_note = approval_note;
	}

	public String getVoucher_no() {
		return voucher_no;
	}

	public void setVoucher_no(String voucher_no) {
		this.voucher_no = voucher_no;
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
