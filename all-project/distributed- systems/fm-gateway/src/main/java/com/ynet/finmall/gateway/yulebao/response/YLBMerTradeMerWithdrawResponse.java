package com.ynet.finmall.gateway.yulebao.response;

/**
 * 商户取现（娱乐宝）响应参数
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 下午1:57:28
 */
public class YLBMerTradeMerWithdrawResponse extends AbstractYLBResponse {

	private MerTradeMerWithdrawInfo data;

	public MerTradeMerWithdrawInfo getData() {
		return data;
	}

	public void setData(MerTradeMerWithdrawInfo data) {
		this.data = data;
	}

}
