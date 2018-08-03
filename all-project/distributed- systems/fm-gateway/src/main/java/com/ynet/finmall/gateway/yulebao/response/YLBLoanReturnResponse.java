package com.ynet.finmall.gateway.yulebao.response;
/**
 * 贷款归还批量接口返回参数
 * @author xuhui
 *
 */
public class YLBLoanReturnResponse extends AbstractYLBResponse {

	private LoadRepayBatch data;

	public LoadRepayBatch getData() {
		return data;
	}

	public void setData(LoadRepayBatch data) {
		this.data = data;
	}
}
