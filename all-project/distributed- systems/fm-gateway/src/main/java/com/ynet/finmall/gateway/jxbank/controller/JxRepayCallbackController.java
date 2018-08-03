package com.ynet.finmall.gateway.jxbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.client.request.JxRepayBatchNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxRepayBatchNoticeResponse;
import com.ynet.finmall.gateway.jxbank.service.JxLoanRepayService;

/**
 * 贷款归还回调异步通知(批量)
 * @author qiangjiyi
 * @date 2018年1月5日 下午2:28:25
 */
@Controller
public class JxRepayCallbackController {
	
	private static Logger logger = LoggerFactory.getLogger(JxRepayCallbackController.class);
	
	@Autowired
	private JxLoanRepayService jxLoanRepayService;
	
	/**
	 * 贷款归还异步通知(批量)
	 */
	@RequestMapping("/api/jxbank/v1/loan/repay_batch_ylb_notice.do")
	@ResponseBody
	public JxRepayBatchNoticeResponse repayBatchYlbNotice(@RequestBody JSONObject jsonObj){
		
		JxRepayBatchNoticeRequest request = JSONObject.parseObject(jsonObj.toJSONString(), JxRepayBatchNoticeRequest.class);

		logger.info("请求参数：" + JSON.toJSONString(request));
		
		// 调用service服务
		JxRepayBatchNoticeResponse response = jxLoanRepayService.repay_batch_ylb_notice(request);
		logger.info("响应结果：" + JSON.toJSONString(response));
		return response;
	}
}
