package com.ynet.finmall.gateway.yulebao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.request.JxLoanReturnQueryRequest;
import com.ynet.finmall.gateway.jxbank.request.JxLoanReturnRequest;
import com.ynet.finmall.gateway.jxbank.request.JxRepaySearchSingleRequest;
import com.ynet.finmall.gateway.jxbank.request.JxRepaySingleRequest;
import com.ynet.finmall.gateway.jxbank.response.JxLoanReturnQueryResponse;
import com.ynet.finmall.gateway.jxbank.response.JxLoanReturnResponse;
import com.ynet.finmall.gateway.jxbank.response.JxRepaySearchSingleResponse;
import com.ynet.finmall.gateway.jxbank.response.JxRepaySingleResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanReturnQueryRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanReturnRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBRepaySearchSingleRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBRepaySingleRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanReturnQueryResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanReturnResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBRepaySearchSingleResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBRepaySingleResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbLoanReturnService;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmLoanAndUploadService;

@Service
public class YlbLoanReturnServiceImpl implements YlbLoanReturnService {
	private static Logger logger = LoggerFactory.getLogger(YlbUploadFileServiceImpl.class);

	@Autowired(required = false)
	private ScmLoanAndUploadService scmLoanAndUploadService;

	@Autowired
	private JxbankGateway jxbankGateway;

	// 贷款归还回调地址
	@Value("${gateway.jxbank.loan.return.url}")
	private String loanReturnUrl;

	@Override
	public YLBLoanReturnResponse loanReturn(YLBLoanReturnRequest loanReturnRequest) {
		JxLoanReturnRequest jxLoanReturnRequest = new JxLoanReturnRequest();

		CopyUtils.Copy(loanReturnRequest, jxLoanReturnRequest);
		jxLoanReturnRequest.setReceive_url(loanReturnUrl);
		JxLoanReturnResponse jxLoanReturnResponse = jxbankGateway.loanReturn(jxLoanReturnRequest);
		YLBLoanReturnResponse loanReturnResponse = new YLBLoanReturnResponse();
		CopyUtils.Copy(jxLoanReturnResponse, loanReturnResponse);

		if (null!=jxLoanReturnResponse && "000000".equals(jxLoanReturnResponse.getCode())) {
			logger.info("调用贷款归还成功>>>>>>>>");
			try {
				scmLoanAndUploadService.scmLoanReturn(JSONObject.toJSONString(loanReturnRequest));
			} catch (Exception e) {
				logger.error("--->>>"+e);
			}
		}

		loanReturnResponse.setReturnCode(jxLoanReturnResponse.getCode());
		loanReturnResponse.setReturnMsg(jxLoanReturnResponse.getMsg());
		return loanReturnResponse;
	}

	@Override
	public YLBLoanReturnQueryResponse loanReturnQuery(YLBLoanReturnQueryRequest ylbLoanReturnQueryRequest) {
		JxLoanReturnQueryRequest jxLoanReturnQueryRequest = new JxLoanReturnQueryRequest();
		YLBLoanReturnQueryResponse loanReturnQueryResponse = new YLBLoanReturnQueryResponse();
		CopyUtils.Copy(ylbLoanReturnQueryRequest, jxLoanReturnQueryRequest);
		logger.info("娱乐宝调用贷款归还批量查询接口>>>>>>>>>>>");
		JxLoanReturnQueryResponse jxLoanReturnQueryResponse = jxbankGateway.loanReturnQuery(jxLoanReturnQueryRequest);

		CopyUtils.Copy(jxLoanReturnQueryResponse, loanReturnQueryResponse);

		loanReturnQueryResponse.setReturnCode(jxLoanReturnQueryResponse.getCode());
		loanReturnQueryResponse.setReturnMsg(jxLoanReturnQueryResponse.getMsg());
		loanReturnQueryResponse.setSign_data(jxLoanReturnQueryResponse.getSign());
		loanReturnQueryResponse.setSign_type(jxLoanReturnQueryResponse.getSign_type());
		
		return loanReturnQueryResponse;
	}

	@Override
	public YLBRepaySingleResponse repaySingle(YLBRepaySingleRequest repaySingleRequest) {
		 
		JxRepaySingleRequest jxLoanReturnQueryRequest = new JxRepaySingleRequest();
		YLBRepaySingleResponse repaySingleResponse = new YLBRepaySingleResponse();
		CopyUtils.Copy(repaySingleRequest, jxLoanReturnQueryRequest);
		logger.info("调用娱乐宝贷款归还（单笔实时）接口>>>>>>>>>");
		JxRepaySingleResponse jxLoanReturnQueryResponse = jxbankGateway.repaySingle(jxLoanReturnQueryRequest);

		CopyUtils.Copy(jxLoanReturnQueryResponse, repaySingleResponse);

		repaySingleResponse.setReturnCode(jxLoanReturnQueryResponse.getCode());
		repaySingleResponse.setReturnMsg(jxLoanReturnQueryResponse.getMsg());
		repaySingleResponse.setSign_data(jxLoanReturnQueryResponse.getSign());
		repaySingleResponse.setSign_type(jxLoanReturnQueryResponse.getSign_type());
		
		return repaySingleResponse;
	}

	@Override
	public YLBRepaySearchSingleResponse repaySearchSingle(YLBRepaySearchSingleRequest repaySearchSingleRequest) {
		JxRepaySearchSingleRequest jxRepaySearchSingleRequest = new JxRepaySearchSingleRequest();
		YLBRepaySearchSingleResponse repaySingleResponse = new YLBRepaySearchSingleResponse();
		CopyUtils.Copy(repaySearchSingleRequest, jxRepaySearchSingleRequest);
		logger.info("调用娱乐宝贷款归还结果查询（单笔）接口>>>>>>>>>");
		JxRepaySearchSingleResponse jxRepaySearchSingleResponse = jxbankGateway.repaySearchSingle(jxRepaySearchSingleRequest);

		CopyUtils.Copy(jxRepaySearchSingleResponse, repaySingleResponse);

		repaySingleResponse.setReturnCode(jxRepaySearchSingleResponse.getCode());
		repaySingleResponse.setReturnMsg(jxRepaySearchSingleResponse.getMsg());
		repaySingleResponse.setSign_data(jxRepaySearchSingleResponse.getSign());
		repaySingleResponse.setSign_type(jxRepaySearchSingleResponse.getSign_type());
		
		return repaySingleResponse;
	}

}
