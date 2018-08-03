package com.ynet.finmall.gateway.jxbank.request;

import com.ynet.finmall.gateway.yulebao.request.ReturnInfo;

import java.util.List;


/**
 * 贷款归还（批量）输入参数
 * 
 * @author xuhui
 *
 */
public class JxLoanReturnRequest {

	private String pro_id              ; //产品编号

	private String batch_serial_no     ; //批次流水号

	private List<ReturnInfo> repay_list   ; //

	private String receive_url         ; //回调地址

	private String  trans_date ;         //操作日期

	private String  trans_tradetime ;   //操作时间

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getBatch_serial_no() {
		return batch_serial_no;
	}

	public void setBatch_serial_no(String batch_serial_no) {
		this.batch_serial_no = batch_serial_no;
	}

	public List<ReturnInfo> getRepay_list() {
		return repay_list;
	}

	public void setRepay_list(List<ReturnInfo> repay_list) {
		this.repay_list = repay_list;
	}

	public String getReceive_url() {
		return receive_url;
	}

	public void setReceive_url(String receive_url) {
		this.receive_url = receive_url;
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

		return "api/v1/loan/repay_batch_ylb.do";
	}

}
