package com.ynet.finmall.gateway.jxbank.request;

/**
 * 嘉兴银行对账文件下载请求参数
 * 
 * @author qiangjiyi
 * @date 2018年1月12日 下午4:49:34
 */
public class JxOrderDownFileRequest extends AbstractJxBankRequest {

	private String serial_no;// 流水号

	private String down_type;// 下载类型

	private String data_type;// C1 数据类型 N 0：文件名 1：文件流。默认文件名

	private String accountDate;// 对账日期

	private String receive_url; // 回调地址

	private String trans_date;// 操作日期

	private String trans_tradetime;// 操作时间

	private String trans_teller; // 操作柜员

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getDown_type() {
		return down_type;
	}

	public void setDown_type(String down_type) {
		this.down_type = down_type;
	}

	public String getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
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

	public String getTrans_teller() {
		return trans_teller;
	}

	public void setTrans_teller(String trans_teller) {
		this.trans_teller = trans_teller;
	}

	// 接口名称
	public String getServerCode() {
		// return "api/v1/order/downfile.do";
		return "security/down";
	}
}
