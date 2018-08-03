package com.ynet.finmall.common.response;

/**
 * 公共响应参数
 *
 */
public class AbstractResponse {

	public static final String SUCCESS = "000000";
	public static final String SUCCESSMSG = "成功";

	private String returnCode = SUCCESS;// 返回码
	private String returnMsg = SUCCESSMSG;// 含义
	private String sign_data;// 签名串
	private String sign_type;// 签名方式

	public AbstractResponse() {
		super();
	}

	public AbstractResponse(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign_data() {
		return sign_data;
	}

	public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}
}
