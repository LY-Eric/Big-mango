package com.ynet.finmall.gateway.jxbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.client.request.JxLoanGrantNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxLoanGrantNoticeResponse;
import com.ynet.finmall.gateway.jxbank.service.JxLoanGrantNoticeService;

/**
 * 贷款发放异步通知接口
 * 
 * @author xuhui
 *
 */
@Controller
@ResponseBody
public class JxLoanGrantNoticeController {

	private static Logger logger = LoggerFactory.getLogger(JxLoanGrantNoticeController.class);

	@Autowired(required = false)
	private JxLoanGrantNoticeService jxLoanGrantNoticeService;

	@RequestMapping("api/jxbank/loanGrant/notice.do")
	public JxLoanGrantNoticeResponse loanGrantNotice(@RequestBody JSONObject jsonObj) {
		
		logger.info("嘉兴银行回调贷款发放异步通知接口>>>>>>>>>>");
		JxLoanGrantNoticeRequest JxLoanGrantNoticeRequest = JSONObject.parseObject(jsonObj.toJSONString(), JxLoanGrantNoticeRequest.class);
		return jxLoanGrantNoticeService.loanGrantNotice(JxLoanGrantNoticeRequest);
	}
}