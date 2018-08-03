package com.ynet.finmall.gateway.jxbank.event;

/**
 * 对账文件数据内容
 * @author qiangjiyi
 * @date 2018年1月12日 下午4:59:36
 */
public class OrderDownFileDetail {
	private String serial_no;// 交易流水号

	private String channel_no;// 渠道编号

	private String batch_file;//批量结果文件

	
	
	
	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getChannel_no() {
		return channel_no;
	}

	public void setChannel_no(String channel_no) {
		this.channel_no = channel_no;
	}

	public String getBatch_file() {
		return batch_file;
	}

	public void setBatch_file(String batch_file) {
		this.batch_file = batch_file;
	}
}
