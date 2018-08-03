package com.ynet.finmall.gateway.yulebao.response;

/**
 * 查询交易
 * 
 * @author hubk
 *
 */
public class YLBTradeDetailsQueryTradeInfoResponse extends AbstractYLBResponse {
	private TradeDetailsQueryTradeInfo data;

	public TradeDetailsQueryTradeInfo getData() {
		return data;
	}

	public void setData(TradeDetailsQueryTradeInfo data) {
		this.data = data;
	}

}
