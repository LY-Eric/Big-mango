package com.ynet.finmall.common.request;

/**
 * 公共请求参数
 */
public abstract class AbstractRequest {

	private String app_no          ;//应用编号     
	private String channel_no      ;//渠道编号        
	private String sign_data	   ;//签名串
	private String sign_type       ;//签名方式
	
	public String getApp_no() {
		return app_no;
	}
	public void setApp_no(String app_no) {
		this.app_no = app_no;
	}
	public String getChannel_no() {
		return channel_no;
	}
	public void setChannel_no(String channel_no) {
		this.channel_no = channel_no;
	}
	public String getSign_data() {
		return sign_data;
	}
	public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	
}