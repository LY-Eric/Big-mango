package com.ynet.finmall.gateway.exception;

import com.alibaba.fastjson.JSONObject;
import com.ynet.exception.FinMallException;
import com.ynet.finmall.gateway.yulebao.aop.YLBSignUtil;
import com.ynet.finmall.gateway.yulebao.response.AbstractYLBResponse;

/**
 * 娱乐宝网关异常
 * @author liuxin
 *
 */
public class YLBGatewayException extends FinMallException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sign_data	;//C500	签名串
	private String sign_type    ;//签名方式
	
	public YLBGatewayException(String code){
		super(code);
		AbstractYLBResponse res = new AbstractYLBResponse();
		res.setReturnCode(this.getReturnCode());
		res.setReturnMsg(this.getReturnMsg());

		String reqStr = JSONObject.toJSONString(res);		//加签
		String sign_data = YLBSignUtil.addSign(reqStr);
		this.sign_data=sign_data;
		this.sign_type="MD5";		
		res.setSign_data(sign_data);
		res.setSign_type(sign_type);
		
	}
	
	public YLBGatewayException(String code, String msg){
		super(code, msg);
		AbstractYLBResponse res = new AbstractYLBResponse();
		res.setReturnCode(this.getReturnCode());
		res.setReturnMsg(this.getReturnMsg());

		String reqStr = JSONObject.toJSONString(res);		//加签
		String sign_data = YLBSignUtil.addSign(reqStr);
		this.sign_data=sign_data;
		this.sign_type="MD5";		
		res.setSign_data(sign_data);
		res.setSign_type(sign_type);
		
	}
	
	
	public YLBGatewayException(String code, Object response) {
		super(code);
		
		if(response instanceof AbstractYLBResponse){
			((AbstractYLBResponse) response).setReturnCode(this.getReturnCode());
			((AbstractYLBResponse)response).setReturnMsg(this.getReturnMsg());
			String reqStr = JSONObject.toJSONString(response);		//加签
			String sign_data = YLBSignUtil.addSign(reqStr);
			((AbstractYLBResponse)response).setSign_data(sign_data);
			((AbstractYLBResponse)response).setSign_type("MD5");
			this.sign_data=sign_data;
			this.sign_type="MD5";
		}
	}
	
	public YLBGatewayException(String code, String msg, Object response){
		super(code, msg);
		if(response instanceof AbstractYLBResponse){
			((AbstractYLBResponse) response).setReturnCode(this.getReturnCode());
			((AbstractYLBResponse)response).setReturnMsg(this.getReturnMsg());
			String reqStr = JSONObject.toJSONString(response);		//加签
			String sign_data = YLBSignUtil.addSign(reqStr);
			((AbstractYLBResponse)response).setSign_data(sign_data);
			((AbstractYLBResponse)response).setSign_type("MD5");
			this.sign_data=sign_data;
			this.sign_type="MD5";
		}
	}

	public String getSign_data() {
		return sign_data;
	}

	public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	
	
	
}
