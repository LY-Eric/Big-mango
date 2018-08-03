package com.ynet.finmall.gateway.yulebao.request;

import java.math.BigDecimal;

/**
 * @Description 贷款申请(供娱乐宝使用)
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class YLBApplyYlbRequest extends AbstractYLBRequest{
	private Long finmall_id;  //finmallid
	private String pro_id;//产品编号
	private String comerchant_apply_no;//商户申请编号
	private String customer;//姓名/名称
	private String customer_mobile;//手机
	private String bank_card;//还款账号
	private String customer_idcard;//证件号码/营业执照
	private String customer_no;  //客户号
	private String loan_use;//用途
	private BigDecimal loan_money;//金额
	private String loan_duration;//贷款期限，以日为单位
	private String loan_kkzq;//还款周期，以日为单位
	private String loan_repay;//还款方式
	private String trans_date;//操作日期
	private String trans_tradetime;//操作时间
	//--------------------供供应链使用
	private String apply_id;  //贷款申请id
	private Integer approval_status;  //审批结果
	private String approval_note;  //拒绝原因


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

	public BigDecimal getLoan_money() {
		return loan_money;
	}

	public void setLoan_money(BigDecimal loan_money) {
		this.loan_money = loan_money;
	}

	public String getLoan_duration() {
		return loan_duration;
	}

	public void setLoan_duration(String loan_duration) {
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

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}

	public Integer getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(Integer approval_status) {
		this.approval_status = approval_status;
	}

	public String getApproval_note() {
		return approval_note;
	}

	public void setApproval_note(String approval_note) {
		this.approval_note = approval_note;
	}
}

