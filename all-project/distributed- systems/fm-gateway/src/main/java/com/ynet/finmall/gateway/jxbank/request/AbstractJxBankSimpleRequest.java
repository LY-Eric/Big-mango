package com.ynet.finmall.gateway.jxbank.request;

/**
 * 公共请求
 * 去掉 应用编号  
 * @author liuxin
 *
 */
public abstract class AbstractJxBankSimpleRequest {

	private String channel_no = "0001"       ;//渠道编号        
	private String sign_data                ;//签名串
	
	public abstract String getServerCode();
	
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
