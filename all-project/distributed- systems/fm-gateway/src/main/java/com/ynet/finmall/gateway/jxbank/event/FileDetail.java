package com.ynet.finmall.gateway.jxbank.event;

public class FileDetail {
	/**
	 * 文件编号
	 */
	private String file_no;
	
	/**
	 * 文件类型
	 * @link com.ynet.finmall.gateway.jxbank.enums.File_type;
	 */
	private String file_type;
	
	/**
	 * 文件页码
	 */
	private int file_page;
	
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public int getFile_page() {
		return file_page;
	}
	public void setFile_page(int file_page) {
		this.file_page = file_page;
	}
	
	
}
