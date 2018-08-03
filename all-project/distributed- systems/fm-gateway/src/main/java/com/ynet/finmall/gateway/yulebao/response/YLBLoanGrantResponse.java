package com.ynet.finmall.gateway.yulebao.response;

/**
 * 贷款发放返回参数
 * 
 * @author xuhui
 *
 */
public class YLBLoanGrantResponse extends AbstractYLBResponse {
	private YLBLoanGrant data;

	public YLBLoanGrant getData() {
		return data;
	}

	public void setData(YLBLoanGrant data) {
		this.data = data;
	}

}
