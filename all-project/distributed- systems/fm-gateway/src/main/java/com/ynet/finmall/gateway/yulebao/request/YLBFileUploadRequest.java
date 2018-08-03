package com.ynet.finmall.gateway.yulebao.request;

import java.util.List;

/**
 * 上传文件参数
 * 
 * @author xuhui
 *
 */
public class YLBFileUploadRequest extends AbstractYLBRequest {

	private List<FileInfo> file_list;
	private String trans_date;// 操作日期
	private String trans_tradetime;// 操作时间
	private String serial_no; // 流水号

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public List<FileInfo> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<FileInfo> file_list) {
		this.file_list = file_list;
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
