package com.ynet.finmall.gateway.jxbank.client.response;

/**
 * 嘉兴银行 网贷系统 响应公共参数
 * @author liuxin
 */
public class AbstractLoanResponse {

	public static final String CODE_SUCCESS = "000000";
	public static final String MSG_SUCCESS = "成功";
	
	private String code     = CODE_SUCCESS    ;// 返回码  
	private String msg      = MSG_SUCCESS     ;// 含义     
	private String sign_type     ;//签名方式
	private String sign          ;//签名
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
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
