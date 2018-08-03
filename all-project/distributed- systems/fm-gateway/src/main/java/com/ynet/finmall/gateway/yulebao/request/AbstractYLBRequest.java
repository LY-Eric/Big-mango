package com.ynet.finmall.gateway.yulebao.request;

/**
 * ylb 公共请求
 * @author xuhui
 *
 */
public abstract class AbstractYLBRequest {
	private String app_no          ;//应用编号     
	private String channel_no      ;//渠道编号        
	private String sign_data       ;//签名串
	private Long finmall_id;//非必要
	
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
	public Long getFinmall_id() {
		return finmall_id;
	}
	public void setFinmall_id(Long finmall_id) {
		this.finmall_id = finmall_id;
	}
	
}