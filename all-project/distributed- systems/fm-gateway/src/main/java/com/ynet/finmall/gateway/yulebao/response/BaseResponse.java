package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：
 * @author liaoyy@belink.com
 */
public class BaseResponse {

	/**
	 * 成功
	 */
	public final static String SUCCESS = "0";

	protected String code;
	protected String msg;

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
