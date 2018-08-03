package com.ynet.finmall.gateway.yulebao.request;

/**
 * 备注：贷款归还（批量）查询输入参数
 * 
 * @author liaoyy@belink.com
 */
public class YLBLoanReturnQueryRequest extends AbstractYLBRequest {
	private String pro_id; // 产品编号
	private String batch_serial_no; // 批次流水号
	private String trans_date; // 操作日期
	private String trans_tradetime;// 操作时间

	public String getPro_id() {
		return pro_id;
	}

	public String getBatch_serial_no() {
		return batch_serial_no;
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

	public void setBatch_serial_no(String batch_serial_no) {
		this.batch_serial_no = batch_serial_no;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public void setTrans_tradetime(String trans_tradetime) {
		this.trans_tradetime = trans_tradetime;
	}

}