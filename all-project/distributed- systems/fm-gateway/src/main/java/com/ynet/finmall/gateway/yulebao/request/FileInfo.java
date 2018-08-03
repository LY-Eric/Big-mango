package com.ynet.finmall.gateway.yulebao.request;

/**
 * 单个文件信息
 * 
 * @author xuhui
 *
 */
public class FileInfo {

	private Integer file_index;// 文件序号
	private String file_data  ;// base64编码的zip文件

	public Integer getFile_index() {
		return file_index;
	}

	public void setFile_index(Integer file_index) {
		this.file_index = file_index;
	}

	public String getFile_data() {
		return file_data;
	}

	public void setFile_data(String file_data) {
		this.file_data = file_data;
	}


}