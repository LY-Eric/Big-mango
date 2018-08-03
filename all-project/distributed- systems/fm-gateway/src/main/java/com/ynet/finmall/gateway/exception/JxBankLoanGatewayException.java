package com.ynet.finmall.gateway.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.ynet.exception.FinMallException;
import com.ynet.exception.MessageStaticUtils;
import com.ynet.finmall.gateway.jxbank.JxBankLoanSignUtil;
import com.ynet.finmall.gateway.jxbank.JxBankSignUtil;
import com.ynet.finmall.gateway.jxbank.client.response.AbstractLoanResponse;

/**
 * 嘉兴银行 网贷系统 网关异常
 * @author liuxin
 *
 */
public class JxBankLoanGatewayException extends FinMallException {
	private static Logger logger = LoggerFactory.getLogger(JxBankLoanGatewayException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误代码
	 */
	private String code;

	/**
	 * 错误信息
	 */
	private String msg;
	
	private String sign_type;
	
	private String sign	;
	
	public JxBankLoanGatewayException(String recode){
		String recode_info = MessageStaticUtils.getMessage(recode);
		this.abc(recode, recode_info);
	}
	
	public JxBankLoanGatewayException(String recode, String recode_info){
		this.abc(recode, recode_info);
	}

	public void abc(String recode, String recode_info){

		this.code = recode;
		this.msg = recode_info;
		logger.debug("错误代码： code " + code + " 错误信息：msg " + msg);
		
		AbstractLoanResponse res = new AbstractLoanResponse();
		res.setCode(recode);
		res.setMsg(recode_info);

		String reqStr = JSONObject.toJSONString(res);		//加签
        Map reqObj = JSON.parseObject(reqStr, LinkedHashMap.class, Feature.OrderedField);
		String sign_data = JxBankLoanSignUtil.addSign(reqObj, JxBankSignUtil.MD5_KEY);
		this.sign_type="MD5";
		this.sign = sign_data;
		res.setSign(sign_data);
		res.setSign_type(sign_type);
	
	}
	
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
