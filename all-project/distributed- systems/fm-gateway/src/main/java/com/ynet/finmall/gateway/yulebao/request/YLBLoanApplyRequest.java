package com.ynet.finmall.gateway.yulebao.request;

import java.util.List;

/**
 * 贷款申请输入参数
 * 
 * @author xuhui
 *
 */
public class YLBLoanApplyRequest extends AbstractYLBRequest {
	private String pro_id; // 产品编号
	private String comerchant_apply_no; // 商户申请编号
	private String customer; // 姓名/名称
	private String customer_mobile; // 手机
	private String bank_card; // 还款账号
	private String customer_idcard; // 证件号码/营业执照
	private String loan_use; // 用途
	private String loan_money; // 金额
	private Integer loan_duration; // 贷款期限
	private String loan_kkzq; // 还款周期
	private String loan_repay; // 还款方式
	private String comerchant_order_no; // 商户订单编号
	private List<LoanFileInfo> file_list; // 身份信息
	private String receive_url; // 回调地址

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

	public String getCustomer_mobile() {
		return customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	public String getBank_card() {
		return bank_card;
	}

	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}

	public String getCustomer_idcard() {
		return customer_idcard;
	}

	public void setCustomer_idcard(String customer_idcard) {
		this.customer_idcard = customer_idcard;
	}

	public String getLoan_use() {
		return loan_use;
	}

	public void setLoan_use(String loan_use) {
		this.loan_use = loan_use;
	}

	public String getLoan_money() {
		return loan_money;
	}

	public void setLoan_money(String loan_money) {
		this.loan_money = loan_money;
	}

	public Integer getLoan_duration() {
		return loan_duration;
	}

	public void setLoan_duration(Integer loan_duration) {
		this.loan_duration = loan_duration;
	}

	public String getLoan_kkzq() {
		return loan_kkzq;
	}

	public void setLoan_kkzq(String loan_kkzq) {
		this.loan_kkzq = loan_kkzq;
	}

	public String getLoan_repay() {
		return loan_repay;
	}

	public void setLoan_repay(String loan_repay) {
		this.loan_repay = loan_repay;
	}

	public String getComerchant_order_no() {
		return comerchant_order_no;
	}

	public void setComerchant_order_no(String comerchant_order_no) {
		this.comerchant_order_no = comerchant_order_no;
	}

	public List<LoanFileInfo> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<LoanFileInfo> file_list) {
		this.file_list = file_list;
	}

	public String getReceive_url() {
		return receive_url;
	}

	public void setReceive_url(String receive_url) {
		this.receive_url = receive_url;
	}

}
