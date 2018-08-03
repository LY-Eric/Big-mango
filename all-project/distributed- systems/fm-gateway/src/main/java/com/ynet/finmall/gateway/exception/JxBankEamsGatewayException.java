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
import com.ynet.finmall.gateway.jxbank.JxBankSignUtil;
import com.ynet.finmall.gateway.jxbank.response.AbstractJxBankResponse;

/**
 * 嘉兴银行 二类户系统 网关异常
 * @author liuxin
 *
 */
public class JxBankEamsGatewayException extends FinMallException {
	private static Logger logger = LoggerFactory.getLogger(JxBankEamsGatewayException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误代码
	 */
	private String recode;

	/**
	 * 错误信息
	 */
	private String recode_info;
	
	private String sign_data	;//C500	签名串
	
	public JxBankEamsGatewayException(String recode){
		String recode_info = MessageStaticUtils.getMessage(recode);
		this.abc(recode, recode_info);
	}
	
	public JxBankEamsGatewayException(String recode, String recode_info){
		this.abc(recode, recode_info);
	}
	
	public void abc(String recode, String recode_info){
		String returnMsg = MessageStaticUtils.getMessage(recode);
		this.recode = recode;
		this.recode_info = returnMsg;
		logger.debug("错误代码： recode " + recode + " 错误信息：recode_info " + recode_info);
		
		AbstractJxBankResponse res = new AbstractJxBankResponse();
		res.setRecode(recode);
		res.setRecode_info(this.recode_info);

		String reqStr = JSONObject.toJSONString(res);		//加签
        Map reqObj = JSON.parseObject(reqStr, LinkedHashMap.class, Feature.OrderedField);
		String sign_data = JxBankSignUtil.addSign(reqObj,JxBankSignUtil.MD5_KEY);
		this.sign_data=sign_data;
		res.setSign_data(sign_data);
	}
	
	public String getSign_data() {
		return sign_data;
	}

	public void setSign_data(String sign_data) {
		this.sign_data = sign_data;
	}

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
	
}
