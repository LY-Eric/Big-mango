package com.ynet.finmall.gateway.jxbank.aop;

import java.util.LinkedHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.JxBankLoanGatewayException;
import com.ynet.finmall.gateway.jxbank.JxBankLoanSignUtil;
import com.ynet.finmall.gateway.jxbank.JxBankSignUtil;
import com.ynet.finmall.gateway.jxbank.client.response.AbstractLoanResponse;
import com.ynet.finmall.gateway.jxbank.response.AbstractJxBankResponse;

/**
 * 嘉兴银行 网贷系统 签名验证
 * 
 * 异步通知接口
 * 当前只提供给嘉兴银行 网贷系统 的 异步通知接口的请求验密 和 响应加密
 * 
 * @author liuxin
 *
 */
@Aspect
@Component
public class JxBankLoanSignAspest {

	private static Logger logger = LoggerFactory.getLogger(JxBankLoanSignAspest.class);
	
	@Pointcut("execution (* com.ynet.finmall.gateway.jxbank.controller.*.*(..))")
	public void declareJoinPointExpression() {
	}

	/**
	 * 环绕通知
	 * @throws Throwable 
	 */
	@Around(value = "declareJoinPointExpression()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object[] object = pjp.getArgs();
		
		String resultString = JSON.toJSONString(object[0]);
		logger.info("请求过来验签前的原始json数据为：" + resultString);
		//签名验证
		checkSign(resultString);
		
		//渠道检查 //TODO 未来应该有统一的渠道认证 检查加密方式、是否具有访问该接口的权限等
		
		Object obj = null;
		
		obj = pjp.proceed();
//		try {
//		} catch (Throwable e) {
//		}
		
		String reqStr = JSONObject.toJSONString(obj);

		//使用json默认排序功能
//        JSONObject jsonObj = JSONObject.parseObject(reqStr);
        
		//加签
		if(obj instanceof AbstractLoanResponse){
			String sign_data = JxBankLoanSignUtil.addSign(JSON.parseObject(reqStr, LinkedHashMap.class, Feature.OrderedField), JxBankLoanSignUtil.MD5_KEY);
			AbstractLoanResponse res = (AbstractLoanResponse)obj;
			res.setSign(sign_data);
			res.setSign_type("MD5");
		} else if(obj instanceof AbstractJxBankResponse){
			String sign_data = JxBankSignUtil.addSign(JSON.parseObject(reqStr, LinkedHashMap.class, Feature.OrderedField), JxBankLoanSignUtil.MD5_KEY);
			AbstractJxBankResponse res = (AbstractJxBankResponse)obj;
			res.setSign_data(sign_data);
		}
		
		return obj;
	}

	/**
	 * 响应参数签名验证
	 */
	public static boolean checkSign(String resultString){
		boolean checkSign = JxBankLoanSignUtil.checkSign(resultString,JxBankLoanSignUtil.MD5_KEY);
		if(!checkSign){
			throw new JxBankLoanGatewayException(GatewayErrorConstants.JX_CHECK_SIGN);
		}
		return checkSign;
	}
	
}
