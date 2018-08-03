package com.ynet.finmall.gateway.yulebao.aop;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ynet.exception.ParamConstants;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.YLBGatewayException;
import com.ynet.finmall.gateway.yulebao.request.AbstractYLBRequest;
import com.ynet.finmall.gateway.yulebao.response.AbstractYLBResponse;

/**
 * 签名验证
 * 
 * @author liuxin
 *
 */
@Aspect
@Component
public class SignAspest {
	private static Logger log = LoggerFactory.getLogger(SignAspest.class);
	// 娱乐宝渠道编号
	@Value("${ylb.channel_no}")
	private String channel_no;

	// 娱乐宝应用编号
	@Value("${ylb.app_no}")
	private String app_no;

	@Pointcut("execution (* com.ynet.finmall.gateway.yulebao.controller.*.*(..))")
	public void declareJoinPointExpression() {
	}

	/**
	 * 环绕通知
	 * 
	 * @throws Throwable
	 */
	@Around(value = "declareJoinPointExpression()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		Object[] objects = pjp.getArgs();

		Object paramObj = objects[0];
		// 1.验签
		checkSign(JSONObject.toJSONString(paramObj));

		// 2. 渠道检查 //TODO 未来应该有统一的渠道认证 检查加密方式、是否具有访问该接口的权限等
		checkChannelAppNO(paramObj);

		// 3.controller 日志
		logMethodBefore(pjp, paramObj);
		// 4.执行业务方法
		Object retnObj = pjp.proceed();// 此处不能加 try catch
										// 否则在@ControllerAdvice不生效！！！

		// 5.方法返回报文
		log.info("finmall响应报文>>>>>>>>>>>>>" + JSON.toJSONString(retnObj));

		// 6.加签并返回
		String sign_data = YLBSignUtil.addSign(JSONObject.toJSONString(retnObj));

		if (retnObj instanceof AbstractYLBResponse) {
			AbstractYLBResponse res = (AbstractYLBResponse) retnObj;
			res.setSign_data(sign_data);
			res.setSign_type("MD5");
		}

		return retnObj;
	}

	/**
	 * 备注：获取channelNo和appNo
	 * 
	 * @author liaoyy@belink.com
	 * @param paramObj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private void checkChannelAppNO(Object paramObj) {
		String channelNo = "";
		String appNo = "";
		if (paramObj instanceof Map) {
			Map map = (Map) paramObj;
			channelNo = (String) map.get("channel_no") + "";
			appNo = (String) map.get("app_no") + "";
		} else if ((paramObj instanceof AbstractYLBRequest)) {
			AbstractYLBRequest req = (AbstractYLBRequest) paramObj;
			channelNo = req.getChannel_no();
			appNo = req.getApp_no();
		}else{
			log.error(">>>>>>>>>>>>>Controller的方法参数必须是Map或者是AbstractYLBRequest的实例的一种！");
			throw new YLBGatewayException(ParamConstants.SYSTEM_ERROR_CODE,ParamConstants.SYSTEM_ERROR_MSG);
		}
		validate(channelNo, appNo);
	}

	/**
	 * 备注：校验 channelNo和appNo
	 * 
	 * @author liaoyy@belink.com
	 * @param channelNo
	 * @param appNo
	 */
	private void validate(String channelNo, String appNo) {
		if (StringUtils.isBlank(channelNo)) {
			throw new YLBGatewayException(GatewayErrorConstants.YLB_CHANNEL_NO_NULL);
		}
		if (!channel_no.equals(channelNo)) {
			throw new YLBGatewayException(GatewayErrorConstants.YLB_CHANNEL_NO_ERROR);
		}
		if (StringUtils.isBlank(appNo)) {
			throw new YLBGatewayException(GatewayErrorConstants.YLB_APP_NO_NULL);
		}
		if (!app_no.equals(appNo)) {
			throw new YLBGatewayException(GatewayErrorConstants.YLB_APP_NO_ERROR);
		}
	}

	/**
	 * 备注：controller 进入之前，获取接口地址和名称
	 * 
	 * @author liaoyy@belink.com
	 * @param pjp
	 */
	private void logMethodBefore(ProceedingJoinPoint pjp, Object object) {

		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		PostMapping postMapping = methodSignature.getMethod().getAnnotation(PostMapping.class);

		if (null != postMapping) {
			// 接口名称
			log.info(postMapping.name() + ">>>>>>>>>>>>>" + Arrays.toString(postMapping.value()));
			log.info("请求参数>>>>>>>>>>>>>" + JSON.toJSONString(object));
		} else {
			log.error("请使用@PostMapping 作为请求转发...");
		}
	}

	/**
	 * 响应参数签名验证
	 */
	private static boolean checkSign(String resultString) {
		boolean checkSign = YLBSignUtil.checkSign(resultString, YLBSignUtil.MD5_KEY);
		if (!checkSign) {
			throw new YLBGatewayException(GatewayErrorConstants.YLB_CHECK_SIGN);
		}
		return checkSign;
	}

}
