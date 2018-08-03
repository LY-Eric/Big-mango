package com.ynet.finmall.gateway.jxbank.request;

/**
 * @Description 贷款审批查询
 * @Author 刘俊重
 * @Date 2018/3/15
 */
public class JxIngApprovalYlbRequest {

	private String pro_id; // 产品编号
	private String apply_id; // 流水号
	private String customer; // 姓名/名称
	private String comerchant_apply_no; // 商户申请编号
	private String trans_date; // 操作日期
	private String trans_tradetime; // 操作时间


	public String getApply_id() {
		return apply_id;
	}

	public String getCustomer() {
		return customer;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public String getTrans_tradetime() {
		return trans_tradetime;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getComerchant_apply_no() {
		return comerchant_apply_no;
	}

	public void setComerchant_apply_no(String comerchant_apply_no) {
		this.comerchant_apply_no = comerchant_apply_no;
	}

	public String getServerCode() {

		return "api/v1/loan/inq_approval_ylb.do";
	}

}
