package com.ynet.finmall.gateway.jxbank.response;

import java.util.List;
import java.util.Map;

import com.ynet.finmall.gateway.yulebao.response.RepayBatchInfo;

/**
 * 贷款归还批量接口返回参数
 * 
 * @author xuhui
 *
 */
public class JxLoanReturnQueryResponse extends AbstractJxBankLoanResponse {

	private Map<String,List<RepayBatchInfo>> data;

	public Map<String, List<RepayBatchInfo>> getData() {
		return data;
	}

	public void setData(Map<String, List<RepayBatchInfo>> data) {
		this.data = data;
	}
}
