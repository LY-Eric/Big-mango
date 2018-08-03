package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.request.YLBInqGrantRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanGrantRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBInqGrantResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrantResponse;

public interface YlbLoanGrantService {
	/**
	 * 贷款发放接口
	 */
	YLBLoanGrantResponse loanGrant(YLBLoanGrantRequest loanGrantRequest);
	
	/**
	 * 备注：贷款放款查询
	 * @author liaoyy@belink.com
	 * @param inqGrantRequest
	 * @return
	 */
	YLBInqGrantResponse inqGrant(YLBInqGrantRequest inqGrantRequest);
}
