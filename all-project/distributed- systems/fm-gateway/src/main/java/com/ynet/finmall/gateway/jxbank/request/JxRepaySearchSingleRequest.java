package com.ynet.finmall.gateway.jxbank.request;

/**
 * 备注：贷款归还结果查询（单笔）
 * 
 * @author liaoyy@belink.com
 */
public class JxRepaySearchSingleRequest {
	private String pro_id;// C32 产品编号
	private String repay_serial_no; // C32 归还流水号
	private String receipt_id;// C32 借据编号
	private String trans_date; // C10 操作日期
	private String trans_tradetime; // C19 操作时间

	public String getPro_id() {
		return pro_id;
	}

	public String getRepay_serial_no() {
		return repay_serial_no;
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

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public void setRepay_serial_no(String repay_serial_no) {
		this.repay_serial_no = repay_serial_no;
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

	public String getServerCode() {

		return "api/v1/loan/repay_search_single_ylb.do";
	}

	@Override
	public String toString() {
		return "YLBRepaySearchSingleRequest [pro_id=" + pro_id + ", repay_serial_no=" + repay_serial_no
				+ ", receipt_id=" + receipt_id + ", trans_date=" + trans_date + ", trans_tradetime=" + trans_tradetime
				+ "]";
	}
}
