package com.ynet.finmall.gateway.yulebao.response;

/**
 * 二类账户的开户
 * 
 * @author liuxin
 *
 */
public class YLBOpenAccResponse extends AbstractYLBResponse {

	private OpenAccInfo data;

	public OpenAccInfo getData() {
		return data;
	}

	public void setData(OpenAccInfo data) {
		this.data = data;
	}

}
