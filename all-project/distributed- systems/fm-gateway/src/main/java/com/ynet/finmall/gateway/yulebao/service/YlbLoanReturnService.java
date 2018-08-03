package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.request.YLBLoanReturnQueryRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanReturnRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBRepaySearchSingleRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBRepaySingleRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanReturnQueryResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanReturnResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBRepaySearchSingleResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBRepaySingleResponse;

public interface YlbLoanReturnService {
	/**
	 * 贷款归还接口
	 */
	YLBLoanReturnResponse loanReturn(YLBLoanReturnRequest loanReturnRequest);

	/**
	 * 备注：贷款归还批量查询接口
	 * @author liaoyy@belink.com
	 * @param ylbLoanReturnQueryRequest
	 * @return
	 */
	YLBLoanReturnQueryResponse loanReturnQuery(YLBLoanReturnQueryRequest ylbLoanReturnQueryRequest);
	
	/**
	 * 备注：贷款归还（单笔实时）
	 * @author liaoyy@belink.com
	 * @param repaySingleRequest
	 * @return
	 */
	YLBRepaySingleResponse repaySingle(YLBRepaySingleRequest repaySingleRequest);
	
	/**
	 * 备注：贷款归还结果查询（单笔）
	 * @author liaoyy@belink.com
	 * @param repaySearchSingleRequest
	 * @return
	 */
	YLBRepaySearchSingleResponse repaySearchSingle(YLBRepaySearchSingleRequest repaySearchSingleRequest);
	
}
