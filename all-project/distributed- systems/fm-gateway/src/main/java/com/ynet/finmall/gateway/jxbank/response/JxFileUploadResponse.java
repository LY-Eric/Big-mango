package com.ynet.finmall.gateway.jxbank.response;

import java.util.List;

/**
 * 上传文件返回
 * 
 * @author xuhui
 *
 */
public class JxFileUploadResponse extends AbstractJxBankResponse {

	private List<FileSaveInfo> file_list;
	private String sys_date;
	private String sys_time;

	public String getSys_date() {
		return sys_date;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}

	public List<FileSaveInfo> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<FileSaveInfo> file_list) {
		this.file_list = file_list;
	}

}
