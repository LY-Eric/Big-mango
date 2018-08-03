package com.ynet.finmall.gateway.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ynet.exception.FinMallException;
import com.ynet.exception.ParamConstants;

/**
 * 异常统一处理
 * @author liuxin
 *
 */
public class MyGatewayExceptionHandler implements HandlerExceptionResolver {

	private static Logger logger = LoggerFactory.getLogger(MyGatewayExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		System.err.println("拦截器 MyExceptionHandler ");

		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		
		if(ex instanceof JxBankLoanGatewayException){

			String code = ((JxBankLoanGatewayException) ex).getCode();
			Object msg = ((JxBankLoanGatewayException) ex).getMsg();
			String sign = ((JxBankLoanGatewayException) ex).getSign();
			String signType = ((JxBankLoanGatewayException) ex).getSign_type();

			logger.debug("错误代码：  " + code + " 错误信息：" + msg);

			dataMap.put("code", code);
			dataMap.put("msg", msg);
			dataMap.put("sign", sign);
			dataMap.put("signType", signType);
			
			this.msgToView(dataMap, response);

			return null;
		} else if(ex instanceof JxBankEamsGatewayException){

			String returnCode = ((JxBankEamsGatewayException) ex).getRecode();
			Object returnMsg = ((JxBankEamsGatewayException) ex).getRecode_info();
			String sign_data = ((JxBankEamsGatewayException) ex).getSign_data();

			logger.debug("错误代码：  " + returnCode + " 错误信息：" + returnMsg);

			dataMap.put("recode", returnCode);
			dataMap.put("recode_info", returnMsg);
			dataMap.put("sign_data", sign_data);
			
			this.msgToView(dataMap, response);

			return null;
			
		}else if (ex instanceof FinMallException) {
			
			String returnCode = ((FinMallException) ex).getReturnCode();
			Object returnMsg = ((FinMallException) ex).getReturnMsg();
			
			logger.debug("错误代码：  " + returnCode + " 错误信息：" + returnMsg);
			
			dataMap.put("returnCode", returnCode);
			dataMap.put("returnMsg", returnMsg);
			
			this.msgToView(dataMap, response);

			return null;
		} else {
			
			logger.debug("系统繁忙");
			dataMap.put("returnCode", ParamConstants.SYSTEM_ERROR_CODE);
			dataMap.put("returnMsg", ParamConstants.SYSTEM_ERROR_MSG);
			this.msgToView(dataMap, response);
			
			ex.printStackTrace();
			
			return null;
		}
	}

	public void msgToView(Map<String, Object> dataMap, HttpServletResponse response){
		try {
			PrintWriter writer = response.getWriter();
			String json = JSONObject.toJSON(dataMap).toString();
			logger.debug(json);
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.debug("系统繁忙");
		}
	}
	
}
