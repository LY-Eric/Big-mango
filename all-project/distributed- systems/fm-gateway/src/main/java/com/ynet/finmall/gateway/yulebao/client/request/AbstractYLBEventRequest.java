package com.ynet.finmall.gateway.yulebao.client.request;

/**
 * 
 * 娱乐宝请求公共报文体
 * (由娱乐宝定义)
 * @author liuxin
 *
 */
public abstract class AbstractYLBEventRequest {

	private String app_no          ;//应用编号     
	private String channel_no      ;//渠道编号        
	private String sign_data       ;//签名串
	
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
