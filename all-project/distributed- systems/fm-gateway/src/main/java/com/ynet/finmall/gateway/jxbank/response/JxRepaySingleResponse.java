package com.ynet.finmall.gateway.jxbank.response;

import com.ynet.finmall.gateway.yulebao.response.RepaySingle;

/**
 * 备注：贷款归还（单笔实时）
 * @author liaoyy@belink.com
 */
public class JxRepaySingleResponse  extends AbstractJxBankLoanResponse {
	private RepaySingle data;

	public RepaySingle getData() {
		return data;
	}

	public void setData(RepaySingle data) {
		this.data = data;
	}
}
