package com.ynet.finmall.gateway.yulebao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.response.ApplyYlbCallBack;
import com.ynet.finmall.gateway.yulebao.YLBHttpGateway;
import com.ynet.finmall.gateway.yulebao.client.request.ApplyYlbCallBackEventRequest;
import com.ynet.finmall.gateway.yulebao.client.request.YlbRepayBatchNoticeEventRequest;
import com.ynet.finmall.gateway.yulebao.client.request.YlbWithdrawExceptionNoticeRequest;
import com.ynet.finmall.gateway.yulebao.client.response.ApplyYlbCallBackEvnetResponse;
import com.ynet.finmall.gateway.yulebao.client.response.YlbRepayBatchNoticeEventResponse;
import com.ynet.finmall.gateway.yulebao.client.response.YlbWithdrawExceptionNoticeResponse;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanGrantNoticeRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrantNoticeResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbGateway;

/**
 * 娱乐宝网关业务接口实现
 * @author qiangjiyi
 * @date 2018年1月12日 下午3:18:45
 */
@Service
public class YlbGatewayImpl implements YlbGateway {

	private static Logger logger = LoggerFactory.getLogger(YlbGatewayImpl.class);

	/**
	 * 是开启挡板
	 */
	@Value("${gateway.ylb.virtual:false}")
	private String virtual;
	
//	@Override
//	public TradeDetailsQueryTradeListResponse tradeDetailsQueryTradeList(TradeDetailsQueryTradeListRequest request) {
//		// 1.向嘉兴银行发起查询交易明细
//		TradeDetailsQueryTradeListResponse response = jxbankGateway.tradeDetails_queryTradeList(request);
//
//		return response;
//	}
	
	/**
	 * 贷款异步通知娱乐宝接口
	 */
	@Override
	public ApplyYlbCallBackEvnetResponse applyYlbCallBack(String url, ApplyYlbCallBackEventRequest request) {

		logger.info("贷款申请回调地址>>>>>>>>>>>" + url);
		if("true".equalsIgnoreCase(virtual)) {// 挡板
			ApplyYlbCallBackEvnetResponse response = new ApplyYlbCallBackEvnetResponse();
			response.setReturnCode("000000");
			response.setReturnMsg("成功");

			ApplyYlbCallBack applyYlbCallBack = new ApplyYlbCallBack();
			applyYlbCallBack.setApply_id(request.getApply_id());
			response.setData(applyYlbCallBack);
			return response;
		}
		//回调娱乐宝接口
		String result = YLBHttpGateway.doPostObj(url, JSONObject.toJSONString(request));
		
		ApplyYlbCallBackEvnetResponse response = JSONObject.parseObject(result, ApplyYlbCallBackEvnetResponse.class);
		
		return response;
	}
	
	/**
	 * 贷款发放回调接口
	 * @author xuhui
	 */
	@Override
	public YLBLoanGrantNoticeResponse loanGrantNotice(String url,
			YLBLoanGrantNoticeRequest loanGrantNoticeRequest) {
		logger.info("调用供应链模块查询到的娱乐宝贷款发放异步通知回调地址为：" + url);
		if("true".equalsIgnoreCase(virtual)) {// 挡板
			YLBLoanGrantNoticeResponse response = new YLBLoanGrantNoticeResponse();
			response.setReturnCode("000000");
			response.setReturnMsg("成功");
			response.setApply_id(loanGrantNoticeRequest.getApply_id());
			response.setReceipt_id(loanGrantNoticeRequest.getReceipt_id());
			response.setSign_data("rw324323");
			response.setSign_type("MD5");
			return response;
		}
		//回调娱乐宝接口
		String result = YLBHttpGateway.doPostObj(url, JSONObject.toJSONString(loanGrantNoticeRequest));
		
		YLBLoanGrantNoticeResponse response = JSONObject.parseObject(result, YLBLoanGrantNoticeResponse.class);
		
		return response;
	}

	@Override
	public YlbRepayBatchNoticeEventResponse repay_batch_ylb_notice(String receiveUrl, YlbRepayBatchNoticeEventRequest request) {
		if("true".equalsIgnoreCase(virtual)) {// 挡板
			YlbRepayBatchNoticeEventResponse response = new YlbRepayBatchNoticeEventResponse();
			return response;
		}
		// 向娱乐宝给出的贷款归还异步通知（批量）接口发起请求
		String resp = YLBHttpGateway.doPostObj(receiveUrl, request);
		
		YlbRepayBatchNoticeEventResponse response = JSONObject.parseObject(resp, YlbRepayBatchNoticeEventResponse.class);
		
		return response;
	}

	@Override
	public YlbWithdrawExceptionNoticeResponse withdraw_exception_ylb_notice(String url,
			YlbWithdrawExceptionNoticeRequest request) {
		if("true".equalsIgnoreCase(virtual)) {
			YlbWithdrawExceptionNoticeResponse response = new YlbWithdrawExceptionNoticeResponse();
			return response;
		}
		
		// 向娱乐宝给出的取现异常异步通知接口发起请求
		String resp = YLBHttpGateway.doPostObj(url, request);
		
		YlbWithdrawExceptionNoticeResponse response = JSONObject.parseObject(resp, YlbWithdrawExceptionNoticeResponse.class);
		return response;
	}

}
