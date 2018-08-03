package com.ynet.finmall.gateway.jxbank.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.JxBankEamsGatewayException;
import com.ynet.finmall.gateway.jxbank.request.JxWithdrawExceptionNoticeRequest;
import com.ynet.finmall.gateway.jxbank.response.JxWithdrawExceptionNoticeResponse;
import com.ynet.finmall.gateway.jxbank.service.JxMerWithdrawService;
import com.ynet.finmall.gateway.yulebao.client.request.YlbWithdrawExceptionNoticeRequest;
import com.ynet.finmall.gateway.yulebao.client.response.YlbWithdrawExceptionNoticeResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbGateway;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmAccountInfoService;

/**
 * 商户取现业务接口实现
 * @author qiangjiyi
 * @date 2018年1月25日 下午3:03:35
 */
@Service
public class JxMerWithdrawServiceImpl implements JxMerWithdrawService {

	private static Logger logger = LoggerFactory.getLogger(JxMerWithdrawServiceImpl.class);
	
	@Autowired
	private YlbGateway ylbGateway;
	
	@Autowired
	private ScmAccountInfoService scmAccountInfoService;
	
	/* (non-Javadoc)
	 * @see com.ynet.finmall.gateway.jxbank.service.JxMerWithdrawService#withdraw_exception_ylb_notice(com.ynet.finmall.gateway.jxbank.request.JxWithdrawExceptionNoticeRequest)
	 */
	@Override
	public JxWithdrawExceptionNoticeResponse withdraw_exception_ylb_notice(JxWithdrawExceptionNoticeRequest request) {
		// 1.将商户取现异常回调通知请求参数嘉兴银行方转换为娱乐宝方
		YlbWithdrawExceptionNoticeRequest ylb_request = new YlbWithdrawExceptionNoticeRequest();
		CopyUtils.Copy(request, ylb_request);
		
		// 2.根据原交易流水号和原交易码查询娱乐宝商户取现回调地址
		String receive_url = null;
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("serialNo", request.getOriginal_serialno());
			param.put("tradeNo", request.getOriginal_tradeno());
			receive_url = scmAccountInfoService.queryYlbReceiveUrl(JSON.toJSONString(param));
		} catch (Exception e) {
			logger.error("嘉兴银行请求回调URL异常");
			throw new JxBankEamsGatewayException(GatewayErrorConstants.JX_REQ_RECEIVE_URL_ERROR);
		}
		
		if(StringUtils.isNotBlank(receive_url)) {
			// 3.调用娱乐宝商户取现回调通知
			YlbWithdrawExceptionNoticeResponse ylb_response = ylbGateway.withdraw_exception_ylb_notice(receive_url, ylb_request);
			logger.info("调用娱乐宝商户取现异常回调通知结果为：" + JSON.toJSONString(ylb_response));
			
			// 4.将商户取现异常回调通知响应参数娱乐宝方转换为嘉兴银行方
			JxWithdrawExceptionNoticeResponse response = new JxWithdrawExceptionNoticeResponse();
			CopyUtils.Copy(ylb_response, response);
			response.setRecode(ylb_response.getReturnCode());
			response.setRecode_info(ylb_response.getReturnMsg());
			
			// 5.返回
			return response;
		}
		
		logger.error("娱乐宝商户取现回调URL为空");
		throw new JxBankEamsGatewayException(GatewayErrorConstants.YLB_RECEIVE_URL_NULL);
	}
	
}
