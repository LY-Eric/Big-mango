package com.ynet.finmall.gateway.jxbank.service;

import com.ynet.finmall.gateway.jxbank.client.request.JxRepayBatchNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxRepayBatchNoticeResponse;

/**
 * 贷款归还业务接口
 * @author qiangjiyi
 * @date 2018年1月9日 下午4:52:27
 */
public interface JxLoanRepayService {
	/**
	 * 贷款归还异步通知（批量）接口
	 */
	JxRepayBatchNoticeResponse repay_batch_ylb_notice(JxRepayBatchNoticeRequest request);
	
}
