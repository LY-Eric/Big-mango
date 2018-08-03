package com.ynet.finmall.gateway.jxbank.request;



/**
 * jx二类户  公共请求
 * @author liuxin
 *
 */
public abstract class AbstractJxBankRequest {

	private String app_no = "32"            ;//应用编号     
	private String channel_no = "0001"       ;//渠道编号        
	private String sign_data                ;//签名串

	public abstract String getServerCode();
	
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
	
}
