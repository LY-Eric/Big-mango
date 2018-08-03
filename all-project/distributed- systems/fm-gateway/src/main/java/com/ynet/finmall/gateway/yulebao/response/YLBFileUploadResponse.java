package com.ynet.finmall.gateway.yulebao.response;

/**
 * 上传文件返回
 * 
 * @author xuhui
 *
 */
public class YLBFileUploadResponse extends AbstractYLBResponse {

	private FileUploadInfo data;

	public FileUploadInfo getData() {
		return data;
	}

	public void setData(FileUploadInfo data) {
		this.data = data;
	}

}
