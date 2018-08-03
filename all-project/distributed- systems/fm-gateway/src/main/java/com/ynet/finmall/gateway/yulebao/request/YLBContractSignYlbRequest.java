package com.ynet.finmall.gateway.yulebao.request;

/**
 * @Description 合同盖章
 * @Author 刘俊重
 * @Date 2018/1/4
 */
public class YLBContractSignYlbRequest extends AbstractYLBRequest {
	private Long finmall_id; // 飞猫id
	private String pro_id;// 产品编号
	private String comerchant_apply_no;// 商户申请编号
	private String customer;// 姓名/名称
	private String apply_id;// 贷款编号
	private String contract_file;// 合同文件
	private String trans_date;// 操作日期
	private String trans_tradetime;// 操作时间

	// -----------------------
	private String contract_file_url; // 合同文件在我们oss上的保存路径
	private String service_id;  //E签宝行方盖章后的ID(银行返给我们的)

	public Long getFinmall_id() {
		return finmall_id;
	}

	public void setFinmall_id(Long finmall_id) {
		this.finmall_id = finmall_id;
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

	public String getContract_file_url() {
		return contract_file_url;
	}

	public void setContract_file_url(String contract_file_url) {
		this.contract_file_url = contract_file_url;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
}
