package com.ynet.finmall.gateway.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 网关异常统一处理
 * @author liuxin
 *
 */
@ControllerAdvice
public class GatewayExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(GatewayExceptionHandler.class);
    
	/**
	 * 访问娱乐宝异常处理
	 */
	@ExceptionHandler(YLBGatewayException.class)
	@ResponseBody
	public Map<String, Object> handleBizExp(HttpServletRequest request, Exception ex) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		String returnCode = ((YLBGatewayException) ex).getReturnCode();
		Object returnMsg = ((YLBGatewayException) ex).getReturnMsg();
		String sign_data = ((YLBGatewayException) ex).getSign_data();// C500 签名串
		String sign_type = ((YLBGatewayException) ex).getSign_type();// 签名方式

		logger.debug("错误代码：  " + returnCode + " 错误信息：" + returnMsg);

		dataMap.put("returnCode", returnCode);
		dataMap.put("returnMsg", returnMsg);
		dataMap.put("sign_data", sign_data);
		dataMap.put("sign_type", sign_type);

		return dataMap;
	}

}
