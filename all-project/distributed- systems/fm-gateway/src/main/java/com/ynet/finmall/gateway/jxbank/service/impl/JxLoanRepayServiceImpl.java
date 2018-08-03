package com.ynet.finmall.gateway.jxbank.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.JxBankLoanGatewayException;
import com.ynet.finmall.gateway.jxbank.client.request.JxRepayBatchNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxRepayBatchNoticeResponse;
import com.ynet.finmall.gateway.jxbank.service.JxLoanRepayService;
import com.ynet.finmall.gateway.yulebao.client.request.YlbRepayBatchNoticeEventRequest;
import com.ynet.finmall.gateway.yulebao.client.response.YlbRepayBatchNoticeEventResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbGateway;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmLoanAndUploadService;

/**
 * 嘉兴银行贷款归还相关的业务实现
 * @author qiangjiyi
 * @date 2018年1月9日 下午5:35:00
 */
@Service
public class JxLoanRepayServiceImpl implements JxLoanRepayService {
	
	private static Logger logger = LoggerFactory.getLogger(JxLoanRepayServiceImpl.class);
	
	@Autowired
	private YlbGateway ylbGateway;
	
	@Autowired(required = false)
	private ScmLoanAndUploadService scmLoanAndUploadService;
	
	@Override
	public JxRepayBatchNoticeResponse repay_batch_ylb_notice(JxRepayBatchNoticeRequest request) {
		String receiveUrl = null;
		try {
			// 1.向供应链模块发起查询娱乐宝贷款归还异步通知回调地址
			receiveUrl = scmLoanAndUploadService.queryRepayCallbackUrl(request.getPro_id(), request.getBatch_serial_no());
			logger.info("调用供应链模块查询到的娱乐宝贷款归还异步通知回调地址为：" + receiveUrl);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("调用供应链模块出现异常");
			throw new JxBankLoanGatewayException(GatewayErrorConstants.JX_REQ_RECEIVE_URL_ERROR);
		}
		
		// 2.将贷款归还批量通知请求参数嘉兴银行方转换为娱乐宝方
		YlbRepayBatchNoticeEventRequest ylb_request = new YlbRepayBatchNoticeEventRequest();
		CopyUtils.Copy(request, ylb_request);
		
		// 3.调用娱乐宝批量查询贷款归还结果
		YlbRepayBatchNoticeEventResponse ylb_response = ylbGateway.repay_batch_ylb_notice(receiveUrl, ylb_request);
		logger.info("调用娱乐宝批量查询贷款归还结果为：" + JSON.toJSONString(ylb_response));
		
		// 4.将贷款归还批量通知响应参数娱乐宝方转换为嘉兴银行方
		JxRepayBatchNoticeResponse response = new JxRepayBatchNoticeResponse();
		CopyUtils.Copy(ylb_response, response);
		
		// 5.返回
		return response;
	}

}
