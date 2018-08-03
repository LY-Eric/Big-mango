package com.ynet.finmall.gateway.yulebao.service.impl;

import com.alibaba.fastjson.JSON;
import com.ynet.finmall.gateway.jxbank.request.JxInqGrantRequest;
import com.ynet.finmall.gateway.jxbank.request.JxLoanGrantRequest;
import com.ynet.finmall.gateway.jxbank.response.JxInqGrantResponse;
import com.ynet.finmall.gateway.jxbank.response.JxLoanGrantResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.yulebao.request.YLBInqGrantRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanGrantRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBInqGrantResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrantResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbLoanGrantService;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmLoanAndUploadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YlbLoanGrantServiceImpl implements YlbLoanGrantService {
	private static Logger logger = LoggerFactory.getLogger(YlbLoanGrantServiceImpl.class);
	@Autowired(required = false)
	private ScmLoanAndUploadService scmLoanAndUploadService;

	@Autowired
	private JxbankGateway jxbankGateway;

	private final String SUCCESS = "000000";

	/**
	 * @Description 贷款发放
	 * @Author 刘俊重 补充徐慧代码
	 * @Date 2018/3/27
	 */
	@Override
	public YLBLoanGrantResponse loanGrant(YLBLoanGrantRequest request) {
		JxLoanGrantRequest jxLoanGrantRequest = new JxLoanGrantRequest();
		CopyUtils.Copy(request, jxLoanGrantRequest);

		JxLoanGrantResponse jxLoanGrantResponse = jxbankGateway.loanGrant(jxLoanGrantRequest);
		YLBLoanGrantResponse ylbLoanGrantResponse = new YLBLoanGrantResponse();
		CopyUtils.Copy(jxLoanGrantResponse, ylbLoanGrantResponse);
      
		try {
			if (null!=jxLoanGrantResponse && SUCCESS.equals(jxLoanGrantResponse.getCode()) && null!=jxLoanGrantResponse.getData()) {
				request.setReceipt_id(jxLoanGrantResponse.getData().getReceipt_id());
				request.setGrant_status(jxLoanGrantResponse.getData().getGrant_status());
				request.setGrant_note(jxLoanGrantResponse.getData().getGrant_note());
				request.setSerial_no(jxLoanGrantResponse.getData().getSerial_no());
				scmLoanAndUploadService.scmLoanGrant(JSON.toJSONString(request));
			}
		} catch (Exception e) {
			logger.error("--->>>"+e);
		}
		ylbLoanGrantResponse.setReturnCode(jxLoanGrantResponse.getCode());
		ylbLoanGrantResponse.setReturnMsg(jxLoanGrantResponse.getMsg());
		return ylbLoanGrantResponse;
	}

	@Override
	public YLBInqGrantResponse inqGrant(YLBInqGrantRequest inqGrantRequest) {
		JxInqGrantRequest jxInqGrantRequest = new JxInqGrantRequest();

		jxInqGrantRequest.setApply_id(inqGrantRequest.getApply_id());
		jxInqGrantRequest.setComerchant_receipt_no(inqGrantRequest.getComerchant_receipt_no());
		jxInqGrantRequest.setPro_id(inqGrantRequest.getPro_id());

		JxInqGrantResponse infoGrant = jxbankGateway.inqGrant(jxInqGrantRequest);

		YLBInqGrantResponse ylbInqGrantResponse = new YLBInqGrantResponse();
		if (SUCCESS.equals(infoGrant.getCode())) {
			ylbInqGrantResponse.setData(infoGrant.getData());
		} else {
			ylbInqGrantResponse.setReturnCode(infoGrant.getCode());
			ylbInqGrantResponse.setReturnMsg(infoGrant.getMsg());
		}
		return ylbInqGrantResponse;
	}
}
