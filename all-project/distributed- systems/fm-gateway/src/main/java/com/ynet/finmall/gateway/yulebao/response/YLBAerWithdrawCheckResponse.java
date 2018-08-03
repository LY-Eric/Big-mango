package com.ynet.finmall.gateway.yulebao.response;

/**
 * 1.2.21 商户取现查证接口
 * 
 * @author liuxin
 *
 */
public class YLBAerWithdrawCheckResponse extends AbstractYLBResponse {
	private AerWithdrawCheckInfo data;

	public AerWithdrawCheckInfo getData() {
		return data;
	}

	public void setData(AerWithdrawCheckInfo data) {
		this.data = data;
	}

}
