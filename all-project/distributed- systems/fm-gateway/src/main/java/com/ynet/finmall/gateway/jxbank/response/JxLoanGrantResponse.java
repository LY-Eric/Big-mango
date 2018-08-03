package com.ynet.finmall.gateway.jxbank.response;

import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrant;

/**
 * 贷款发放返回参数
 * 
 * @author xuhui
 *
 */
public class JxLoanGrantResponse extends AbstractJxBankLoanResponse {
	private YLBLoanGrant data;

	public YLBLoanGrant getData() {
		return data;
	}

	public void setData(YLBLoanGrant data) {
		this.data = data;
	}
 
}
