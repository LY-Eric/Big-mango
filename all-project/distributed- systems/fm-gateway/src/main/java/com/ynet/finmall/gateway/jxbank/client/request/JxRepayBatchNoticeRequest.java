package com.ynet.finmall.gateway.jxbank.client.request;

import java.util.List;

import com.ynet.finmall.gateway.jxbank.event.RepayDetail;

/**
 * 贷款归还异步通知(批量)请求参数
 * @author qiangjiyi
 * @date 2018年1月5日 下午2:30:49
 */
public class JxRepayBatchNoticeRequest extends AbstractLoanRequest {

	private String pro_id;// 产品编号
	
	private String batch_serial_no;// 批次流水号
	
	private String trans_date;// 操作日期
	
	private String trans_tradetime;// 操作时间
	
	private List<RepayDetail> repay_list;// 归还明细

	public List<RepayDetail> getRepay_list() {
		return repay_list;
	}

	public void setRepay_list(List<RepayDetail> repay_list) {
		this.repay_list = repay_list;
	}

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
