package com.ynet.finmall.gateway.jxbank.response;

import com.ynet.finmall.gateway.yulebao.response.LoadRepayBatch;

/**
 * 贷款归还批量接口返回参数
 * 
 * @author xuhui
 *
 */
public class JxLoanReturnResponse extends AbstractJxBankLoanResponse {

	private LoadRepayBatch data;

	public LoadRepayBatch getData() {
		return data;
	}

	public void setData(LoadRepayBatch data) {
		this.data = data;
	}

}
