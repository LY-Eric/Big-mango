package com.ynet.finmall.gateway.yulebao.request;

/**
 * @Description 申请贷款文件列表
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class YLBApplyYlbList {

	private int file_type;//文件类型
	private String file;//文件内容

	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
