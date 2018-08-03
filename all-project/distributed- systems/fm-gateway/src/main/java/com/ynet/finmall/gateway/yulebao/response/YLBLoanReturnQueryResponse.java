package com.ynet.finmall.gateway.yulebao.response;

import java.util.List;
import java.util.Map;

/**
 * 
 * 备注：贷款归还批量查询
 * 
 * @author liaoyy@belink.com
 */
public class YLBLoanReturnQueryResponse extends AbstractYLBResponse {

	private Map<String,List<RepayBatchInfo>> data;

	public Map<String, List<RepayBatchInfo>> getData() {
		return data;
	}

	public void setData(Map<String, List<RepayBatchInfo>> data) {
		this.data = data;
	}

}
