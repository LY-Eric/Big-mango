package com.ynet.finmall.gateway.jxbank.service;

import com.ynet.finmall.gateway.jxbank.client.request.JxLoanGrantNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxLoanGrantNoticeResponse;

/**
 * jx贷款发放回调通知
 * @author xuhui
 *
 */
public interface JxLoanGrantNoticeService {

	JxLoanGrantNoticeResponse loanGrantNotice(JxLoanGrantNoticeRequest JxLoanGrantNoticeRequest);
}
