package com.ynet.finmall.gateway.jxbank.client.request;

/**
 * 嘉兴银行 网贷系统 请求公共参数
 * @author liuxin
 */
public abstract class AbstractLoanRequest {

	private String sign_type          ;//签名方式
	private String sign               ;//签名    
	
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
