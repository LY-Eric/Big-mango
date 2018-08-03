package com.ynet.finmall.gateway.jxbank.response;

/**
 * 单个文件信息
 * 
 * @author xuhui
 *
 */
public class FileSaveInfo {

	private Integer file_index;// 文件序号
	private String file_no    ;// 文件编号

	public Integer getFile_index() {
		return file_index;
	}

	public void setFile_index(Integer file_index) {
		this.file_index = file_index;
	}


	public String getFile_no() {
		return file_no;
	}

	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}

}