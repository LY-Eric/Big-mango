package com.ynet.finmall.gateway.jxbank.request;

import com.ynet.finmall.gateway.yulebao.request.RepayPlan;

import java.math.BigDecimal;
import java.util.List;


/**
 * 贷款发放
 * @author xuhui
 *
 */
public class JxLoanGrantRequest {
    private String  pro_id ;   //产品编号
	private String  comerchant_receipt_no ;   //商户借据编号
	private String  customer ;   //姓名/名称
	private String  apply_id ;   //贷款编号
	private BigDecimal  loan_amount ;   //放款金额
	private BigDecimal  interest_rate ;   //利率
	private List<RepayPlan>  repay_list ;   //
	private String  trans_date ;         //操作日期
	private String  trans_tradetime ;   //操作时间
	
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


	public BigDecimal getLoan_amount() {
		return loan_amount;
	}


	public void setLoan_amount(BigDecimal loan_amount) {
		this.loan_amount = loan_amount;
	}


	public BigDecimal getInterest_rate() {
		return interest_rate;
	}


	public void setInterest_rate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	}


	public List<RepayPlan> getRepay_list() {
		return repay_list;
	}


	public void setRepay_list(List<RepayPlan> repay_list) {
		this.repay_list = repay_list;
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



	public String getServerCode() {
		return "api/v1/loan/grant_ylb.do";
	}
	
	
}
