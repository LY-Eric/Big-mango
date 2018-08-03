package com.ynet.finmall.gateway.jxbank.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.client.request.JxLoanGrantNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxLoanGrantNoticeResponse;
import com.ynet.finmall.gateway.jxbank.controller.ApplyYlbCallBackController;
import com.ynet.finmall.gateway.jxbank.service.JxLoanGrantNoticeService;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanGrantNoticeRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrantNoticeResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbGateway;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmLoanAndUploadService;

/**
 * 贷款发放回调接口
 * 
 * @author xuhui
 *
 */

@Service
public class JxLoanGrantNoticeServiceImpl implements JxLoanGrantNoticeService {

	private static final Logger logger = LoggerFactory.getLogger(ApplyYlbCallBackController.class);

	@Autowired
	private YlbGateway ylbGateway;

	@Autowired(required = false)
	private ScmLoanAndUploadService scmLoanAndUploadService;

	@Override
	public JxLoanGrantNoticeResponse loanGrantNotice(JxLoanGrantNoticeRequest JxLoanGrantNoticeRequest) {
		logger.info("贷款发放异步通知接口>>>>>>>>>");
		YLBLoanGrantNoticeRequest loanGrantNoticeRequest = new YLBLoanGrantNoticeRequest();
		YLBLoanGrantNoticeResponse loanGrantNoticeResponse = new YLBLoanGrantNoticeResponse();
		JxLoanGrantNoticeResponse jxLoanGrantNoticeResponse = new JxLoanGrantNoticeResponse();
		// 贷款发放异步通知存库
		String applyId = JxLoanGrantNoticeRequest.getApply_id();
		String receiptId = JxLoanGrantNoticeRequest.getReceipt_id();
		Integer grantStatus = JxLoanGrantNoticeRequest.getGrant_status();
		String grantNote = JxLoanGrantNoticeRequest.getGrant_note();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applyId", applyId);
		jsonObject.put("receiptId", receiptId);
		jsonObject.put("grantStatus", grantStatus);
		jsonObject.put("grantNote", grantNote);
		scmLoanAndUploadService.scmLoanGrantNotice(JSONObject.toJSONString(jsonObject));
		// 调用娱乐宝贷款发放异步通知接口
		CopyUtils.Copy(JxLoanGrantNoticeRequest, loanGrantNoticeRequest);
		String jsonStr = scmLoanAndUploadService.queryReceiveUrl(JxLoanGrantNoticeRequest.getApply_id());
		JSONObject jsonObject1 = JSONObject.parseObject(jsonStr);
		String loanReceiveUrl = jsonObject1.getString("loanReceiveUrl");

		loanGrantNoticeResponse = ylbGateway.loanGrantNotice(loanReceiveUrl, loanGrantNoticeRequest);

		CopyUtils.Copy(loanGrantNoticeResponse, jxLoanGrantNoticeResponse);
		jxLoanGrantNoticeResponse.setCode(loanGrantNoticeResponse.getReturnCode());
		jxLoanGrantNoticeResponse.setMsg(loanGrantNoticeResponse.getReturnMsg());
		jxLoanGrantNoticeResponse.setSign(loanGrantNoticeResponse.getSign_data());
		return jxLoanGrantNoticeResponse;

	}

}
