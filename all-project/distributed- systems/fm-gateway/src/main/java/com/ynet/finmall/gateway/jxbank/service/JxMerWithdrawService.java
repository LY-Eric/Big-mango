package com.ynet.finmall.gateway.jxbank.service;

import com.ynet.finmall.gateway.jxbank.request.JxWithdrawExceptionNoticeRequest;
import com.ynet.finmall.gateway.jxbank.response.JxWithdrawExceptionNoticeResponse;

/**
 * 商户取现业务接口
 * @author qiangjiyi
 * @date 2018年1月25日 下午3:03:07
 */
public interface JxMerWithdrawService {
	
	/**
	 * 商户取现异常回调通知
	 */
	JxWithdrawExceptionNoticeResponse withdraw_exception_ylb_notice(JxWithdrawExceptionNoticeRequest request);
}
