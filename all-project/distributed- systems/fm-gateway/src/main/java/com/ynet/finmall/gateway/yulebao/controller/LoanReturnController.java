package com.ynet.finmall.gateway.yulebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanReturnQueryRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanReturnRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBRepaySearchSingleRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBRepaySingleRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanReturnQueryResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanReturnResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBRepaySearchSingleResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBRepaySingleResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbLoanReturnService;

/**
 * 贷款归还 相关
 * 
 * @author xuhui
 *
 */
@RestController
public class LoanReturnController {
	@Autowired(required = false)
	private YlbLoanReturnService ylbLoanReturnService;

	@PostMapping(name="调用娱乐宝贷款归还接口",value="api/ylb/loan/repayBatchYlb.do")
	public YLBLoanReturnResponse loanReturn(@RequestBody JSONObject jsonObj) {
		YLBLoanReturnRequest loanReturnRequest = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBLoanReturnRequest.class);
		YLBLoanReturnResponse loanReturn = ylbLoanReturnService.loanReturn(loanReturnRequest);
		return loanReturn;
	}

	@PostMapping(name="调用娱乐宝贷款归还查询接口",value="api/ylb/loan/batchInqRepayYlb.do")
	public YLBLoanReturnQueryResponse loanReturnQuery(@RequestBody JSONObject jsonObj) {
		YLBLoanReturnQueryRequest loanReturnRequest = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBLoanReturnQueryRequest.class);
		YLBLoanReturnQueryResponse loanReturnQuery = ylbLoanReturnService.loanReturnQuery(loanReturnRequest);
		return loanReturnQuery;
	}

	@PostMapping(name="调用娱乐宝贷款归还（单笔实时）接口",value="api/ylb/loan/repaySingle.do")
	public YLBRepaySingleResponse repaySingle(@RequestBody JSONObject jsonObj) {
		YLBRepaySingleRequest loanReturnRequest = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBRepaySingleRequest.class);
		YLBRepaySingleResponse repaySingle = ylbLoanReturnService.repaySingle(loanReturnRequest);
		return repaySingle;
	}

	@PostMapping(name="调用娱乐宝贷款归还结果查询（单笔）接口",value="api/ylb/loan/repaySearchSingle.do")
	public YLBRepaySearchSingleResponse repaySearchSingle(@RequestBody JSONObject jsonObj) {
		YLBRepaySearchSingleRequest searchSingleRequest = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBRepaySearchSingleRequest.class);
		YLBRepaySearchSingleResponse repaySearchSingle = ylbLoanReturnService.repaySearchSingle(searchSingleRequest);
		return repaySearchSingle;
	}

}