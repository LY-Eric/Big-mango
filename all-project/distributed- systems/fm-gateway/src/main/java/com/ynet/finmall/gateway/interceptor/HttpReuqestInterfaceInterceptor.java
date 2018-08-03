package com.ynet.finmall.gateway.interceptor;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HttpReuqestInterfaceInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory.getLogger(HttpReuqestInterfaceInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Long _startTime = System.currentTimeMillis();
		request.setAttribute("_startTime", _startTime);  

		logger.debug("请求链接:" + request.getRequestURI() + " 请求时间:" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").format(new Date()));
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Long _startTime = (Long)request.getAttribute("_startTime");
		Long _endTime = System.currentTimeMillis();
		Long _executeTime = _endTime - _startTime;

		logger.debug("请求链接:" + request.getRequestURI() + " 响应时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").format(new Date(_endTime))+ " 耗时: " + _executeTime + " 毫秒");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
