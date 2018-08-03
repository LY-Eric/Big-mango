package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.client.request.ApplyYlbCallBackEventRequest;
import com.ynet.finmall.gateway.yulebao.client.request.YlbRepayBatchNoticeEventRequest;
import com.ynet.finmall.gateway.yulebao.client.request.YlbWithdrawExceptionNoticeRequest;
import com.ynet.finmall.gateway.yulebao.client.response.ApplyYlbCallBackEvnetResponse;
import com.ynet.finmall.gateway.yulebao.client.response.YlbRepayBatchNoticeEventResponse;
import com.ynet.finmall.gateway.yulebao.client.response.YlbWithdrawExceptionNoticeResponse;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanGrantNoticeRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrantNoticeResponse;


/**
 * 娱乐宝网关通讯接口
 * @author qiangjiyi
 * @date 2018年1月12日 下午3:15:15
 */
public interface YlbGateway {

	/**
	 * 查询账户交易明细
	 */
//	TradeDetailsQueryTradeListResponse tradeDetailsQueryTradeList(TradeDetailsQueryTradeListRequest request);
	
	/**
	 * 贷款申请异步通知娱乐宝
	 */
	ApplyYlbCallBackEvnetResponse applyYlbCallBack(String url, ApplyYlbCallBackEventRequest request);
	
	/**
	 * 贷款发放异步通知娱乐宝
	 */
	YLBLoanGrantNoticeResponse loanGrantNotice(String url,YLBLoanGrantNoticeRequest loanGrantNoticeRequest);
	
	/**
	 * 贷款归还异步通知（批量）接口
	 */
	YlbRepayBatchNoticeEventResponse repay_batch_ylb_notice(String receiveUrl, YlbRepayBatchNoticeEventRequest request);
	
	/**
	 * 商户取现异常异步通知
	 */
	YlbWithdrawExceptionNoticeResponse withdraw_exception_ylb_notice(String url, YlbWithdrawExceptionNoticeRequest request);
}