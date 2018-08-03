package com.ynet.finmall.gateway.jxbank.response;

import java.util.List;

import com.ynet.finmall.gateway.yulebao.response.RepayBatchInfo;

/**
 * 贷款归还批量接口返回参数
 * @author xuhui
 *
 */
public class JxYLBLoanReturnQueryResponse extends AbstractJxBankLoanResponse {

	private List<RepayBatchInfo> data;

	public List<RepayBatchInfo> getData() {
		return data;
	}

	public void setData(List<RepayBatchInfo> data) {
		this.data = data;
	}

	
}
