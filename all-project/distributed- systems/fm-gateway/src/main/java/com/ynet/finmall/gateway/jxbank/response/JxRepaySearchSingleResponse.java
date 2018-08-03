package com.ynet.finmall.gateway.jxbank.response;

import com.ynet.finmall.gateway.yulebao.response.YLBRepaySearchSingleInfo;

/**
 * 备注：贷款归还结果查询（单笔）
 * @author liaoyy@belink.com
 */
public class JxRepaySearchSingleResponse extends AbstractJxBankLoanResponse {
	private YLBRepaySearchSingleInfo data;

	public YLBRepaySearchSingleInfo getData() {
		return data;
	}

	public void setData(YLBRepaySearchSingleInfo data) {
		this.data = data;
	}

}
