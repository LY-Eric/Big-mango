package com.ynet.finmall.gateway.jxbank.response;

/**
 * 嘉兴银行对账文件下载响应参数
 * 
 * @author qiangjiyi
 * @date 2018年1月12日 下午4:49:34
 */
public class JxOrderDownFileResponse extends AbstractJxBankResponse {
	private String serial_no;// 交易流水号

	private String channel_no;// 渠道编号

	private String batch_file;// 批量结果文件

	private String file_data;// file_data Text base64编码的zip文件

	private String sys_date;// 系统日期
	private String sys_time;// 系统时间

	public String getSerial_no() {
		return serial_no;
	}

	public String getChannel_no() {
		return channel_no;
	}

	public String getBatch_file() {
		return batch_file;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public void setChannel_no(String channel_no) {
		this.channel_no = channel_no;
	}

	public void setBatch_file(String batch_file) {
		this.batch_file = batch_file;
	}

	public String getSys_date() {
		return sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}

	public String getFile_data() {
		return file_data;
	}

	public void setFile_data(String file_data) {
		this.file_data = file_data;
	}

}
