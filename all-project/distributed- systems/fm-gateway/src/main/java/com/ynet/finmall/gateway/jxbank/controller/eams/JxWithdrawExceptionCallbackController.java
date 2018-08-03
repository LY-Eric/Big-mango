package com.ynet.finmall.gateway.jxbank.controller.eams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.request.JxWithdrawExceptionNoticeRequest;
import com.ynet.finmall.gateway.jxbank.response.JxWithdrawExceptionNoticeResponse;
import com.ynet.finmall.gateway.jxbank.service.JxMerWithdrawService;

/**
 * 商户取现请求出现异常后的回调通知
 * @author qiangjiyi
 * @date 2018年1月25日 下午2:28:10
 */
@Controller
public class JxWithdrawExceptionCallbackController {

	private static Logger logger = LoggerFactory.getLogger(JxWithdrawExceptionCallbackController.class);
	
	@Autowired
	private JxMerWithdrawService jxMerWithdrawService;
	
	/**
	 * 商户取现异常回调通知
	 */
	@RequestMapping("/api/jxbank/withdraw_exception_ylb_notice.do")
	@ResponseBody
	public JxWithdrawExceptionNoticeResponse withdrawExceptionYlbNotice(@RequestBody JSONObject jsonObj) {
		JxWithdrawExceptionNoticeRequest request = JSONObject.parseObject(jsonObj.toJSONString(), JxWithdrawExceptionNoticeRequest.class);
		
		logger.info("请求参数：" + JSON.toJSONString(request));
		
		// 调用service服务
		JxWithdrawExceptionNoticeResponse response = jxMerWithdrawService.withdraw_exception_ylb_notice(request);
		logger.info("响应结果：" + JSON.toJSONString(response));
		return response;
	}
}
