package com.ynet.finmall.gateway.yulebao.response;

import com.ynet.exception.ParamConstants;

/**
 * 娱乐宝公共响应
 * @author xuhui
 *
 */
public class AbstractYLBResponse {

	private String returnCode	= ParamConstants.SUCCESS;//返回码
	private String returnMsg	= ParamConstants.SUCCESSMSG;//含义
	private String sign_data	;//C500	签名串
	private String sign_type    ;//签名方式
	
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
