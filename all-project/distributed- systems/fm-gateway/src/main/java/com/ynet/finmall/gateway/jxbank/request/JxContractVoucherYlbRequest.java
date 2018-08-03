package com.ynet.finmall.gateway.jxbank.request;

/**
 * @Description 合同存证
 * @Author 刘俊重
 * @String 2018/1/4
 */
public class JxContractVoucherYlbRequest {
	private String pro_id;//产品编号
	private String comerchant_apply_no;//商户申请编号
	private String customer;//姓名/名称
	private String apply_id;//贷款编号
	private String contract_file;//合同文件
	private String trans_date;//操作日期
	private String trans_tradetime;//操作时间
	private String service_id;  //个人签章id

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

	public String getContract_file() {
		return contract_file;
	}

	public void setContract_file(String contract_file) {
		this.contract_file = contract_file;
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

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	//接口名称
	public String getServerCode() {
		return "api/v1/loan/contract_voucher_ylb.do";
	}

}
