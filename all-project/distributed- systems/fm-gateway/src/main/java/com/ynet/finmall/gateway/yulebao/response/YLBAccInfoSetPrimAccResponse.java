package com.ynet.finmall.gateway.yulebao.response;

/**
 * 绑定账号设定
 * 
 * @author hubk
 *
 */
public class YLBAccInfoSetPrimAccResponse extends AbstractYLBResponse {
	private AccInfoSetPrimAccInfo data;

	public AccInfoSetPrimAccInfo getData() {
		return data;
	}

	public void setData(AccInfoSetPrimAccInfo data) {
		this.data = data;
	}

}
