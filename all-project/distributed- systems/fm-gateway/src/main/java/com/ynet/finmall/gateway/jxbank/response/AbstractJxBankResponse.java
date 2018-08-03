package com.ynet.finmall.gateway.jxbank.response;

/**
 * 公共响应
 * @author liuxin
 *
 */
public class AbstractJxBankResponse {

	private String recode	    ;	//返回码
	private String recode_info	;//含义
	private String sign_data	;//C500	签名串
	
	public String getRecode() {
		return recode;
	}
	public void setRecode(String recode) {
		this.recode = recode;
	}
	public String getRecode_info() {
		return recode_info;
	}
	public void setRecode_info(String recode_info) {
		this.recode_info = recode_info;
	}
	public String getSign_data() {
		return sign_data;
	}
	public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}
	
}
