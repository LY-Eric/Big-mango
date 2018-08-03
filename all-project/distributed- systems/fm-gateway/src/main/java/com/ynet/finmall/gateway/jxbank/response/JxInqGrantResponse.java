package com.ynet.finmall.gateway.jxbank.response;

import com.ynet.finmall.gateway.yulebao.response.InqGrantInfo;

/**
 * 备注：贷款放款查询
 * 
 * @author liaoyy@belink.com
 */
public class JxInqGrantResponse extends AbstractJxBankLoanResponse {
	private InqGrantInfo data;

	public InqGrantInfo getData() {
		return data;
	}

	public void setData(InqGrantInfo data) {
		this.data = data;
	}

	
}
